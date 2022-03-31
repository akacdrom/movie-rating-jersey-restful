package org.movies;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import javax.persistence.*;

@XmlRootElement
@Entity(name = "movie")
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private int rating;

    @Column(name = "poster")
    private String poster;

    public Movie() {
        super();
    }

    public Movie(String name, int rating, String poster) {
        this.name = name;
        this.rating = rating;
        this.poster = poster;
    }

    public long getId() {
        return id;
    }

    @XmlElement
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    @XmlElement
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    @XmlElement
    public void setPoster(String poster) {
        this.poster = poster;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
