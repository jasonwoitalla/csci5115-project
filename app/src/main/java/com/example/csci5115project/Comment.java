package com.example.csci5115project;

public class Comment {
private int likes;
private int dislikes;
private String comment;
private String commenter;

    public Comment(int likes, int dislikes, String comment, String commenter) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.comment = comment;
        this.commenter = commenter;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
    public void addLike(){
        this.likes+=1;
    }
    public void addDislike(){
        this.dislikes+=1;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
    }
}
