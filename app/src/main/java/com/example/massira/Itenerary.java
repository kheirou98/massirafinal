package com.example.massira;

import java.util.Date;

public class Itenerary {
    private int uid ;
    private String Name;
    private String Description ;
    private String Created_at ;
    private String updated_at ;
    private String gps ;
    private int userid ;

    public String getGps() {
        return gps;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int getUserid() {
        return userid;
    }


    public Itenerary( String name, String description, String created_at, String updated_at,String gps, int userid) {

        this.Name = name;
        this.Description = description;
        this.Created_at = created_at;
        this.updated_at = updated_at;
        this.gps = gps ;
        this.userid = userid;
    }

    public int getUid() {
        return uid;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return Description;
    }

    public String getCreated_at() {
        return Created_at;
    }
}
