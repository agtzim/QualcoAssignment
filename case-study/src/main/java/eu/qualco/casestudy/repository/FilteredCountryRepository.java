package eu.qualco.casestudy.repository;

import eu.qualco.casestudy.domain.FilteredCountry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FilteredCountryRepository {

    private final SqlSession session;

    public Integer countFilteredCountries(String region, String startYear, String endYear) {
        Map<String, String> params = new HashMap<>();
        params.put("region", region);
        params.put("startYear", startYear);
        params.put("endYear", endYear);

        return session.getMapper(CountryMapper.class).countTask3(params);
    }

    public List<FilteredCountry> findByCriteriaLazy(int page, int pageSize, String region, String startYear, String endYear) {
        Map<String, String> params = new HashMap<>();
        params.put("region", region);
        params.put("startYear", startYear);
        params.put("endYear", endYear);
        return session.selectList("task3", params, new RowBounds(page * pageSize, pageSize));
    }
}
