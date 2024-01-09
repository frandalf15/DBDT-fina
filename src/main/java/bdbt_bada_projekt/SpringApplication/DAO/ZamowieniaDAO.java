package bdbt_bada_projekt.SpringApplication.DAO;

import bdbt_bada_projekt.SpringApplication.models.Zamowienia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZamowieniaDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ZamowieniaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zamowienia> list() {
        String sql = "SELECT * FROM ZAMOWIENIA";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zamowienia.class));
    }

    public List<Zamowienia> list(Authentication auth) {
        if (auth != null && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            String username = userDetails.getUsername(); // This will give you the username as a String

            // Оновлений SQL запит з JOIN для отримання поля NAZWA з таблиці TOWARY
            String sql = "SELECT z.*, t.NAZWA FROM ZAMOWIENIA z " +
                    "JOIN TOWARY t ON z.IDTOWARU = t.IDTOWARU " +
                    "WHERE z.IDUSER = (SELECT ID FROM USERS WHERE USERNAME = ?)";
            return jdbcTemplate.query(sql, new Object[]{username}, BeanPropertyRowMapper.newInstance(Zamowienia.class));
        }
        return null;
    }


    public void save(Zamowienia zamowienia) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("ZAMOWIENIA")
                .usingGeneratedKeyColumns("IDZAMOWIENIA")
                .usingColumns("DATA", "STATUS", "IDUSER", "RABAT", "REKLAMACJA", "ILOSC", "IDTOWARU", "TOTALPRICE");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        Number id = insertAction.executeAndReturnKey(param);
        zamowienia.setIDZamowienia(id.intValue());
    }

    public Zamowienia get(int IDZAMOWIENIA) {
        Object[] args = {IDZAMOWIENIA};
        String sql = "SELECT * FROM ZAMOWIENIA WHERE IDZAMOWIENIA = ?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zamowienia.class), args);
    }

    public void update(Zamowienia zamowienia) {
        String sql = "UPDATE ZAMOWIENIA SET DATA=:data, STATUS=:status, IDUSER=:IDUSER, " +
                "RABAT=:rabat, REKLAMACJA=:reklamacja, IDTOWARU=:IDTOWARU, ILOSC=:QUANTITY, TOTALPRICE=:TOTALPRICE WHERE IDZAMOWIENIA=:IDZamowienia";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zamowienia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int IDZAMOWIENIA) {
        String sql = "DELETE FROM ZAMOWIENIA WHERE IDZAMOWIENIA = ?";
        jdbcTemplate.update(sql, IDZAMOWIENIA);
    }
}