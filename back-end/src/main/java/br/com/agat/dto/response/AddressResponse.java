package br.com.agat.dto.response;

import br.com.agat.model.Address;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class AddressResponse {

    private Integer id;
    private String city;
    private String state;
    private String neighborhood;
    private String address;
    private Integer number;
    private String zip_code;
    private Double latitude;
    private Double longitude;

    public static AddressResponse of(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .city(address.getCity())
                .state(address.getState())
                .neighborhood(address.getNeighborhood())
                .address(address.getAddress())
                .number(address.getNumber())
                .zip_code(address.getZip_code())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .build();

    }

    public static List<AddressResponse> of(List<Address> addresses) {

        if (addresses == null) {

            return null;
        }

        List<AddressResponse> List = new ArrayList<>(addresses.size());

        for (Address address: addresses) {

            List.add(of(address));
        }

        return List;

    }
}
