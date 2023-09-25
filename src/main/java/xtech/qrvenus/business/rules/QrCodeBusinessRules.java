package xtech.qrvenus.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xtech.qrvenus.core.utilities.exceptions.BusinessException;
import xtech.qrvenus.dataAccess.abstracts.QrCodeRepository;

@Service
@AllArgsConstructor
public class QrCodeBusinessRules {
    private QrCodeRepository qrCodeRepository;

    public void checkIfQrCodeCodeExists(String code) { // kontrol et, eğer qrCode varlığında bu code zaten var mı?
        if (qrCodeRepository.existsByCode(code)) {
            throw new BusinessException("Qr Code Already Exists"); // java exception types
        }
    }

    public void checkIfQrCodeCodeNotExists(String code) {
        if (!qrCodeRepository.existsByCode(code)) {
            throw new BusinessException("Qr code yok");
        }
    }
}
