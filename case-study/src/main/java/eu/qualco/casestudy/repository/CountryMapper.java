package eu.qualco.casestudy.repository;

import eu.qualco.casestudy.domain.CountryWithStats;
import eu.qualco.casestudy.domain.FilteredCountry;
import eu.qualco.casestudy.entity.Country;
import eu.qualco.casestudy.entity.Language;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CountryMapper {

    @Select("select * from countries order by country_id")
    List<Country> findAllLazy();

    @Select("select count(*) from countries")
    Integer countAll();

    @Select("select l.* from countries c"
            + " join country_languages cl on c.country_id = cl.country_id"
            + " join languages l on cl.language_id = l.language_id"
            + " where c.country_id = #{countryId}")
    List<Language> findLanguagesByCountry(Integer countryId);

    @Select("select c.name, c.country_code3, cs.year, cs.gdp, cs.population"
            + " from countries c"
            + " join country_stats cs on c.country_id = cs.country_id"
            + " join (select cs.country_id, max(cs.gdp/cs.population) as gdpPerCapita"
            + " from country_stats cs"
            + " group by cs.country_id) as cigPC on c.country_id = cigPC.country_id"
            + " and (cs.gdp/cs.population) = cigPC.gdpPerCapita")
    List<CountryWithStats> findAllCountriesWithStats();

    @Select("select cn.name as continent, r.name as region, c.name as country, cs.year, cs.population, cs.gdp"
            + " from continents cn"
            + " join regions r on cn.continent_id = r.continent_id"
            + " join countries c on r.region_id = c.region_id"
            + " join country_stats cs on c.country_id = cs.country_id"
            + " where #{region} = '' or (#{region} <> '' and r.name = #{region})"
            + " and (#{startYear} is null or (#{startYear} is not null and cs.year >= #{startYear}))"
            + " and (#{endYear} is null or (#{endYear} is not null and cs.year <= #{endYear}))")
    List<FilteredCountry> task3(Map<String, String> params);

    @Select("select count(*)"
            + " from continents cn"
            + " join regions r on cn.continent_id = r.continent_id"
            + " join countries c on r.region_id = c.region_id"
            + " join country_stats cs on c.country_id = cs.country_id"
            + " where #{region} = '' or (#{region} <> '' and r.name = #{region})"
            + " and (#{startYear} is null or (#{startYear} is not null and cs.year >= #{startYear}))"
            + " and (#{endYear} is null or (#{endYear} is not null and cs.year <= #{endYear}))")
    Integer countTask3(Map<String, String> params);
}
