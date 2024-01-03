import bdbt_bada_projekt.SpringApplication.DAO.AdresyDAO;
import bdbt_bada_projekt.SpringApplication.DAO.OplatyDAO;
import bdbt_bada_projekt.SpringApplication.models.Oplaty;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OplatyDAOTest {
    private OplatyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new OplatyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Oplaty> oplatyList = dao.list();
        assertFalse(oplatyList.isEmpty());
    }

    @Test
    void save() {
        Oplaty oplaty = new Oplaty(6, new Date(System.currentTimeMillis()), 100, "Przelew", 6);
        dao.save(oplaty);

        Oplaty retrieved = dao.get(6);
        assertEquals(oplaty.getKwota(), retrieved.getKwota());
    }

    @Test
    void get() {
        int id = 6;
        Oplaty oplaty = dao.get(id);
        assertNotNull(oplaty);
    }

    @Test
    void update() {
        Oplaty oplaty = dao.get(6);
        oplaty.setKwota(100);
        dao.update(oplaty);

        Oplaty updated = dao.get(6);
        assertEquals(100, updated.getKwota());
    }

    @Test
    void delete() {
        int id = 6;
        dao.delete(id);
    }
}
