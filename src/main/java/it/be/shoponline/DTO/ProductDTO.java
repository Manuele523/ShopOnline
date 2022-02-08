package it.be.shoponline.DTO;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private CategoryDTO category;

}
