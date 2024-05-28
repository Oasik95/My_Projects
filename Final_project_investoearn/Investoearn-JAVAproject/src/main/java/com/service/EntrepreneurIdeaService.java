package com.service;

import com.domain.EntrepreneurIdea;

import com.domain.User;

import java.util.List;

public interface EntrepreneurIdeaService {

    public EntrepreneurIdea insert(EntrepreneurIdea entrepreneurIdea);

    public List<EntrepreneurIdea> getAll();

    public EntrepreneurIdea get(Long id);

    void update(EntrepreneurIdea entrepreneurIdea);

    List<EntrepreneurIdea> getAllByUserName(String name);

    List<EntrepreneurIdea> getAllByInvestorName(String name);

    List<EntrepreneurIdea> getAllByStutas(String stutas);

    List<EntrepreneurIdea> getAllByInvest(String stutas);
}
