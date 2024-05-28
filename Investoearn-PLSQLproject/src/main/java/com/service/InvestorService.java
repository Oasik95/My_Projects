package com.service;

import com.domain.Entrepreneur;
import com.domain.Investor;

import java.util.List;

public interface InvestorService {

    public Investor insert(Investor investor);

    public List<Investor> getAllinvestor();

    Investor findByUserName(String name);

    Investor get(Long id);
}
