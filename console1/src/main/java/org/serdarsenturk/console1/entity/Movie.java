package org.serdarsenturk.console1.entity;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// Movie Entity class. I'll use this class to serialize and DAO class

@Entity(name = "Movie")
@Table(name = "Movie")
public class Movie implements Serializable {

    //Bind (id) Primary key in mysql "Movie" table.
    @Id
    @Column(name = "id")
    public Integer id;

    //Bind to name column in mysql "Movie" table.
    @Column(name = "name")
    public String name;

    //Bind to budget column in mysql "Movie" table.
    @Column(name = "budget")
    public Integer budget;

    //Bind to revenues column in mysql "Movie" table.
    @Column(name = "revenues")
    public Integer revenues;

    //Bind to Name comments in mysql "Movie" table.
    //TODO : Change comments type String to List
    @Column(name = "comments")
    public String comments;

    //Getter-Setters
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getBudget(){
        return this.budget;
    }

    public void setBudget(Integer budget){
        this.budget = budget;
    }

    public Integer getRevenues(){
        return this.revenues;
    }

    public void setRevenues(Integer revenues){
        this.revenues = revenues;
    }

    //TODO : Return comments form of Json
    public String getComments(){
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
