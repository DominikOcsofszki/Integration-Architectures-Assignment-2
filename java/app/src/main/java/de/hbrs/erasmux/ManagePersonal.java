package de.hbrs.erasmux;

import de.hbrs.erasmux.model.SalesMan;

import java.util.List;

public interface ManagePersonal {

    //Salesman

    public void createSalesMan( SalesMan salesMan );

    public SalesMan readSalesMan( int sid );

    public List<SalesMan> querySalesMan(String attribute , String key );

    public void updateSalesMan( int sid, SalesMan updatedSalesMan );

    public void deleteSalesMan( int sid );

    //Performance Record



}
