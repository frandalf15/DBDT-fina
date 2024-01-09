import bdbt_bada_projekt.SpringApplication.DAO.TowaryDAO;
import bdbt_bada_projekt.SpringApplication.DAO.UserDAO;
import bdbt_bada_projekt.SpringApplication.models.Towary;
import bdbt_bada_projekt.SpringApplication.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO dao;


    @BeforeEach
    void setUp() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("ARTUR");
        dataSource.setPassword("ARTUR");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new UserDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {
        List<User> userList = dao.list();
        assertFalse(userList.isEmpty());
    }



    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}