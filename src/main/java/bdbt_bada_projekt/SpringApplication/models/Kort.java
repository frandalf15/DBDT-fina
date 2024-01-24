package bdbt_bada_projekt.SpringApplication.models;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "Kort")
public class Kort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDKortu;
    private int Rozmiar;
    private Date DataPowstania;
    private String StanTechniczny;
    private int IloscMiejsc;
    private int IDSiedziby;
    private int IDMeczu;

    private String RodzajNawierzchni;
    public String getRodzajNawierzchni() {
        return RodzajNawierzchni;
    }

    public void setRodzajNawierzchni(String rodzajNawierzchni) {
        RodzajNawierzchni = rodzajNawierzchni;
    }



    public int getIDKortu() {
        return IDKortu;
    }

    public void setIDKortu(int IDKortu) {
        this.IDKortu = IDKortu;
    }

    public int getRozmiar() {
        return Rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        Rozmiar = rozmiar;
    }

    public Date getDataPowstania() {
        return DataPowstania;
    }

    public void setDataPowstania(Date dataPowstania) {
        DataPowstania = dataPowstania;
    }

    public String getStanTechniczny() {
        return StanTechniczny;
    }

    public void setStanTechniczny(String stanTechniczny) {
        StanTechniczny = stanTechniczny;
    }

    public int getIloscMiejsc() {
        return IloscMiejsc;
    }

    public void setIloscMiejsc(int iloscMiejsc) {
        IloscMiejsc = iloscMiejsc;
    }

    public int getIDSiedziby() {
        return IDSiedziby;
    }

    public void setIDSiedziby(int IDSiedziby) {
        this.IDSiedziby = IDSiedziby;
    }

    public int getIDMeczu() {
        return IDMeczu;
    }

    public void setIDMeczu(int IDMeczu) {
        this.IDMeczu = IDMeczu;
    }

    public Kort(int rozmiar, Date dataPowstania, String stanTechniczny, int iloscMiejsc, int IDSiedziby, int IDMeczu) {
        Rozmiar = rozmiar;
        DataPowstania = dataPowstania;
        StanTechniczny = stanTechniczny;
        IloscMiejsc = iloscMiejsc;
        this.IDSiedziby = IDSiedziby;
        this.IDMeczu = IDMeczu;
    }

    @Override
    public String toString() {
        return "Kort{" +
                "Rozmiar=" + Rozmiar +
                ", DataPowstania=" + DataPowstania +
                ", StanTechniczny='" + StanTechniczny + '\'' +
                ", IloscMiejsc=" + IloscMiejsc +
                ", IDSiedziby=" + IDSiedziby +
                ", IDMeczu=" + IDMeczu +
                '}';
    }
}
