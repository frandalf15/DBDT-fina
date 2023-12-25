package bdbt_bada_projekt.SpringApplication.tables;

import bdbt_bada_projekt.SpringApplication.models.Adresy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
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
    }
    public Adresy get(int id) {
        return null;
    }
    public void update(Adresy adresy) {
    }
    public void delete(int id) {
    }


}
