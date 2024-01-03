package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Adresy> list(){
        String sql = "SELECT * FROM ADRESY";
        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }
    public void save(Adresy adresy) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("ADRESY").usingColumns("IDADRESU", "MIEJSCOWOSC", "ULICA", "NRDOMU", "KODPOCZTOWY");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertAction.execute(param);
    }

    public Adresy get(int IDADRESU) {
        Object[] args = {IDADRESU};
        String sql = "SELECT * FROM ADRESY WHERE IDADRESU = " + args[0];
        Adresy adresy = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }

    public void update(Adresy adresy) {
        String sql = "UPDATE ADRESY SET MIEJSCOWOSC=:miejscowosc, ULICA=:ulica, " +
                "NRDOMU=:nrdomu, KODPOCZTOWY=:kodpocztowy WHERE IDADRESU=:idadresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }
    public void delete(int IDADRESU) {
        String sql = "DELETE FROM ADRESY WHERE IDADRESU = ?";
        jdbcTemplate.update(sql, IDADRESU);
    }


}
