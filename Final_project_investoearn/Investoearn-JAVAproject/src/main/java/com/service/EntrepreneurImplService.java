package com.service;

import com.domain.Authority;
import com.domain.Entrepreneur;
import com.repository.EntrepreneurRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrepreneurImplService implements EntrepreneurService{

    private EntrepreneurRepository entrepreneurRepository;





    public EntrepreneurImplService(EntrepreneurRepository entrepreneurRepository ) {
        this.entrepreneurRepository = entrepreneurRepository;


    }

    @Transactional
    public Entrepreneur insert(Entrepreneur entrepreneur) {

        return entrepreneurRepository.create(entrepreneur);
    }

    @Transactional(readOnly = true)
    public Entrepreneur get(Long id) {
        return entrepreneurRepository.get(id);
    }

    @Transactional(readOnly = true)
    public Entrepreneur findByUserName(String name) {
        return entrepreneurRepository.findByUserName(name);
    }

    @Override
    @Transactional
    public void update(Entrepreneur entrepreneur) {

//        entrepreneur.setPassword(passwordEncoder.encode(entrepreneur.getPassword()));
//        entrepreneur.setRepass(passwordEncoder.encode(entrepreneur.getPassword()));

         entrepreneurRepository.update(entrepreneur);

    }

}
