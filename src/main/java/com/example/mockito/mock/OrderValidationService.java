package com.example.mockito.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderValidationService {

    @Autowired
    private List<Validator> validatorList;

    public void validate(Order order) {
        for (Validator component : validatorList) {
            component.validate(order);
        }
    }
}
