package com.glc.bookapi;



import lombok.Getter;

@Getter
public class Book {
   private int id;
   private String title;
   private String author;
   private int year;
   private int length;
   
    public Book(){

    }


    public Book(int id,String title,String author,int year,int length){
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.length = length;
    }

    

}
