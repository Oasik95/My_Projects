package com.repository;

import com.domain.Authority;
import com.domain.Entrepreneur;
import com.domain.User;

import java.util.List;

public interface EntrepreneurRepository {

    public Entrepreneur create(Entrepreneur entrepreneur);


    public Entrepreneur get(Long id);

    Entrepreneur findByUserName(String name);

    void update(Entrepreneur entrepreneur);
}
