package com.example.RestWithSQL;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;


@Entity
public class Book {

    @Id
    private Long id;

    @NotBlank(message = "A book must have a title")
    private String title;

    @NotBlank(message = "Every book must have an author")
    private String author;

    @NotBlank(message = "Every book must have an ISBN code")
    private String isbn;

    @NotNull(message = "Published date can't be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String toString(){

        return "Data: " + this.id + " \n " +this.title + "\n "+this.author + "\n " +this.isbn + "\n "+this.publishedDate;
    }
}
