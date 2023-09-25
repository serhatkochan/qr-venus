package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.CreateQrCodePermissionRequest;
import xtech.qrvenus.business.requests.UpdateQrCodePermissionRequest;
import xtech.qrvenus.business.responses.GetAllQrCodePermissionsResponse;
import xtech.qrvenus.business.responses.GetByIdQrCodePermissionResponse;

import java.util.List;

public interface QrCodePermissionService {
    List<GetAllQrCodePermissionsResponse> getAll();

    GetByIdQrCodePermissionResponse getById(Integer id);

    void add(CreateQrCodePermissionRequest createQrCodePermissionRequest);

    void update(UpdateQrCodePermissionRequest updateQrCodePermissionRequest);

    void delete(Integer id);
}
