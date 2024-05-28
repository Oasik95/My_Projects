package com.repository;

import com.domain.Entrepreneur;
import com.domain.EntrepreneurIdea;
import com.domain.User;

import java.util.List;

public interface EntrepreneurIdeaRepository {

    public EntrepreneurIdea create(EntrepreneurIdea entrepreneurIdea);


    public List<EntrepreneurIdea> getAll();

    public EntrepreneurIdea get(Long id);


    void update(EntrepreneurIdea entrepreneurIdea);

    List<EntrepreneurIdea> findAllByUserName(String name);

    List<EntrepreneurIdea> findAllByStutas(String stutas);
    List<EntrepreneurIdea> findAllByInvest(String stutas);

    List<EntrepreneurIdea> findAllByInvestorName(String stutas);
}
