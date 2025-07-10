package br.com.agat.dto.request;

import lombok.Data;

@Data
public class AddressRequest {

    private String city;
    private String state;
    private String neighborhood;
    private String address;
    private Integer number;
    private String zip_code;
    private Double latitude;
    private Double longitude;
}
