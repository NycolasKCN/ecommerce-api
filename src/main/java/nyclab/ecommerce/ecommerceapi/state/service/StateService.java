package nyclab.ecommerce.ecommerceapi.state.service;

import nyclab.ecommerce.ecommerceapi.state.domain.State;
import nyclab.ecommerce.ecommerceapi.state.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    private final StateRepository stateRepository;

    @Autowired
    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Page<State> getStates(Pageable pageable) {
        return stateRepository.findAll(pageable);
    }

    public State getState(Integer id) {
        return stateRepository.findById(id).orElseThrow(() -> new RuntimeException("State not found"));
    }

    public Page<State> getStatesByCountryCode(String countryCode, Pageable pageable) {
        return stateRepository.findByCountryCode(countryCode, pageable);
    }
}
