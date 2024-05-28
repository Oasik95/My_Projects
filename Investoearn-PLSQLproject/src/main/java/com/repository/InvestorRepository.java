package com.repository;

import com.domain.Entrepreneur;
import com.domain.Investor;

import java.util.List;

public interface InvestorRepository {

    public Investor create(Investor investor);

    public Investor get(Long id);

    public List<Investor> getAllinvestor();

    Investor findByUserName(String name);
}
