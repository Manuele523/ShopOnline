package it.be.shoponline.Entity;

import it.be.shoponline.Enum.TypeCategory;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@ToString
@Entity
@Table(name = "T_PRODUCT_CATEGORY")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SG_ID")
    @SequenceGenerator(name="SG_ID", sequenceName="SQ_ID_PRODUCT_CATEGORY", allocationSize=1)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "NAME", nullable = false)
    private TypeCategory name;

}
