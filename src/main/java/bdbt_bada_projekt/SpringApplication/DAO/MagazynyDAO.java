package bdbt_bada_projekt.SpringApplication.DAO;
import bdbt_bada_projekt.SpringApplication.models.Magazyny;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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
    }
    public Magazyny get(int id) {
        return null;
    }
    public void update(Magazyny magazyny) {
    }
    public void delete(int id) {
    }



}
