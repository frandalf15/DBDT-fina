package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Rabaty;
import bdbt_bada_projekt.SpringApplication.models.Towary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RabatyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RabatyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Rabaty> list(){
        String sql = "SELECT * FROM RABATY";
        List<Rabaty> listRabaty = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rabaty.class));
        return listRabaty;
    }

    public void save(Rabaty rabaty){
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("RABATY")
                .usingGeneratedKeyColumns("ID")
                .usingColumns( "NAZWA", "RABAT");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rabaty);
        Number id = insertAction.executeAndReturnKey(param);
        rabaty.setId(id.intValue());
    }

    public Rabaty get(int ID) {
        Object[] args = {ID};
        String sql = "SELECT * FROM RABATY WHERE ID = " + args[0];
        Rabaty rabaty = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Rabaty.class));
        return rabaty;
    }

    public void update(Rabaty rabaty) {
        String sql = "UPDATE RABATY SET NAZWA=:nazwa, RABAT=:rabat WHERE ID=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(rabaty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    public void delete(int ID) {
        String sql = "DELETE FROM RABATY WHERE ID = ?";
        jdbcTemplate.update(sql, ID);
    }


    public Rabaty findByNazwa(String nazwa) {
        String sql = "SELECT * FROM Rabaty WHERE nazwa = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nazwa}, new RabatyRowMapper());
    }
    private static final class RabatyRowMapper implements RowMapper<Rabaty> {
        @Override
        public Rabaty mapRow(ResultSet rs, int rowNum) throws SQLException {
            Rabaty rabaty = new Rabaty();
            rabaty.setId(rs.getInt("id"));
            rabaty.setNazwa(rs.getString("nazwa"));
            rabaty.setRabat(rs.getDouble("rabat"));
            return rabaty;
        }
    }
}
