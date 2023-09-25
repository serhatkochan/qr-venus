package xtech.qrvenus.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.business.abstracts.QrCodeService;
import xtech.qrvenus.business.requests.UpdateQrCodeRequest;
import xtech.qrvenus.business.responses.GetAllQrCodesResponse;
import xtech.qrvenus.business.responses.GetByCodeQrCodeResponse;
import xtech.qrvenus.business.responses.GetByUserIdQrCodesResponse;
import xtech.qrvenus.business.rules.QrCodeBusinessRules;
import xtech.qrvenus.core.utilities.mappers.ModelMapperService;
import xtech.qrvenus.dataAccess.abstracts.QrCodePermissionRepository;
import xtech.qrvenus.dataAccess.abstracts.QrCodeRepository;
import xtech.qrvenus.entities.concretes.QrCode;
import xtech.qrvenus.entities.concretes.QrCodePermission;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QrCodeManager implements QrCodeService {
    private ModelMapperService modelMapperService;
    private QrCodeRepository qrCodeRepository;
    private QrCodePermissionRepository qrCodePermissionRepository;
    private QrCodeBusinessRules qrCodeBusinessRules;


    @Override
    public List<GetAllQrCodesResponse> getAll() {
        List<QrCode> qrCodes = qrCodeRepository.findAll();
        List<GetAllQrCodesResponse> getAllQrCodesResponses = qrCodes.stream()
                .map(qrCode -> modelMapperService.forResponse()
                        .map(qrCode, GetAllQrCodesResponse.class))
                .collect(Collectors.toList());
        return getAllQrCodesResponses;
    }

    @Override
    public GetByCodeQrCodeResponse getByCode(String code) {
        qrCodeBusinessRules.checkIfQrCodeCodeNotExists(code);
        QrCode qrCode = qrCodeRepository.findByCode(code);
        GetByCodeQrCodeResponse getByCodeQrCodeResponse = modelMapperService.forResponse()
                .map(qrCode, GetByCodeQrCodeResponse.class);
        return getByCodeQrCodeResponse;
    }

    @Override
    public void add() {
        String uniqueCode = UUID.randomUUID().toString();

        QrCode qrCode = new QrCode();
        qrCode.setCode(uniqueCode);
        qrCodeRepository.save(qrCode);
    }

    @Override
    public void update(UpdateQrCodeRequest updateQrCodeRequest) {
        QrCode qrCode = modelMapperService.forRequest().map(updateQrCodeRequest, QrCode.class);
        if (updateQrCodeRequest.getQrCodePermissionIds() != null) {
            List<QrCodePermission> permissions = updateQrCodeRequest.getQrCodePermissionIds().stream()
                    .map(id -> qrCodePermissionRepository.findById(id))
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());
            qrCode.setQrCodePermissions(permissions);  // QrCode entity içinde 'qrCodePermissions' listesi olmalı
        }
        qrCodeRepository.save(qrCode);
    }

    @Override
    public void delete(Integer id) {
        qrCodeRepository.deleteById(id);
    }

    @Override
    public List<GetByUserIdQrCodesResponse> getByUserId(Integer userId) {
        List<QrCode> qrCodes = qrCodeRepository.findByUser_Id(userId);
        List<GetByUserIdQrCodesResponse> getByUserIdQrCodesResponses = qrCodes.stream()
                .map(qrCode -> modelMapperService.forResponse()
                        .map(qrCode, GetByUserIdQrCodesResponse.class))
                .collect(Collectors.toList());
        return getByUserIdQrCodesResponses;
    }
}
