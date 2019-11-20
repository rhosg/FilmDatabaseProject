package com.sparta.pdf.components;


import javax.inject.Inject;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "actor")
@NamedQueries({
        @NamedQuery(
                name = "getActorById",
                query = "SELECT a FROM Actor a WHERE a.actorId = :actorId"
        ),
        @NamedQuery(
                name = "getActorByName",
                query = "SELECT a FROM Actor a WHERE  CONCAT(a.firstName,' ',a.lastName) LIKE CONCAT('%',:enteredName,'%')"
        )
})




public class Actor {

    @Id
    @Column(name = "actor_id")
    private int actorId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> filmList;

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public List<Film> getLimitedFilmList(int max){
        return filmList.subList(0,max);
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
