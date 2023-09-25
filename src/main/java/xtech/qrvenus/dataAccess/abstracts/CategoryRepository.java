package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xtech.qrvenus.entities.concretes.Category;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c JOIN c.qrCodes q WHERE q.user.id = :userId ORDER BY c.id ASC")
    List<Category> findByUserIdOrderByIdAsc(@Param("userId") Integer userId);
}
