package br.com.agat.controller;

import br.com.agat.dto.request.AddressRequest;
import br.com.agat.dto.response.AddressResponse;
import br.com.agat.model.Address;
import br.com.agat.repository.AddressRepository;
import br.com.agat.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @Autowired
    private AddressRepository repository;

    @PostMapping("/address")
    public void register(@RequestBody AddressRequest request){

        service.registerAddress( request);
    }

    @GetMapping("/adresses")
    public List<AddressResponse> tolist(){

        return service.searchAddresses();

    }

    @GetMapping("/{id}")
    Address getAdressById(@PathVariable Integer id) {

        return service.searchForid(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {

        service.removeAddress(id);
    }

    @PutMapping("/{id}")
    public AddressResponse updateAddress(@RequestBody AddressRequest request, @PathVariable Integer id) {

        return service.updateAddress(request, id);
    }
}
