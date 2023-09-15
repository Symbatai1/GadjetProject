package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import peaksoft.enums.Category;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "product_gen")
    @SequenceGenerator(name = "product_gen", sequenceName = "product_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal price;
    private String characteristic;
    private String madeIn;
    private boolean isFavorite;
    @ElementCollection
    private List<String> images;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToMany
    private List<Basket>baskets;
    @ManyToOne
    private Brand brands;
    @ManyToOne
    private Comment comments;
    @ManyToOne
    private Favorite favorites;

}
