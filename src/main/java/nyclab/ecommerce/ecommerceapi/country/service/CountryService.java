package nyclab.ecommerce.ecommerceapi.country.service;

import nyclab.ecommerce.ecommerceapi.country.domain.Country;
import nyclab.ecommerce.ecommerceapi.country.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Page<Country> getCountries(Pageable pageable) {
        return countryRepository.findAll(pageable);
    }

    public Country getCountry(Integer id) {
        return countryRepository.findById(id).orElseThrow(() -> new RuntimeException("Country not found"));
    }

}
