package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import xtech.qrvenus.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByOrderByIdAsc();
    boolean existsByPhoneNumber(String phoneNumber);
    User findByPhoneNumber(String phoneNumber);
    boolean existsByIdAndPhoneNumber(Integer id, String phoneNumber);
}
