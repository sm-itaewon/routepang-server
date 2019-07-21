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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private int id;

    @Column(name="latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="address")
    private String address;

    @Column(name="name")
    private String name;
}
