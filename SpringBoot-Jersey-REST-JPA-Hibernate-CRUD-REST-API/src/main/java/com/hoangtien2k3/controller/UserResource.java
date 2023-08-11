package com.hoangtien2k3.controller;

import com.hoangtien2k3.exception.ResourceNotFoundException;
import com.hoangtien2k3.model.User;
import com.hoangtien2k3.repository.UserRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Path("/api/v1")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GET
    @Produces("application/json")
    @Path("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GET
    @Produces("application/json")
    @Path("/users/{id}")
    public ResponseEntity<User> getUserById(@PathParam(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @POST
    @Produces("application/json") // định dạng dữ liệu của dữ liệu mà phương thức trả về
    @Consumes("application/json") // định dạng dữ liệu của dữ liệu mà yêu cầu gửi đến.
    @Path("/users") // đường dẫn tương đối, nó sẽ được kết hợp với đường dẫn gốc của dịch vụ web.
    @PostMapping("/users")
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @PUT
    @Consumes("application/json")
    @Path("/users/{id}}")
    public ResponseEntity<User> updateUser(@PathParam(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        user.setEmailId(userDetails.getEmailId());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DELETE
    @Path("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathParam(value = "id") Long userId) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}