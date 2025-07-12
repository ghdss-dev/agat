package br.com.agat.controller;

import br.com.agat.dto.request.PhoneRequest;
import br.com.agat.dto.response.PhoneResponse;
import br.com.agat.model.Phone;
import br.com.agat.repository.PhoneRepository;
import br.com.agat.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService service;

    @Autowired
    private PhoneRepository repository;

    @PostMapping("/phone")
    public void cadastrar (@RequestBody PhoneRequest request) {

        service.registerPhone(request);
    }

    @GetMapping("/phones")
    public List<PhoneResponse> listar() {

        return service.searchPhones();
    }

    @GetMapping("/{id}")
    Phone getPhoneById(@PathVariable Integer id) {

        return service.searchForid(id);
    }

    @DeleteMapping("/{id}")
    public void deletePhone(@PathVariable Integer id) {

       service.removePhone(id);
    }

    @PutMapping("/{id}")
    public PhoneResponse updatePhone(@RequestBody PhoneRequest request, @PathVariable Integer id) {

        return service.updatePhone(request, id);
    }

}
