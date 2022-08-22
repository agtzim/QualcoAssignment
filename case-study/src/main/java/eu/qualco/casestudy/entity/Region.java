package eu.qualco.casestudy.entity;

import lombok.Data;

@Data
public class Region {

    private Integer regionId;
    private String name;
    private Integer continentId;
}
