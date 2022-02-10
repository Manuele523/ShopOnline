package it.be.shoponline.Entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "T_PRODUCT_STORED")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name="SG_ID", sequenceName="SQ_ID_PRODUCT_STORED", allocationSize=1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "QUANTITY", nullable = false)
    private String quantity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "FK_CATEGORY", referencedColumnName = "ID")
    private CategoryEntity category;

}
