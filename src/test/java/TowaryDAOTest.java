import bdbt_bada_projekt.SpringApplication.DAO.TowaryDAO;
import bdbt_bada_projekt.SpringApplication.models.Towary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TowaryDAOTest {

    private TowaryDAO dao;

    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new TowaryDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<Towary> towaryList = dao.list();
        assertFalse(towaryList.isEmpty());
    }

    @Test
    void save() {
        Towary towary = new Towary(10, "Rezystor test", 8.5, "przewklekany", "Pasywny", 1,1,1);
        dao.save(towary);
    }

    void get() {
        int id = 5;
        Towary towary = dao.get(id);
        assertNotNull(towary);
    }

    @Test
    void update() {
        Towary towary = new Towary();
        towary.setIDTowaru(11);
        towary.setCena(8.5);
        towary.setIDDostawcy(1);
        towary.setIDProducenta(1);
        towary.setNazwa("Rezystor test");
        towary.setRodzajTowaru("Pasywny");
        towary.setTypInstalacji("hz");
        towary.setIDMagazynu(1);
    }

    @Test
    void delete(){
        int id = 5;
        dao.delete(id);
    }
}