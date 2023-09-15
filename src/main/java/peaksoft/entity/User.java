package peaksoft.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import peaksoft.enums.Role;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
     @Id
     @GeneratedValue(strategy = GenerationType.SEQUENCE,
     generator = "user_gen")
     @SequenceGenerator(name = "user_gen",sequenceName = "user_seq",
     allocationSize = 1)

    private  Long id;
     private String firstName;
     private String lastName;
     private String email;
     private String password;
     @Column(name = "created_date")
     private ZonedDateTime createdDate;
     @Column(name = "updated_date")
     private ZonedDateTime updatedDate;
    @Enumerated(EnumType.STRING)  //String jazylat inache okubait enumdy
     private Role role;
     @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
     private Basket baskets;
     @ManyToOne
     private Favorite favorites;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
