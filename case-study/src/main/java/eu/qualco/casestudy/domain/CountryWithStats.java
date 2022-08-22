package eu.qualco.casestudy.domain;

import lombok.Data;

@Data
public class CountryWithStats {

    private String name;
    private String countryCode3;
    private Integer year;
    private Integer population;
    private Double gdp;
}
