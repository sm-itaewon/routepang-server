package kr.sm.itaewon.travelmaker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Article{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="article_id")
    private int id;

    @NotNull
    @Column(name="location_id")
    private int location_id;

    @NotNull
    @Column(name="user_id")
    private int user_id;

    @Column(name="image")
    private String image;

    @Column(name="summary")
    private String summary;

    @Column(name="link")
    private String link;

    @Column(name="reg_date")
    private Timestamp reg_date;

}