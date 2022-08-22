package eu.qualco.casestudy.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Country {

    private Integer countryId;
    private String name;
    private Double area;
    private LocalDate nationalDay;
    private String countryCode2;
    private String countryCode3;
    private Integer regionId;
}
