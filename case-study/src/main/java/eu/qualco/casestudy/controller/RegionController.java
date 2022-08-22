package eu.qualco.casestudy.controller;

import eu.qualco.casestudy.entity.Region;
import eu.qualco.casestudy.repository.RegionMapper;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class RegionController {

    private final RegionMapper regionMapper;

    @GetMapping("regions")
    List<Region> getAllRegions() {
        return regionMapper.findAll();
    }
}
