package it.gunnegan.entity;

import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.LocalDate;
import org.hibernate.annotations.Type;

import it.gunnegan.entity.types.Category;

@Entity
@Table(name = "MATCH")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category Category;
    
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @Column(name = "MATCH_DATE")
    private LocalDate matchDate;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalTime")
    @Column(name = "MATCH_TIME")
    private LocalTime matchTime;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "CHAMPIONSHIP_DAY")
    private String championshipDay;

    @Column(name = "HOME_TEAM")
    private String homeTeam;

    @Column(name = "AWAY_TEAM")
    private String awayTeam;

    public Category getCategory() {
        return Category;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getMatchDate() {
        return matchDate;
    }

    public LocalTime getMatchTime() {
        return matchTime;
    }

    public void setCategory(Category category) {
        this.Category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMatchDate(LocalDate matchDate) {
        this.matchDate = matchDate;
    }

    public void setMatchTime(LocalTime matchTime) {
        this.matchTime = matchTime;
    }
}