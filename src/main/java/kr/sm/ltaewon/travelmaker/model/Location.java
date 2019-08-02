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
@SequenceGenerator(name = "Id_Generator", sequenceName = "Id", initialValue = 1, allocationSize = 1)
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private int id;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id")
    @Column(name="latitude")
    private float latitude;

    @Column(name="longitude")
    private float longitude;

    @Column(name="address")
    private String address;

    @Column(name="name")
    private String name;
}
