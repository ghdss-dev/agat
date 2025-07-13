package br.com.agat.model;

import br.com.agat.dto.request.AddressRequest;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "state", length = 50)
    private String state;

    @Column(name = "neighborhood", length = 50)
    private String neighborhood;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "number", length = 10)
    private Integer number;

    @Column(name = "zipCode", length = 10)
    private String zipCode;

    @Column(name = "latitude", length = 50)
    private Double latitude;

    @Column(name = "longitude", length = 50)
    private Double longitude;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public static Address of(AddressRequest request) {

        var endereco = new Address();
        BeanUtils.copyProperties(request, endereco);

        return endereco;
    }

}
