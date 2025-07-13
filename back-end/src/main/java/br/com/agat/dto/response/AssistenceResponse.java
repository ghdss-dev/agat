package br.com.agat.dto.response;

import br.com.agat.model.Assistence;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class AssistenceResponse {

    private Integer id;
    private String name;
    private String email;
    private String password;

    public static AssistenceResponse of(Assistence assistence) {

        return AssistenceResponse.builder()
                .id(assistence.getId())
                .name(assistence.getName())
                .email(assistence.getEmail())
                .password(assistence.getPassword())
                .build();
    }

    public static List<AssistenceResponse> of(List<Assistence> assistences) {

        if (assistences == null) {

            return null;
        }

        List<AssistenceResponse> list = new ArrayList<>(assistences.size());

        for (Assistence assistence: assistences) {

            list.add(of (assistence));
        }

        return list;
    }
}
