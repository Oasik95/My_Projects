package com.service;

import com.domain.Authority;
import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;

import java.util.List;

public interface EntrepreneurService {

    public Entrepreneur insert(Entrepreneur entrepreneur);

    public List<Entrepreneur> getAllEN();
    public Entrepreneur get(Long id);

    Entrepreneur findByUserName(String name);

    void update(Entrepreneur entrepreneur);

}
