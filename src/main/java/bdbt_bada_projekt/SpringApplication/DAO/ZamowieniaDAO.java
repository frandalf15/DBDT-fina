package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Zamowienia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZamowieniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZamowieniaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zamowienia> list() {
        String sql = "SELECT * FROM ZAMOWIENIA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zamowienia.class));
    }

    public void save(Zamowienia zamowienia) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("ZAMOWIENIA").usingColumns("IDZAMOWIENIA", "DATA", "STATUS", "IDKLIENTA", "RABAT", "REKLAMACJA");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        insertAction.execute(param);
    }

    public Zamowienia get(int IDZAMOWIENIA) {
        Object[] args = {IDZAMOWIENIA};
        String sql = "SELECT * FROM ZAMOWIENIA WHERE IDZAMOWIENIA = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zamowienia.class), args);
    }

    public void update(Zamowienia zamowienia) {
        String sql = "UPDATE ZAMOWIENIA SET DATA=:data, STATUS=:status, IDKLIENTA=:IDKlienta, " +
                "RABAT=:rabat, REKLAMACJA=:reklamacja WHERE IDZAMOWIENIA=:IDZamowienia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }


    public void delete(int IDZAMOWIENIA) {
        String sql = "DELETE FROM ZAMOWIENIA WHERE IDZAMOWIENIA = ?";
        jdbcTemplate.update(sql, IDZAMOWIENIA);
    }
}
