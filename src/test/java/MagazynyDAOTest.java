import bdbt_bada_projekt.SpringApplication.models.Magazyny;
import bdbt_bada_projekt.SpringApplication.DAO.MagazynyDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MagazynyDAOTest {

    private MagazynyDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new MagazynyDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Magazyny> magazynyList = dao.list();
        assertTrue(!magazynyList.isEmpty());
    }

    @Test
    void save() {
    }

    @Test
    void get() {
    }

    @Test
    void update() {
        Magazyny magazyny = new Magazyny();
        magazyny.setIdmagazynu(2);
        magazyny.setNazwa("testupdate");
        magazyny.setTelefon("3333");
        magazyny.setEmail("2323");

        dao.update(magazyny);
    }

    @Test
    void delete() {
        int id = 3;
        dao.delete(id);
    }
    @Test
    void deleteCascade() {
        int id = 11;
        dao.deleteCascade(id);
    }


}