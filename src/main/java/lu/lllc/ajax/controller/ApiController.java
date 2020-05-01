package lu.lllc.ajax.controller;

import java.util.List;

import org.hibernate.annotations.MetaValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lu.lllc.ajax.entity.Country;
import lu.lllc.ajax.entity.CountryRequest;
import lu.lllc.ajax.repository.CountryRepository;

//Add the @CrossOrigin annotation if you want to be able to use
//your Rest API from a web page which does not come from your server, 
//or from a mobile application
//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private CountryRepository countryRepository;

	@PostMapping("/countries")
	List<Country> get(@RequestBody CountryRequest request) {
		List<Country> countries = countryRepository.findCountriesByCountryNameContains(request.getSubstring(),
				PageRequest.of(0, request.getSize(), Sort.by("countryName")));
		return countries;
	}

	// Now we prepare the JSON string
	@PostMapping("/ourJSON")
	String get2(@RequestBody CountryRequest request) {
		List<Country> countries = countryRepository.findCountriesByCountryNameContains(request.getSubstring(),
				PageRequest.of(0, request.getSize(), Sort.by("countryName")));
		ObjectMapper mapper = new ObjectMapper();

		String jString = "";
		try {
			jString = mapper.writeValueAsString(countries);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jString;
	}

}
