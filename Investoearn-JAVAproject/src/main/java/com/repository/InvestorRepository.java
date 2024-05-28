package com.repository;

import com.domain.Entrepreneur;
import com.domain.Investor;

public interface InvestorRepository {

    public Investor create(Investor investor);

    public Investor get(Long id);

    Investor findByUserName(String name);
}
