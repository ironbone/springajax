package lu.lllc.ajax.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import lu.lllc.ajax.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	List<Country> findCountriesByCountryNameContains(String sunstring, Pageable pagable);
	
}
