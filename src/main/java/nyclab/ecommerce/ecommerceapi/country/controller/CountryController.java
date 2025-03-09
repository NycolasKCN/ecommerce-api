package nyclab.ecommerce.ecommerceapi.country.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import nyclab.ecommerce.ecommerceapi.country.dto.CountryDTO;
import nyclab.ecommerce.ecommerceapi.country.service.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/v1/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public Page<CountryDTO> getCountries(
            Pageable pageable
    ) {
        log.debug("getCountries called with page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());

        Page<CountryDTO> countries = countryService.getCountries(pageable).map(Country::toDTO);

        log.debug("getCountries returned {} countries", countries.getTotalElements());

        return countries;
    }

    @GetMapping("/{id}")
    public CountryDTO getCountry(@PathVariable Integer id) {
        log.debug("getCountry called with id={}", id);
        CountryDTO countryDTO = countryService.getCountry(id).toDTO();
        log.debug("getCountry called with id={}", countryDTO.getId());
        return countryDTO;
    }
}
