package com.lab2.lab2.exception;

import com.lab2.lab2.aspect.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionnServiceImpl implements ExceptionnService {

    @Autowired
    private ExceptionnRepo exceptionnRepo;
    @Override
    public void addException(Exceptionn exceptionn) {
        exceptionnRepo.save(exceptionn);
    }
}
