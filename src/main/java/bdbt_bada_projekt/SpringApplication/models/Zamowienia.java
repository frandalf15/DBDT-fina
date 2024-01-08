package bdbt_bada_projekt.SpringApplication.models;


import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "Zamowienia")
public class Zamowienia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDZamowienia;
    private Date Data;
    private String Status;
    private Integer Rabat;
    private String Reklamacja;
    private int IDUser;

    public Zamowienia(Date data, String status, Integer rabat, String reklamacja, int IDUser) {
        Data = data;
        Status = status;
        Rabat = rabat;
        Reklamacja = reklamacja;
        this.IDUser = IDUser;
    }

    public Zamowienia() {
    }

    public Zamowienia(Date data, String status, int IDUser) {
        Data = data;
        Status = status;
        this.IDUser = IDUser;
    }

    public Zamowienia(Date data, String status, Integer rabat, int IDUser) {
        Data = data;
        Status = status;
        Rabat = rabat;
        this.IDUser = IDUser;
    }

    public Zamowienia(Date data, String status, String reklamacja, int IDUser) {
        Data = data;
        Status = status;
        Reklamacja = reklamacja;
        this.IDUser = IDUser;
    }

    public int getIDZamowienia() {
        return IDZamowienia;
    }

    public void setIDZamowienia(int IDZamowienia) {
        this.IDZamowienia = IDZamowienia;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getRabat() {
        return Rabat;
    }

    public void setRabat(Integer rabat) {
        Rabat = rabat;
    }

    public String getReklamacja() {
        return Reklamacja;
    }

    public void setReklamacja(String reklamacja) {
        Reklamacja = reklamacja;
    }

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }
}
