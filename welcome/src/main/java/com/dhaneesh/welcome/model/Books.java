package com.dhaneesh.welcome.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
public class Books {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    @NotNull
    private String book;

    public Books(){

    }
    public Books(int id,String books){
        this.id=id;
        this.book=book;
    }

    public int getId(){
    return id;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public String getBook(){
        return book;
    }
    public void setBook(String book)
    {
        this.book=book;
    }
}
