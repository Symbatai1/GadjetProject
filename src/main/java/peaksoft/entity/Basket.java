package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "baskets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "basket_gen")
    @SequenceGenerator(name = "basket_gen", sequenceName = "basket_seq",
            allocationSize = 1)
    private Long id;

    @ManyToMany(mappedBy = "baskets", cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    private User user;
}
