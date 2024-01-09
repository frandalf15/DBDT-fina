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
    private int IDTowaru;
    private String NAZWA;
    private int ILOSC;


    public Zamowienia(Date data, String status, Integer rabat, String reklamacja, int IDUser, int IDTowaru, int ILOSC) {
        Data = data;
        Status = status;
        Rabat = rabat;
        Reklamacja = reklamacja;
        this.IDUser = IDUser;
        this.IDTowaru = IDTowaru;
        ILOSC = ILOSC;
    }

    public Zamowienia(Date data, String status, int IDUser, int IDTowaru, int ILOSC) {
        Data = data;
        Status = status;
        this.IDUser = IDUser;
        this.IDTowaru = IDTowaru;
        this.ILOSC = ILOSC;
    }

    public Zamowienia(Date data, String status, String reklamacja, int IDUser, int IDTowaru, int ILOSC) {
        Data = data;
        Status = status;
        Reklamacja = reklamacja;
        this.IDUser = IDUser;
        this.IDTowaru = IDTowaru;
        this.ILOSC = ILOSC;
    }

    public Zamowienia(Date data, String status, Integer rabat, int IDUser, int IDTowaru, int ILOSC) {
        Data = data;
        Status = status;
        Rabat = rabat;
        this.IDUser = IDUser;
        this.IDTowaru = IDTowaru;
        this.ILOSC = ILOSC;
    }

    public Zamowienia() {
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

    public int getIDTowaru() {
        return IDTowaru;
    }

    public void setIDTowaru(int IDTowaru) {
        this.IDTowaru = IDTowaru;
    }

    public int getILOSC() {
        return ILOSC;
    }

    public void setILOSC(int ILOSC) {
        this.ILOSC = ILOSC;
    }

    public String getNAZWA() {
        return NAZWA;
    }

    public void setNAZWA(String NAZWA) {
        this.NAZWA = NAZWA;
    }
}
