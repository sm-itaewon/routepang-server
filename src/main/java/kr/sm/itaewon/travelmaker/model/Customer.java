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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int id;

    @Column(name="account_id")
    private String account;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

}
