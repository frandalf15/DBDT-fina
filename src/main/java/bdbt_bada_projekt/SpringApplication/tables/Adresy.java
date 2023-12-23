package bdbt_bada_projekt.SpringApplication.tables;

public class Adresy {
    private int id_adresu;
    private String miejscowosc;
    private String ulica;
    private int nr_domu;
    private String kod_pocztowy;

    public Adresy(int id_adresu, String miejscowosc, String ulica, int nr_domu, String kod_pocztowy) {
        super();
        this.id_adresu = id_adresu;
        this.miejscowosc = miejscowosc;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.kod_pocztowy = kod_pocztowy;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
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

    public int getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(int nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getKodpocztowy() {
        return kod_pocztowy;
    }

    public void setKodpocztowy(String kodpocztowy) {
        this.kod_pocztowy = kodpocztowy;
    }

    public Adresy() {
    }

    @Override
    public String toString() {
        return "Adresy{" +
                "id_adresu=" + id_adresu +
                ", miejscowosc='" + miejscowosc + '\'' +
                ", ulica='" + ulica + '\'' +
                ", nr_domu=" + nr_domu +
                ", kodpocztowy='" + kod_pocztowy + '\'' +
                '}';
    }
}
