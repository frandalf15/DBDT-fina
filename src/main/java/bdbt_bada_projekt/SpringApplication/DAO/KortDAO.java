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
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Kort> list(){
        String sql = "SELECT * FROM Kort";
        List<Kort> listKort = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Kort.class));
        return listKort;
    }

    public void save(Kort kort) {
        SimpleJdbcInsert insertAction = new SimpleJdbcInsert(jdbcTemplate);
        insertAction.withTableName("KORT")
                .usingGeneratedKeyColumns("IDKORTU")
                .usingColumns( "RODZAJNAWIERZCHNI", "ROZMIAR", "DATAPOWSTANIA", "STANTECHNICZNY", "ILOSCMIEJSC", "IDSIEDZIBY", "IDMECZU");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(kort);
        Number IDKortu = insertAction.executeAndReturnKey(param);
        kort.setIDKortu(IDKortu.intValue());
    }

    public Kort get(int IDKortu) {
        String sql = "SELECT * FROM KORT WHERE IDKORTU = ?" ;
       return jdbcTemplate.queryForObject(sql, new Object[]{IDKortu},
                new BeanPropertyRowMapper<>(Kort.class));

    }

    public void update(Kort kort) {
        String sql = "UPDATE KORT SET RODZAJNAWIERZCHNI= ?, ROZMIAR= ?, " +
                "DATAPOWSTANIA= ?, STANTECHNICZNY= ?, ILOSCMIEJSC= ?, IDSIEDZIBY= ? WHERE IDMECZU= ?";

        jdbcTemplate.update(sql, kort.getRodzajNawierzchni(), kort.getRozmiar(), kort.getDataPowstania(), kort.getStanTechniczny(), kort.getIloscMiejsc(), kort.getIDSiedziby(), kort.getIDMeczu());
    }

    public void delete(int IDKortu) {
//        String sqlKortu = "DELETE FROM KORT WHERE IDKORTU = ?";
//        jdbcTemplate.update(sqlKortu, IDTOWARU);

        String sql = "DELETE FROM KORT WHERE IDKORTU = ?";
        jdbcTemplate.update(sql, IDKortu);
    }
}
