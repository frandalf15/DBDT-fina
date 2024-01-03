import bdbt_bada_projekt.SpringApplication.DAO.AdresyDAO;
import bdbt_bada_projekt.SpringApplication.DAO.ZamowieniaDAO;
import bdbt_bada_projekt.SpringApplication.models.Zamowienia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ZamowieniaDAOTest {

    private ZamowieniaDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new ZamowieniaDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Zamowienia> zamowieniaList = dao.list();
        assertFalse(zamowieniaList.isEmpty());
    }

    @Test
    void save() {
        Zamowienia zamowienia = new Zamowienia(9, Date.valueOf("2024-01-03"), "Odrzucone",1);
        dao.save(zamowienia);
    }

    @Test
    void get() {
        int id = 3;
        Zamowienia zamowienia = dao.get(id);
        assertNotNull(zamowienia);
    }

    @Test
    void update() {
        Zamowienia zamowienia = new Zamowienia();

        zamowienia.setIDZamowienia(6);
        zamowienia.setData(Date.valueOf("2024-01-03"));
        zamowienia.setIDKlienta(1);
        zamowienia.setStatus("Odrzucone");
        zamowienia.setRabat(0);
        zamowienia.setReklamacja("Brak");

        dao.update(zamowienia);
    }

    @Test
    void delete() {
        int id = 8;
        dao.delete(id);
    }
}
