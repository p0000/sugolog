package com.jal.stela.example.dto;

public class CommentDto {

    public CommentDto() {
    }

    String author;

    String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
