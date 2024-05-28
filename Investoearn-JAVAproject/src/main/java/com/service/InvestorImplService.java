package com.service;

import com.domain.Entrepreneur;
import com.domain.Investor;
import com.repository.EntrepreneurRepository;
import com.repository.InvestorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class InvestorImplService implements InvestorService{

    private InvestorRepository investorRepository;

    public InvestorImplService(InvestorRepository investorRepository ) {
        this.investorRepository = investorRepository;
    }

    @Transactional
    public Investor insert(Investor investor) {

        return investorRepository.create(investor);
    }

    @Transactional(readOnly = true)
    public Investor get(Long id) {
        return investorRepository.get(id);
    }
    @Transactional(readOnly = true)
    public Investor findByUserName(String name) {
        return investorRepository.findByUserName(name);
    }
}
