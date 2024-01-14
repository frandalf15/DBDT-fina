package bdbt_bada_projekt.SpringApplication.Repositories;

import bdbt_bada_projekt.SpringApplication.models.Rabaty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabatyRepository extends JpaRepository<Rabaty, Integer> {
    Rabaty findByNazwa(String nazwa);
}
