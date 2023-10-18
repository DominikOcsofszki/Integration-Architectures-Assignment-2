package task;

public class SalesMan {

    final String vorname;
    final String nachname;
    static int idCount = 0;
    final int id;
    final String department;


    public SalesMan(String vorname, String nachname, String department) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.department = department;
        this.id = this.idCount++;
    }
}
