package code.gaurav.mc_user.services;

import code.gaurav.mc_user.models.User;
import code.gaurav.mc_user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findByid(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(long id) {
         userRepository.deleteById(id);
    }

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public User updateUserByPath(User user){
        return userRepository.save(user);
    }

    public boolean verifyUser(User user) {
        User dbUser = userRepository.findByUserName(user.getUserName());
        return dbUser != null && user.getPassword().equals(dbUser.getPassword());
    }
}
