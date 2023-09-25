package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import xtech.qrvenus.entities.concretes.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
