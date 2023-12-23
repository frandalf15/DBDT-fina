package bdbt_bada_projekt.SpringApplication.tables;
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

        String sql = "SELECT * FROM ADRESY";

        List<Magazyny> listMagazyny = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Magazyny.class));

        return listMagazyny;
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
