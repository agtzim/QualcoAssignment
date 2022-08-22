package eu.qualco.casestudy.repository;

import eu.qualco.casestudy.entity.Region;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegionMapper {

    @Select("select * from regions")
    List<Region> findAll();
}
