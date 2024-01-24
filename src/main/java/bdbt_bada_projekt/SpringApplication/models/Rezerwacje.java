package bdbt_bada_projekt.SpringApplication.models;


import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "Rezerwacja_kortu")
public class Rezerwacje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int IDKortu;
    private Date Data;
    private String GodzinaRezerwacji;
    private int IDUser;
    private int IDRezerwacji;


    public Rezerwacje(Date data, String godzinaRezerwacji, int IDUser, int IDKortu) {
        Data = data;
        GodzinaRezerwacji = godzinaRezerwacji;
        this.IDUser = IDUser;
        this.IDKortu = IDKortu;
    }




    public Rezerwacje() {
    }


    public int getIDRezerwacji() {
        return IDRezerwacji;
    }

    public void setIDRezerwacji(int IDRezerwacji) {
        this.IDRezerwacji = IDRezerwacji;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }



    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
    }

    public int getIDKortu() {
        return IDKortu;
    }

    public void setIDKortu(int IDKortu) {
        this.IDKortu = IDKortu;
    }

    public String getGodzinaRezerwacji() {
        return GodzinaRezerwacji;
    }

    public void setGodzinaRezerwacji(String godzinaRezerwacji) {
        GodzinaRezerwacji = godzinaRezerwacji;
    }
}
