package bdbt_bada_projekt.SpringApplication.models;

import javax.persistence.*;

@Entity
@Table(name = "Rabaty")
public class Rabaty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nazwa;
    private double rabat;
    public Rabaty(int id, String nazwa, double rabat) {
        this.id = id;
        this.nazwa = nazwa;
        this.rabat = rabat;
    }

    public Rabaty() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getRabat() {
        return rabat;
    }

    public void setRabat(double rabat) {
        this.rabat = rabat;
    }

    @Override
    public String toString() {
        return "Rabaty{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", rabat=" + rabat +
                '}';
    }
}
