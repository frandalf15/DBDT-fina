package bdbt_bada_projekt.SpringApplication.DAO;


import bdbt_bada_projekt.SpringApplication.models.Kort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KortDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public KortDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Kort> list(){
        String sql = "SELECT * FROM Kort";
        List<Kort> listKort = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Kort.class));
        return listKort;
    }

    public void save(Kort korty) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("KORT")
                .usingGeneratedKeyColumns("IDKORTU")
                .usingColumns( "RODZAJNAWIERZCHNI", "ROZMIAR", "DATAPOWSTANIA", "STANTECHNICZNY", "ILOSCMIEJSC", "IDSIEDZIBY", "IDMECZU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(korty);
        Number id = insertAction.executeAndReturnKey(param);
        korty.setIDKortu(id.intValue());
    }

    public Kort get(int IDTOWARU) {
        Object[] args = {IDTOWARU};
        String sql = "SELECT * FROM KORT WHERE IDKORTU = " + args[0];
        Kort kort = jdbcTemplate.queryForObject(sql,
                BeanPropertyRowMapper.newInstance(Kort.class));
        return kort;
    }

    public void update(Kort korty) {
        String sql = "UPDATE KORT SET RODZAJNAWIERZCHNI=:RodzajNawierzchni, ROZMIAR=:rozmiar, " +
                "DATAPOWSTANIA=:DataPowstania, STANTECHNICZNY=:StanTechniczny, ILOSCMIEJSC=:IloscMiejsc, IDSIEDZIBY=:IDSiedziby WHERE IDMECZU=:IDMeczu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(korty);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int IDKORTU) {
//        String sqlKortu = "DELETE FROM KORT WHERE IDKORTU = ?";
//        jdbcTemplate.update(sqlKortu, IDTOWARU);

        String sql = "DELETE FROM KORT WHERE IDKORTU = ?";
        jdbcTemplate.update(sql, IDKORTU);
    }
}
