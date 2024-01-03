package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Oplaty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OplatyDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OplatyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Oplaty> list() {
        String sql = "SELECT * FROM OPLATY";
        return jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Oplaty.class));
    }

    public void save(Oplaty oplaty) {
        String sql = "INSERT INTO OPLATY (IDOplaty, Data, Kwota, SposobRealizacji, IDZamowienia) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, oplaty.getIDOplaty(), oplaty.getData(), oplaty.getKwota(),
                oplaty.getSposobRealizacji(), oplaty.getIDZamowienia());
    }

    public Oplaty get(int IDOplaty) {
        String sql = "SELECT * FROM OPLATY WHERE IDOplaty = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{IDOplaty},
                BeanPropertyRowMapper.newInstance(Oplaty.class));
    }

    public void update(Oplaty oplaty) {
        String sql = "UPDATE OPLATY SET Data = ?, Kwota = ?, SposobRealizacji = ?, IDZamowienia = ? WHERE IDOplaty = ?";
        jdbcTemplate.update(sql, oplaty.getData(), oplaty.getKwota(),
                oplaty.getSposobRealizacji(), oplaty.getIDZamowienia(), oplaty.getIDOplaty());
    }

    public void delete(int IDOplaty) {
        String sql = "DELETE FROM OPLATY WHERE IDOplaty = ?";
        jdbcTemplate.update(sql, IDOplaty);
    }
}
