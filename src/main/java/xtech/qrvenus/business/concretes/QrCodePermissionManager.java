package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.QrCodePermissionService;
import xtech.qrvenus.business.requests.CreateQrCodePermissionRequest;
import xtech.qrvenus.business.requests.UpdateQrCodePermissionRequest;
import xtech.qrvenus.business.responses.GetAllQrCodePermissionsResponse;
import xtech.qrvenus.business.responses.GetByIdQrCodePermissionResponse;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.dataAccess.abstracts.QrCodePermissionRepository;
import xtech.qrvenus.entities.concretes.QrCodePermission;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QrCodePermissionManager implements QrCodePermissionService {
    private ModelMapperService modelMapperService;
    private QrCodePermissionRepository qrCodePermissionRepository;

    @Override
    public List<GetAllQrCodePermissionsResponse> getAll() {
        List<QrCodePermission> qrCodePermissions = qrCodePermissionRepository.findAll();
        List<GetAllQrCodePermissionsResponse> getAllQrCodePermissionsResponse = qrCodePermissions.stream()
                .map(qrCodePermission -> modelMapperService.forResponse()
                        .map(qrCodePermission, GetAllQrCodePermissionsResponse.class))
                .collect(Collectors.toList());
        return getAllQrCodePermissionsResponse;
    }

    @Override
    public GetByIdQrCodePermissionResponse getById(Integer id) {
        Optional<QrCodePermission> qrCodePermission = qrCodePermissionRepository.findById(id);
        GetByIdQrCodePermissionResponse getByIdQrCodePermissionResponse = modelMapperService.forResponse()
                .map(qrCodePermission, GetByIdQrCodePermissionResponse.class);
        return getByIdQrCodePermissionResponse;
    }

    @Override
    public void add(CreateQrCodePermissionRequest createQrCodePermissionRequest) {
        QrCodePermission qrCodePermission = modelMapperService.forRequest()
                .map(createQrCodePermissionRequest, QrCodePermission.class);
        qrCodePermissionRepository.save(qrCodePermission);
    }

    @Override
    public void update(UpdateQrCodePermissionRequest updateQrCodePermissionRequest) {
        QrCodePermission qrCodePermission = modelMapperService.forRequest()
                .map(updateQrCodePermissionRequest, QrCodePermission.class);
        qrCodePermissionRepository.save(qrCodePermission);
    }

    @Override
    public void delete(Integer id) {
        qrCodePermissionRepository.deleteById(id);
    }
}
