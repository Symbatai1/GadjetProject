package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "favorites")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "favorite_gen")
    @SequenceGenerator(name = "favorite_gen", sequenceName = "favorite_seq",
            allocationSize = 1)
    private Long Id;
    @OneToMany(mappedBy = "favorites",cascade = ALL)
    private List<Product> product;
    @OneToMany(mappedBy = "favorites",cascade ={DETACH,MERGE,PERSIST,REFRESH})
    private List<User>users;

}
