package bdbt_bada_projekt.SpringApplication.models;

import javax.persistence.*;

@Entity
@Table(name = "MAGAZYNY")
public class Magazyny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmagazynu;
    private String nazwa;
    private String email;
    private String telefon;

    public Magazyny(int id_magazynu, String nazwa, String email, String telefon) {
        super();
        this.idmagazynu = id_magazynu;
        this.nazwa = nazwa;
        this.email = email;
        this.telefon = telefon;
    }

    public Magazyny() {
    }

    public int getIdmagazynu() {
        return idmagazynu;
    }

    public void setIdmagazynu(int idmagazynu) {
        this.idmagazynu = idmagazynu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    @Override
    public String toString() {
        return "Magazyny{" +
                "id_magazynu=" + idmagazynu +
                ", nazma='" + nazwa + '\'' +
                ", email='" + email + '\'' +
                ", numer_telefonu='" + telefon + '\'' +
                '}';
    }
}
