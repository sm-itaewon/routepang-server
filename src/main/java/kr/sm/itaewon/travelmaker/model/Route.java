package kr.sm.itaewon.travelmaker.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


//@Entity
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="route_id")
    private long routeId;

    //TODO folder와 연관성 추가
}
