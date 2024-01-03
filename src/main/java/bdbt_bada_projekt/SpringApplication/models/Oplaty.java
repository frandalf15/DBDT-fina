package bdbt_bada_projekt.SpringApplication.models;

import java.sql.Date;

public class Oplaty {
    private int IDOplaty;
    private Date Data;
    private int Kwota;
    private String SposobRealizacji;
    private int IDZamowienia;

    public Oplaty(int IDOplaty, Date data, int kwota, String sposobRealizacji, int IDZamowienia) {
        this.IDOplaty = IDOplaty;
        Data = data;
        Kwota = kwota;
        SposobRealizacji = sposobRealizacji;
        this.IDZamowienia = IDZamowienia;
    }

    public Oplaty() {
    }

    public Oplaty(int IDOplaty, int kwota, String sposobRealizacji, int IDZamowienia) {
        this.IDOplaty = IDOplaty;
        Kwota = kwota;
        SposobRealizacji = sposobRealizacji;
        this.IDZamowienia = IDZamowienia;
    }

    public int getIDOplaty() {
        return IDOplaty;
    }

    public void setIDOplaty(int IDOplaty) {
        this.IDOplaty = IDOplaty;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public int getKwota() {
        return Kwota;
    }

    public void setKwota(int kwota) {
        Kwota = kwota;
    }

    public String getSposobRealizacji() {
        return SposobRealizacji;
    }

    public void setSposobRealizacji(String sposobRealizacji) {
        SposobRealizacji = sposobRealizacji;
    }

    public int getIDZamowienia() {
        return IDZamowienia;
    }

    public void setIDZamowienia(int IDZamowienia) {
        this.IDZamowienia = IDZamowienia;
    }

    @Override
    public String toString() {
        return "Oplaty{" +
                "IDOplaty=" + IDOplaty +
                ", Data=" + Data +
                ", Kwota=" + Kwota +
                ", SposobRealizacji='" + SposobRealizacji + '\'' +
                ", IDZamowienia=" + IDZamowienia +
                '}';
    }
}
