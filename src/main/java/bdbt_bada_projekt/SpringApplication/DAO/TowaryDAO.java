package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Towary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TowaryDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TowaryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Towary> list(){
        String sql = "SELECT * FROM TOWARY";
        List<Towary> listTowary = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Towary.class));
        return listTowary;
    }

    public void save(Towary towary) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("TOWARY")
                .usingGeneratedKeyColumns("IDTOWARU")
                .usingColumns( "NAZWA", "CENA", "TYPINSTALACJI", "RODZAJTOWARU", "IDMAGAZYNU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(towary);
        Number id = insertAction.executeAndReturnKey(param);
        towary.setIDTowaru(id.intValue());
    }

    public Towary get(int IDTOWARU) {
        Object[] args = {IDTOWARU};
        String sql = "SELECT * FROM TOWARY WHERE IDTOWARU = " + args[0];
        Towary towary = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Towary.class));
        return towary;
    }

    public void update(Towary towary) {
        String sql = "UPDATE TOWARY SET NAZWA=:nazwa, CENA=:cena, " +
                "TYPINSTALACJI=:TypInstalacji, RODZAJTOWARU=:RodzajTowaru, IDMAGAZYNU=:IDMagazynu WHERE IDTOWARU=:IDTowaru";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(towary);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int IDTOWARU) {
        String sql = "DELETE FROM TOWARY WHERE IDTOWARU = ?";
        jdbcTemplate.update(sql, IDTOWARU);
    }

}
