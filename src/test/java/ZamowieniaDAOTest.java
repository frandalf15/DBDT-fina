import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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

//    @Test
//    void list() {
//        List<Zamowienia> zamowieniaList = dao.list();
//        assertFalse(zamowieniaList.isEmpty());
//    }
//
//    @Test
//    void save() {
//        Zamowienia zamowienia = new Zamowienia(Date.valueOf("2024-01-03"), "Odrzucone",4,1,1);
//        dao.save(zamowienia);
//    }
//
//    @Test
//    void get() {
//        int id = 3;
//        Zamowienia zamowienia = dao.get(id);
//        assertNotNull(zamowienia);
//    }

//    @Test
//    void update() {
//        Zamowienia zamowienia = new Zamowienia();
//
//        zamowienia.setData(Date.valueOf("2024-01-03"));
//        zamowienia.setIDUser(1);
//        zamowienia.setStatus("Odrzucone");
//        zamowienia.setRabat(0);
//        zamowienia.setReklamacja("Brak");
//
//        dao.update(zamowienia);
//    }

    @Test
    void delete() {
        int id = 8;
        dao.delete(id);
    }
}
