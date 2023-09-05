package ru.jordan.spring.computerworkshop.ComputerWorkshop.models;


import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "RAM")
public class RAM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 1, max = 30, message = "Name should between 1 and 30 characters")
    private String name;

    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater than 1")
    private int price;

    @Size(min = 0, max = 400, message = "Description should be less than 400 characters")
    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "ramowner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Computer> computers;

    public List<Computer> getComputers() {
        return computers;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public RAM(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public RAM(int id) {
        this.id = id;
    }

    public RAM() {

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
