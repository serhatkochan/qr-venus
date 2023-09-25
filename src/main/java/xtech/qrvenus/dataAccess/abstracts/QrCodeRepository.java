package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import xtech.qrvenus.entities.concretes.QrCode;

import java.util.List;

public interface QrCodeRepository extends JpaRepository<QrCode, Integer> {
    boolean existsByCode(String code); // spring Jpa keyword
    QrCode findByCode(String code);

    List<QrCode> findByUser_Id(Integer userId);

}
