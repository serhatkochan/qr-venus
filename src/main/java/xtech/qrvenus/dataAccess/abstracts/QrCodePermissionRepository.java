package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import xtech.qrvenus.entities.concretes.QrCodePermission;

public interface QrCodePermissionRepository extends JpaRepository<QrCodePermission, Integer> {
}
