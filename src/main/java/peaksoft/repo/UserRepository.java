package peaksoft.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.entity.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


    public Optional<User> getUserByEmail(String email);
}
