package by.learn.datajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Telephone {

    @Id
    @GeneratedValue
    private long id;

    private String telephone;

    public Telephone(String telephone) {
        this.telephone = telephone;
    }
}
