package ru.jordan.spring.computerworkshop.ComputerWorkshop.models;

import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.Date;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JoinColumn(name = "computer_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Computer computerowner;

    @ManyToOne
    @JoinColumn(name = "master_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Master masterowner;

    @ManyToOne
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Buyer buyerowner;


    @Column(name = "price")
    @Min(value = 1, message = "Price should be greater than 1")
    private int price;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateorder;


    public Orders() {
    }

    public Orders(int id) {
        this.id = id;
    }

    public Orders(Computer computerowner, Master masterowner) {
        this.computerowner = computerowner;
        this.masterowner = masterowner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Computer getComputerowner() {
        return computerowner;
    }

    public void setComputerowner(Computer computerowner) {
        this.computerowner = computerowner;
    }

    public Master getMasterowner() {
        return masterowner;
    }

    public void setMasterowner(Master masterowner) {
        this.masterowner = masterowner;
    }

    public Buyer getBuyerowner() {
        return buyerowner;
    }

    public void setBuyerowner(Buyer buyerowner) {
        this.buyerowner = buyerowner;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDateorder() {
        return dateorder;
    }

    public void setDateorder(Date dateorder) {
        this.dateorder = dateorder;
    }


}
