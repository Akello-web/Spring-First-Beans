package kz.akello.bitlab.FirstSpring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "list_games")
@Getter
@Setter
public class GameModel {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    @Column(name = "id") //column name
    private Long id;

    @Column(name = "game-name")
    private String name;

    @Column(name = "game-year")
    private int year;

    @Column(name = "game-price")
    private double price;

    @ManyToOne
    private AuthorModel authorModel;

    @PrePersist
    public void checkForNegativePrice(){
        if (this.year <= 0 && this.price < 0) {
            this.year = 2023; // Set a default value of 1 for year
            this.price = 0; // Set a default value of 1 for price
        } else if (this.year <= 0) {
            this.year = 2023; // Set a default value of 1 for year
        } else if (this.price < 0) {
            this.price = 0; // Set a default value of 1 for price
        }
    }
}
