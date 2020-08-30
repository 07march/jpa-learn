package by.learn.datajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String login;
    private String password;
    @OneToOne
    private Address address;
    @OneToOne
    private Telephone telephone;

    public User(String name, String login, String passwrod, Address address, Telephone telephone) {
        this.name = name;
        this.login = login;
        this.password = passwrod;
        this.address = address;
        this.telephone = telephone;
    }
}
