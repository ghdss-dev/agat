package br.com.agat.dto.response;

import br.com.agat.model.Phone;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PhoneResponse {

    private Integer id;
    private String telephone;

    public static PhoneResponse of( Phone phone) {

        return PhoneResponse.builder()
                .id(phone.getId())
                .telephone(phone.getTelephone())
                .build();

    }

    public static List<PhoneResponse> of(List<Phone> phones) {

        if (phones == null) {

            return null;
        }

        List<PhoneResponse> list = new ArrayList<>(phones.size());

        for(Phone phone : phones) {

            list.add(of (phone));
        }
        return list;
    }
}
