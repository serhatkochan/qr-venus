package xtech.qrvenus.business.abstracts;

import xtech.qrvenus.business.requests.UpdateQrCodeRequest;
import xtech.qrvenus.business.responses.GetAllQrCodesResponse;
import xtech.qrvenus.business.responses.GetByCodeQrCodeResponse;
import xtech.qrvenus.business.responses.GetByUserIdQrCodesResponse;

import java.util.List;

public interface QrCodeService {
    List<GetAllQrCodesResponse> getAll();

    GetByCodeQrCodeResponse getByCode(String code);

    void add();

    void update(UpdateQrCodeRequest updateQrCodeRequest);

    void delete(Integer id);

    List<GetByUserIdQrCodesResponse> getByUserId(Integer userId);
}
