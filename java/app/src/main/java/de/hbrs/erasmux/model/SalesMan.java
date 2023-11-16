package de.hbrs.erasmux.model;

public class SalesMan {

    public final String firstname;
    public final String lastname;
    public final Integer id;



    public SalesMan(String firstname, String lastname, Integer id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    @Override
    public String toString() {
        return "SalesMan{" +
                "vorname='" + firstname + '\'' +
                ", nachname='" + lastname + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        try {
            SalesMan salesMan = (SalesMan) o;
            return salesMan.firstname.equals(this.firstname)&& salesMan.lastname.equals(this.lastname) && salesMan.id == this.id;
        } catch (Exception e) {
            return false;
        }
    }

}
