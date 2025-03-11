package nyclab.ecommerce.ecommerceapi.state.controller;

import lombok.extern.slf4j.Slf4j;
import nyclab.ecommerce.ecommerceapi.state.domain.State;
import nyclab.ecommerce.ecommerceapi.state.dto.StateDTO;
import nyclab.ecommerce.ecommerceapi.state.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/v1/api/states", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public Page<StateDTO> getStates(
            Pageable pageable
    ) {
        log.debug("getStates called with page={}, size={}", pageable.getPageNumber(), pageable.getPageSize());

        Page<StateDTO> states = stateService.getStates(pageable).map(State::toDto);

        log.debug("getStates returned {} states", states.getTotalElements());
        return states;
    }

    @GetMapping("/{id}")
    public StateDTO getState(@PathVariable Integer id) {
        log.debug("getState called with id={}", id);
        StateDTO stateDTO = stateService.getState(id).toDto();
        log.debug("getState returned with id={}", stateDTO.getId());
        return stateDTO;
    }

    @GetMapping("/search/findByCountryCode")
    public Page<StateDTO> getStatesByCountryCode(@RequestParam String code, Pageable pageable) {
        log.debug("getStatesByCountryCode called with countryCode={}, page={}, size={}", code, pageable.getPageNumber(), pageable.getPageSize());
        Page<StateDTO> states = stateService.getStatesByCountryCode(code, pageable).map(State::toDto);
        log.debug("getStatesByCountryCode returned {} states", states.getTotalElements());
        return states;
    }

}
