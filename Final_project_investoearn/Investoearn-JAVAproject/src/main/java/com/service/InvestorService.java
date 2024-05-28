package com.service;

import com.domain.Entrepreneur;
import com.domain.Investor;

public interface InvestorService {

    public Investor insert(Investor investor);

    Investor findByUserName(String name);

    Investor get(Long id);
}
