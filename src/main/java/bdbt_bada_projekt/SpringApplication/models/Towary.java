    package bdbt_bada_projekt.SpringApplication.models;

    import javax.persistence.*;

    @Entity
    @Table(name = "Towary")
    public class Towary {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int IDTowaru;
        private String Nazwa;
        private double Cena;
        private String TypInstalacji;
        private String RodzajTowaru;
        private int IDMagazynu;


        public int getIDMagazynu() {
            return IDMagazynu;
        }

        public void setIDMagazynu(int IDMagazynu) {
            this.IDMagazynu = IDMagazynu;
        }

        public Towary(String nazwa, double cena, String typInstalacji, String rodzajTowaru) {
            Nazwa = nazwa;
            Cena = cena;
            TypInstalacji = typInstalacji;
            RodzajTowaru = rodzajTowaru;
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
    }
