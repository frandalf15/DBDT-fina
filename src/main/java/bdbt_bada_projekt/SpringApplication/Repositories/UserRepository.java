package bdbt_bada_projekt.SpringApplication.Repositories;


import bdbt_bada_projekt.SpringApplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
