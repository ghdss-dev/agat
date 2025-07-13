package br.com.agat.controller;

import br.com.agat.dto.request.UserRequest;
import br.com.agat.dto.response.UserResponse;
import br.com.agat.model.User;
import br.com.agat.repository.UserRepository;
import br.com.agat.services.UserService;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @PostMapping
    public  void register(@RequestBody UserRequest request) {

        service.registerUser(request);
    }

    @GetMapping
    public List<UserResponse> list() {

        return service.searchUsers();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable Integer id) {

        return service.searchForid(id);
    }

    @PutMapping("/{id}")
    public UserResponse updateUser(@RequestBody UserRequest request, @PathVariable Integer id) {
        return service.updateUser(request, id);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        service.removeUser(id);
    }

}
