package bdbt_bada_projekt.SpringApplication.tables;

import bdbt_bada_projekt.SpringApplication.models.Adresy;
import bdbt_bada_projekt.SpringApplication.models.Magazyny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdresyDAOTest {
    private AdresyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new AdresyDAO(new JdbcTemplate(dataSource));
    }
    @Test
    void list() {
        List<Adresy> adresyList = dao.list();
        assertTrue(!adresyList.isEmpty());
    }
}