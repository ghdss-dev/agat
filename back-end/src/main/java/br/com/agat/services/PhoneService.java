package br.com.agat.services;

import br.com.agat.dto.request.PhoneRequest;
import br.com.agat.dto.response.PhoneResponse;
import br.com.agat.model.Phone;
import br.com.agat.repository.PhoneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;

    public void registerPhone (PhoneRequest request) {

        repository.save(Phone.of(request));
    }

    public List<PhoneResponse> searchPhones() {

        return PhoneResponse.of(repository.findAll());
    }

    public Phone searchForid(Integer id) {

        return repository.findById(id).get();
    }

    @Transactional
    public PhoneResponse updatePhone(PhoneRequest request, Integer id) {
        var phone = repository.findById(id).orElseThrow(() -> new RuntimeException("Phone not found"));
        BeanUtils.copyProperties(Phone.of(request), phone, "id");
        return PhoneResponse.of(repository.save(phone));
    }

    public void removePhone (Integer id) {

        var phone = searchForid(id);
        repository.delete(phone);
    }

}
