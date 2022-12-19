package com.nhdev.cinema.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Document(collection = "movies")
public class Movie {

    @Id
    private UUID id;

    @Field
    private String title;

    @Field
    private String description;

    @Field
    private double duration;

    @Field
    private double rating;

    @Field
    private List<String> actors;

    @Field
    @DBRef(lazy = true)
    private User user;

    public Movie() {
    }

    public Movie(String title, String description, double duration, double rating, List<String> actors, User user) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.rating = rating;
        this.actors = actors;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", actors=" + actors +
                ", user=" + user +
                '}';
    }
}
