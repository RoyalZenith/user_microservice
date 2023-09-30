package code.gaurav.mc_user.repositories;

import code.gaurav.mc_user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByid(long id);
    User save(User user);
    void deleteById(long id);
    User findByUserName(String userName);
}
