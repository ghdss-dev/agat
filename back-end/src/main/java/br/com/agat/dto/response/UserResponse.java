package br.com.agat.dto.response;

import br.com.agat.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class UserResponse {

    private Integer id;
    private String name;
    private String email;
    private String password;

    public static UserResponse of(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    public static List<UserResponse> of(List<User> users) {

        if (users == null) {

            return null;
        }

        List<UserResponse> list = new ArrayList<>(users.size());

        for (User user: users) {

            list.add(of (user));
        }

        return list;
    }

}
