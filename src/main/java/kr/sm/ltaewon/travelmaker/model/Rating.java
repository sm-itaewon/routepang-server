package kr.sm.ltaewon.travelmaker.model;

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

    @JoinColumn(name="location_id")
    @ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY)
    private Location location;

    @JoinColumn(name="customer_id")
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    private Customer customer;

    @Column(name="rating")
    private float rating;

}
