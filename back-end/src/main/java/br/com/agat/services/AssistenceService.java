package br.com.agat.services;

import br.com.agat.dto.request.AssistenceRequest;
import br.com.agat.dto.response.AssistenceResponse;
import br.com.agat.model.Assistence;
import br.com.agat.repository.AssistenceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistenceService {

    @Autowired
    private AssistenceRepository repository;

    public void registerAssistence (AssistenceRequest request) {

        repository.save(Assistence.of(request));
    }

    public List<AssistenceResponse> searchAssistences() {

        return AssistenceResponse.of(repository.findAll());
    }

    public Assistence searchForid(Integer id) {

        return repository.findById(id).get();
    }


    @Transactional
    public AssistenceResponse updateAssistence(AssistenceRequest request, Integer id) {
        var assistence = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assistence not found"));

        var addresses = assistence.getAddresses();
        var phones = assistence.getPhones();

        BeanUtils.copyProperties(Assistence.of(request), assistence, "id", "addresses", "phones" );

        return AssistenceResponse.of(repository.save(assistence));
    }

    public void removeAssistence(Integer id) {

        var assistence = searchForid(id);
        repository.delete(assistence);
    }
}
