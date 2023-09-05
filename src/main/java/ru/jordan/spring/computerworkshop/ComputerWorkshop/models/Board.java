package ru.jordan.spring.computerworkshop.ComputerWorkshop.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Board")
public class Board {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    @Column(name = "name")
    private String name;


    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater than 1")
    private int price;

    @Column(name = "description")
    @Size(min = 0, max = 400, message = "Description should be less than 400 characters")
    private String description;

    @OneToMany(mappedBy = "boardowner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Computer> computers;

    public Board() {
    }

    public Board(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }
}
