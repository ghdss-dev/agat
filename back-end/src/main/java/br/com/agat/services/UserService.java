package br.com.agat.services;

import br.com.agat.dto.request.UserRequest;
import br.com.agat.dto.response.AddressResponse;
import br.com.agat.dto.response.UserResponse;
import br.com.agat.model.User;
import br.com.agat.repository.UserRepository;
import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public void registerUser (UserRequest request) {

        repository.save(User.of(request));
    }

    public List<UserResponse> searchUsers() {

        return UserResponse.of(repository.findAll());
    }

    public  User searchForid(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public UserResponse updateUser(UserRequest request, Integer id) {
        var user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        var addresses = user.getAddresses();
        var phones =user.getPhones();

        BeanUtils.copyProperties(User.of(request), user,"id", "addresses", "phones");

        return UserResponse.of(repository.save(user));
    }

    public void removeUser(Integer id) {

        var user = searchForid(id);
        repository.delete(user);
    }
}
