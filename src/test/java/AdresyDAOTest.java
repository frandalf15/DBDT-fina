import bdbt_bada_projekt.SpringApplication.models.Adresy;
import bdbt_bada_projekt.SpringApplication.models.Magazyny;
import bdbt_bada_projekt.SpringApplication.tables.AdresyDAO;
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
        assertFalse(adresyList.isEmpty());
    }

    @Test
    void save() {
        Adresy adres = new Adresy(10, "Poznan", "Hz", 3, "33-333");
        dao.save(adres);
    }


    @Test
    void get() {
        int id = 5;
        Adresy adresy = dao.get(id);
        assertNotNull(adresy);
    }

    @Test
    void update(){
        Adresy adresy = new Adresy();
        adresy.setIdadresu(10);
        adresy.setMiejscowosc("Hello");
        adresy.setKodpocztowy("444");
        adresy.setNrdomu(3);
        adresy.setUlica("mine");

        dao.update(adresy);
    }
    @Test
    void delete(){
        int id = 8;
        dao.delete(id);
    }

}