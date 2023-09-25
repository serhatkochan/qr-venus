package xtech.qrvenus.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import xtech.qrvenus.entities.concretes.City;

public interface CityRepository  extends JpaRepository<City, Integer> {
}
