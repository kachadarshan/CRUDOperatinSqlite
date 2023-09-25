package com.yourbrandname.demosqlite_recyc.Model;

public class Datamodel {

    int id;
    String strname, strphonen;

    public Datamodel(int id, String strname, String strphonen) {
        this.id = id;
        this.strname = strname;
        this.strphonen = strphonen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStrname() {
        return strname;
    }

    public void setStrname(String strname) {
        this.strname = strname;
    }

    public String getStrphonen() {
        return strphonen;
    }

    public void setStrphonen(String strphonen) {
        this.strphonen = strphonen;
    }
}
