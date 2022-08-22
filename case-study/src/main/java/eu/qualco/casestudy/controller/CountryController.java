package eu.qualco.casestudy.controller;

import eu.qualco.casestudy.domain.CountryWithStats;
import eu.qualco.casestudy.domain.FilteredCountry;
import eu.qualco.casestudy.entity.Country;
import eu.qualco.casestudy.entity.Language;
import eu.qualco.casestudy.repository.CountryMapper;
import eu.qualco.casestudy.repository.CountryRepository;
import eu.qualco.casestudy.repository.FilteredCountryRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class CountryController {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;
    private final FilteredCountryRepository filteredCountryRepository;

    @GetMapping("countries")
    public List<Country> getAllCountries(@RequestParam int page, @RequestParam int pageSize) {
        return countryRepository.findAllLazy(page, pageSize);
    }

    @GetMapping("countries/count")
    public Integer countAllCountries() {
        return countryMapper.countAll();
    }

    @GetMapping("countries/languages/{countryId}")
    public List<Language> getLanguagesOfCountry(@PathVariable int countryId) {
        return countryMapper.findLanguagesByCountry(countryId);
    }

    @GetMapping("countries/stats")
    public List<CountryWithStats> getAllCountriesWithStats() {
        return countryMapper.findAllCountriesWithStats();
    }


    // Task 3
    @GetMapping("countries/search")
    public List<FilteredCountry> getFilteredCountries(@RequestParam int page, @RequestParam int pageSize,
            @RequestParam String region, @RequestParam String startYear, @RequestParam String endYear) {

        return filteredCountryRepository.findByCriteriaLazy(page, pageSize, region, startYear, endYear);
    }

    @GetMapping("countries/search/count")
    public Integer countFilteredCountries(@RequestParam String region, @RequestParam String startYear, @RequestParam String endYear) {
        return filteredCountryRepository.countFilteredCountries(region, startYear, endYear);
    }
}
