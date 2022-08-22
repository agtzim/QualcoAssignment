package eu.qualco.casestudy.domain;

import lombok.Data;

@Data
public class FilteredCountry {

    private String continent;
    private String region;
    private String country;
    private Integer year;
    private Integer population;
    private Double gdp;
}
