package com.tutorial.user;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public List<User> findById(@PathVariable("id") int id) {
        return userService.findById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> insert(@RequestBody @Validated UserRequest userRequest, UriComponentsBuilder uriBuilder) {
        User user = userService.insert(userRequest.getName(), userRequest.getDateOfBirth());
        URI location = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        UserResponse body = new UserResponse("user created");
        return ResponseEntity.created(location).body(body);
    }
}
