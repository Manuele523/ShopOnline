package it.be.shoponline.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "T_PRODUCT_STORED")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "QUANTITY", nullable = false)
    private String quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_CATEGORY", referencedColumnName = "ID")
    private CategoryEntity category;

}
