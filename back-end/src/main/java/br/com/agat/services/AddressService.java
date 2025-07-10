package br.com.agat.services;

import br.com.agat.dto.request.AddressRequest;
import br.com.agat.dto.response.AddressResponse;
import br.com.agat.model.Address;
import br.com.agat.repository.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public void registerAddress (AddressRequest request) {

        repository.save(Address.of(request));
    }

    public List<AddressResponse> searchAddresses() {

        return AddressResponse.of(repository.findAll());
    }

    public Address searchForid(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public AddressResponse updateAddress(AddressRequest request, Integer id) {

        var address = repository.findById(id).orElseThrow(() -> new RuntimeException( "Address not found"));
        BeanUtils.copyProperties(Address.of(request), address, "Id");
        return AddressResponse.of(repository.save(address));
    }

    public void removeAddress (Integer id) {

        var address = searchForid(id);
        repository.delete(address);
    }



}
