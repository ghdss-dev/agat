package br.com.agat.controller;

import br.com.agat.dto.request.AssistenceRequest;
import br.com.agat.dto.response.AssistenceResponse;
import br.com.agat.model.Assistence;
import br.com.agat.repository.AssistenceRepository;
import br.com.agat.services.AssistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assistence")
public class AssistenceController {
    
    @Autowired
    private AssistenceService service;

    @Autowired
    private AssistenceRepository repository;

    @PostMapping
    public void register(@RequestBody AssistenceRequest request) {

        service.registerAssistence(request);
    }

    @GetMapping
    public List<AssistenceResponse>  list() {

        return service.searchAssistences();
    }

    @GetMapping("/{id}")
    Assistence getAssistenceById(@PathVariable Integer id) {

        return service.searchForid(id);

    }

    @PutMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        service.removeAssistence(id);
    }
}
