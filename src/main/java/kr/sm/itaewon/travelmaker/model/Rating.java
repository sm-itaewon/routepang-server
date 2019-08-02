package kr.sm.itaewon.travelmaker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rating_id")
    private int id;

    @Column(name="location_id")
    private int location_id;

    @Column(name="customer_id")
    private int customer_id;

    @Column(name="rating")
    private float rating;

}
