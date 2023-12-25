package bdbt_bada_projekt.SpringApplication.models;

public class Adresy {
    private int idadresu;
    private String miejscowosc;
    private String ulica;
    private int nrdomu;
    private String kodpocztowy;

    public Adresy(int idadresu, String miejscowosc, String ulica, int nrdomu, String kodpocztowy) {
        super();
        this.idadresu = idadresu;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nrdomu = nrdomu;
        this.kodpocztowy = kodpocztowy;
    }

    public int getIdadresu() {
        return idadresu;
    }

    public void setIdadresu(int idadresu) {
        this.idadresu = idadresu;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNrdomu() {
        return nrdomu;
    }

    public void setNrdomu(int nrdomu) {
        this.nrdomu = nrdomu;
    }

    public String getKodpocztowy() {
        return kodpocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kodpocztowy = kodpocztowy;
    }

    public Adresy() {
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + idadresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_domu=" + nrdomu +
                ", kodpocztowy='" + kodpocztowy + '\'' +
                '}';
    }
}
