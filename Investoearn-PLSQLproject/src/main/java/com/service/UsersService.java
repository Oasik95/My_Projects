package com.service;

import com.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsersService extends UserDetailsService {

    public Users insert(Users users);

    public Users get(Long id);

    public List<Users> getAll();

    public Users update(Users users);

    public void delete(Long id);

    public Users getByUsername(String username);
}
