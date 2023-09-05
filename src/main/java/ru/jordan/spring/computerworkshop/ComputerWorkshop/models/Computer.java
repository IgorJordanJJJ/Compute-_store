package ru.jordan.spring.computerworkshop.ComputerWorkshop.models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "Computer")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @Size(min = 1, max = 30, message = "Name should between 1 and 30 characters")
    private String name;

    @Column(name = "price_computer")
    @Min(value = 1, message = "Price should be greater than 1")
    private int price;

    @Size(min = 0, max = 400, message = "Description should be less than 400 characters")
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "cpu_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private CPU cpuowner;

    @ManyToOne
    @JoinColumn(name = "ram_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private RAM ramowner;


    @ManyToOne
    @JoinColumn(name = "board_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Board boardowner;

    @ManyToOne
    @JoinColumn(name = "power_supply_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private PowerSupply powersupplyowner;

    @ManyToOne
    @JoinColumn(name = "cooling_system_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private CoolingSystem coolingsystemowner;

    @ManyToOne
    @JoinColumn(name = "case_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Case caseowner;


    @ManyToOne
    @JoinColumn(name = "main_memory_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private MainMemory mainmemoryowner;

    @ManyToOne
    @JoinColumn(name = "graphic_card_id", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private GraphicCard graphiccardowner;

    @OneToMany(mappedBy = "computerowner")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Orders> orders;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public CPU getCpuowner() {
        return cpuowner;
    }

    public void setCpuowner(CPU cpuowner) {
        this.cpuowner = cpuowner;
    }

    public RAM getRamowner() {
        return ramowner;
    }

    public void setRamowner(RAM ramowner) {
        this.ramowner = ramowner;
    }

    public Board getBoardowner() {
        return boardowner;
    }

    public void setBoardowner(Board boardowner) {
        this.boardowner = boardowner;
    }

    public PowerSupply getPowersupplyowner() {
        return powersupplyowner;
    }

    public void setPowersupplyowner(PowerSupply powersupplyowner) {
        this.powersupplyowner = powersupplyowner;
    }

    public CoolingSystem getCoolingsystemowner() {
        return coolingsystemowner;
    }

    public void setCoolingsystemowner(CoolingSystem coolingsystemowner) {
        this.coolingsystemowner = coolingsystemowner;
    }

    public Case getCaseowner() {
        return caseowner;
    }

    public void setCaseowner(Case caseowner) {
        this.caseowner = caseowner;
    }

    public MainMemory getMainmemoryowner() {
        return mainmemoryowner;
    }

    public void setMainmemoryowner(MainMemory mainmemoryowner) {
        this.mainmemoryowner = mainmemoryowner;
    }

    public GraphicCard getGraphiccardowner() {
        return graphiccardowner;
    }

    public void setGraphiccardowner(GraphicCard graphiccardowner) {
        this.graphiccardowner = graphiccardowner;
    }


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
