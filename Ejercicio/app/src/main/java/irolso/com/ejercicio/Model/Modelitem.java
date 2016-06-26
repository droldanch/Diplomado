package irolso.com.ejercicio.Model;

/**
 * Created by Roldan on 19/06/16.
 */
public class Modelitem {
    public int id;
    public String name;
    public String pass;
    public int time;
    public String date;

    public Modelitem(String name, String pass, int time, String date) {
        this.name = name;
        this.pass = pass;
        this.time = time;
        this.date = date;
    }
}
