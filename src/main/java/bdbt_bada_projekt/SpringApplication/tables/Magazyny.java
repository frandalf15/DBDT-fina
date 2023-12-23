package bdbt_bada_projekt.SpringApplication.tables;

public class Magazyny {
    private int id_magazynu;
    private String nazma;
    private String email;
    private String numer_telefonu;
    private int id_adresu;

    public Magazyny(int id_magazynu, String nazma, String email, String numer_telefonu, int id_adresu) {
        super();
        this.id_magazynu = id_magazynu;
        this.nazma = nazma;
        this.email = email;
        this.numer_telefonu = numer_telefonu;
        this.id_adresu = id_adresu;
    }

    public Magazyny() {
    }

    public int getId_magazynu() {
        return id_magazynu;
    }

    public void setId_magazynu(int id_magazynu) {
        this.id_magazynu = id_magazynu;
    }

    public String getNazma() {
        return nazma;
    }

    public void setNazma(String nazma) {
        this.nazma = nazma;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    @Override
    public String toString() {
        return "Magazyny{" +
                "id_magazynu=" + id_magazynu +
                ", nazma='" + nazma + '\'' +
                ", email='" + email + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", id_adresu=" + id_adresu +
                '}';
    }
}
