package task;

public class SalesMan {

    final String firstname;
    final String lastname;
//    static int idCount = 0;
    final int id;
    final String department;



    public SalesMan(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = "no info";
        this.id = id;
//        this.id = this.idCount++;
    }
    public SalesMan(String firstname, String lastname, int id, String department) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.department = department;
        this.id = id;
//        this.id = this.idCount++;
    }

    @Override
    public String toString() {
        return "SalesMan{" +
                "vorname='" + firstname + '\'' +
                ", nachname='" + lastname + '\'' +
                ", id=" + id +
                ", department='" + department + '\'' +
                '}';
    }
}
