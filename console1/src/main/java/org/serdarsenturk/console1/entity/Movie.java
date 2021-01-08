package org.serdarsenturk.console1.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Movie Entity class. I'll use this class to serialize and DAO class
public class Movie{
    private int id;
    private String name;
    private Date releaseDate;
    private int budget;
    private int revenues;
    private List<String> comments = new ArrayList<>();

    // ToDo : Getter-Setters

}
