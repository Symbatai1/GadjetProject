package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "brands")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "brand_gen")
    @SequenceGenerator(name = "brand_gen", sequenceName = "brand_seq",
            allocationSize = 1)
    private Long id;

    @Column(name = "brand_name")
    private String brandName;

    private String image;

    @OneToMany(mappedBy = "brands", cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Product> products;
}