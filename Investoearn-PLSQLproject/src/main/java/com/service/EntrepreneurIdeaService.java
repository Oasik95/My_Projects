package com.service;

import com.domain.EntrepreneurIdea;

import java.util.List;

public interface EntrepreneurIdeaService {

    public EntrepreneurIdea insert(EntrepreneurIdea entrepreneurIdea);

    public EntrepreneurIdea delete(EntrepreneurIdea entrepreneurIdea);

    public List<EntrepreneurIdea> getAll();

    public EntrepreneurIdea get(Long id);

    void update(EntrepreneurIdea entrepreneurIdea);


    List<EntrepreneurIdea> getAllByUserName(String name);

    List<EntrepreneurIdea> getAllByInvestorName(String name);

    List<EntrepreneurIdea> getAllByStutas(String stutas);

    List<EntrepreneurIdea> getAllByInvest(String stutas);

    List<EntrepreneurIdea> getAllByreject(String stutas);
    public void updateNormal(EntrepreneurIdea entrepreneurIdea);
}
