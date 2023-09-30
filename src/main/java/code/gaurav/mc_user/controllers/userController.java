package code.gaurav.mc_user.controllers;

import code.gaurav.mc_user.models.User;
import code.gaurav.mc_user.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/get")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/get/{userId}")
    public User getUserById(@PathVariable("userId") String userId){
        return userService.getUserById(Long.parseLong(userId));
    }

    @PostMapping(value = "/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public int deleteUser(@PathVariable("userId") String id){
        userService.deleteUser(Long.parseLong(id));
        return HttpServletResponse.SC_OK;
    }

    @PostMapping("/verify")
    public Boolean verifyUser(@RequestBody User user){
        System.out.println("Request on port: "+port);
        return userService.verifyUser(user);
    }
}
