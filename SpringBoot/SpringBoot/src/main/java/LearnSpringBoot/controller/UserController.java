package LearnSpringBoot.controller;

import LearnSpringBoot.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        users.add(user);

        return user;
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return users;
    }

    @DeleteMapping("/user")
    public void delete(@RequestParam(name = "id") int id) {
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                break;
            }
        }
    }

    @PutMapping("/user")
    public void update(@RequestBody User user) {
        for(int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                break;
            }
        }
    }
}
