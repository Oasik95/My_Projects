package com.repository;

import com.domain.Users;

import java.util.List;

public interface UsersRepository {

    public List<Users> getAll();

    public Users create(Users users);

    public Users get(Long id);

    public Users update(Users users);

    public void delete(Long id);

    public Users getByUsername(String username);
}
