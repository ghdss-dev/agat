package br.com.agat.model;

import br.com.agat.dto.request.PhoneRequest;
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
@Table(name = "phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "telephone", length = 13)
    private String telephone;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Phone (Integer id) {

        this.id = id;
    }

    public static Phone of(PhoneRequest request) {

        var phone = new Phone();

        BeanUtils.copyProperties(request, phone);

        return phone;
    }


}
