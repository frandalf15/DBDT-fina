package bdbt_bada_projekt.SpringApplication.DAO;
import bdbt_bada_projekt.SpringApplication.models.Magazyny;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MagazynyDAO {
    private JdbcTemplate jdbcTemplate;

    public MagazynyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Magazyny> list(){
        String sql = "SELECT * FROM MAGAZYNY";
        List<Magazyny> magazynyList = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Magazyny.class));
        return magazynyList;
    }


    public void save(Magazyny magazyny) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("MAGAZYNY")
                .usingGeneratedKeyColumns("IDMAGAZYNU")
                .usingColumns( "NAZWA", "EMAIL", "TELEFON");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(magazyny);
        Number id = insertAction.executeAndReturnKey(param);
        magazyny.setIdmagazynu(id.intValue());
    }

    public Magazyny get(int id) {
        String sql = "SELECT * FROM MAGAZYNY WHERE IDMAGAZYNU = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Magazyny.class));
    }

    public void update(Magazyny magazyny) {
        String sql = "UPDATE MAGAZYNY SET NAZWA = ?, EMAIL = ?, TELEFON = ? WHERE IDMAGAZYNU = ?";
        jdbcTemplate.update(sql, magazyny.getNazwa(), magazyny.getEmail(), magazyny.getTelefon(), magazyny.getIdmagazynu());
    }

    public void delete(int IDMAGAZYNU) {
        String sql = "DELETE FROM MAGAZYNY WHERE IDMAGAZYNU = ?";
        jdbcTemplate.update(sql, IDMAGAZYNU);
    }

}
