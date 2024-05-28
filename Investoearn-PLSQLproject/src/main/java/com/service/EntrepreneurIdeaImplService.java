package com.service;

import com.domain.EntrepreneurIdea;

import com.repository.EntrepreneurIdeaRepository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrepreneurIdeaImplService implements EntrepreneurIdeaService{

    private EntrepreneurIdeaRepository  entrepreneurIdeaRepositorye;

    public EntrepreneurIdeaImplService(@Qualifier("entrepreneurIdeaSQLRepositoryImpl") EntrepreneurIdeaRepository  entrepreneurIdeaRepository) {
        this.entrepreneurIdeaRepositorye = entrepreneurIdeaRepository;
    }

   // @Transactional
   // public EntrepreneurIdea insert(EntrepreneurIdea entrepreneurIdea) {
   //     return entrepreneurIdeaRepositorye.create(entrepreneurIdea);
   // }

    @Transactional
    public EntrepreneurIdea insert(EntrepreneurIdea entrepreneurIdea) {
        System.out.println("Create using procedure");
           entrepreneurIdeaRepositorye.createUsingProcedure(entrepreneurIdea);
        return null;
    }



    @Transactional
    public EntrepreneurIdea delete(EntrepreneurIdea entrepreneurIdea) {
        return entrepreneurIdeaRepositorye.delete(entrepreneurIdea);
    }

    @Transactional(readOnly = true)
    public List<EntrepreneurIdea> getAll() {
        return entrepreneurIdeaRepositorye.getAll();
    }

    @Transactional(readOnly = true)
    public EntrepreneurIdea get(Long id) {
        return entrepreneurIdeaRepositorye.get(id);
    }
    @Transactional
    public void update(EntrepreneurIdea entrepreneurIdea){
        entrepreneurIdeaRepositorye.updateUsingProcedure(entrepreneurIdea);
    }
    @Transactional
    public void updateNormal(EntrepreneurIdea entrepreneurIdea){
        entrepreneurIdeaRepositorye.update(entrepreneurIdea);
    }

   @Transactional
    public List<EntrepreneurIdea> getAllByUserName(String name) {
        return entrepreneurIdeaRepositorye.findAllByUserName(name);
    }

    @Transactional
    public List<EntrepreneurIdea> getAllByInvestorName(String name) {
        return entrepreneurIdeaRepositorye.findAllByInvestorName(name);
    }

    @Transactional
    public List<EntrepreneurIdea> getAllByStutas(String stutas) {
        return entrepreneurIdeaRepositorye.findAllByStutas(stutas);
    }

    @Transactional
    public List<EntrepreneurIdea> getAllByInvest(String stutas) {
        return entrepreneurIdeaRepositorye.findAllByInvest(stutas);
    }

    @Transactional
    public List<EntrepreneurIdea> getAllByreject(String stutas) {
        return entrepreneurIdeaRepositorye.findAllByInvest(stutas);
    }


}
