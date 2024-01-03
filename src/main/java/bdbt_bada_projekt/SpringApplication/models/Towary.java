package bdbt_bada_projekt.SpringApplication.models;

public class Towary {
    private int IDTowaru;
    private String Nazwa;
    private double Cena;
    private String TypInstalacji;
    private String RodzajTowaru;
    private int IDMagazynu;
    private int IDDostawcy;
    private int IDProducenta;

    public Towary(int IDTowaru, String nazwa, double cena, String typInstalacji, String rodzajTowaru, int IDMagazynu, int IDDostawcy, int IDProducenta) {
        this.IDTowaru = IDTowaru;
        Nazwa = nazwa;
        Cena = cena;
        TypInstalacji = typInstalacji;
        RodzajTowaru = rodzajTowaru;
        this.IDMagazynu = IDMagazynu;
        this.IDDostawcy = IDDostawcy;
        this.IDProducenta = IDProducenta;
    }

    public Towary() {
    }



    public int getIDTowaru() {
        return IDTowaru;
    }

    public void setIDTowaru(int IDTowaru) {
        this.IDTowaru = IDTowaru;
    }

    public String getNazwa() {
        return Nazwa;
    }

    public void setNazwa(String nazwa) {
        Nazwa = nazwa;
    }

    public float getCena() {
        return (float) Cena;
    }

    public void setCena(double cena) {
        Cena = cena;
    }

    public String getTypInstalacji() {
        return TypInstalacji;
    }

    public void setTypInstalacji(String typInstalacji) {
        TypInstalacji = typInstalacji;
    }

    public String getRodzajTowaru() {
        return RodzajTowaru;
    }

    public void setRodzajTowaru(String rodzajTowaru) {
        RodzajTowaru = rodzajTowaru;
    }

    public int getIDMagazynu() {
        return IDMagazynu;
    }

    public void setIDMagazynu(int IDMagazynu) {
        this.IDMagazynu = IDMagazynu;
    }

    public int getIDDostawcy() {
        return IDDostawcy;
    }

    public void setIDDostawcy(int IDDostawcy) {
        this.IDDostawcy = IDDostawcy;
    }

    public int getIDProducenta() {
        return IDProducenta;
    }

    public void setIDProducenta(int IDProducenta) {
        this.IDProducenta = IDProducenta;
    }
}
