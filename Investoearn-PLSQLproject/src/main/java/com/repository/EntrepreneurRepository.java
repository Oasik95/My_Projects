package com.repository;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;

import java.util.List;

public interface EntrepreneurRepository {

    public Entrepreneur create(Entrepreneur entrepreneur);


    public Entrepreneur get(Long id);

    public List<Entrepreneur> getAllEN();

    Entrepreneur findByUserName(String name);

    void update(Entrepreneur entrepreneur);
}
