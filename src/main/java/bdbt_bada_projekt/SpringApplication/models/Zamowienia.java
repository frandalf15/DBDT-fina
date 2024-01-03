package bdbt_bada_projekt.SpringApplication.models;


import java.sql.Date;

public class Zamowienia {
    private int IDZamowienia;
    private Date Data;
    private String Status;
    private Integer Rabat;
    private String Reklamacja;
    private int IDKlienta;

    public Zamowienia(int IDZamowienia, Date data, String status, Integer rabat, String reklamacja, int IDKlienta) {
        this.IDZamowienia = IDZamowienia;
        Data = data;
        Status = status;
        Rabat = rabat;
        Reklamacja = reklamacja;
        this.IDKlienta = IDKlienta;
    }

    public Zamowienia() {
    }

    public Zamowienia(int IDZamowienia, Date data, String status, int IDKlienta) {
        this.IDZamowienia = IDZamowienia;
        Data = data;
        Status = status;
        this.IDKlienta = IDKlienta;
    }

    public Zamowienia(int IDZamowienia, Date data, String status, Integer rabat, int IDKlienta) {
        this.IDZamowienia = IDZamowienia;
        Data = data;
        Status = status;
        Rabat = rabat;
        this.IDKlienta = IDKlienta;
    }

    public Zamowienia(int IDZamowienia, Date data, String status, String reklamacja, int IDKlienta) {
        this.IDZamowienia = IDZamowienia;
        Data = data;
        Status = status;
        Reklamacja = reklamacja;
        this.IDKlienta = IDKlienta;
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

    public int getIDKlienta() {
        return IDKlienta;
    }

    public void setIDKlienta(int IDKlienta) {
        this.IDKlienta = IDKlienta;
    }
}
