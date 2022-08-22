package eu.qualco.casestudy.repository;

import eu.qualco.casestudy.domain.FilteredCountry;
import eu.qualco.casestudy.entity.Country;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CountryRepository {

    private final SqlSession session;

    public List<Country> findAllLazy(int page, int pageSize) {
        return session.selectList("findAllLazy", null, new RowBounds(page * pageSize, pageSize));
    }

}
