package com.service;

import com.domain.Users;
import com.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsersImplService implements UsersService {

    private UsersRepository usersRepository;

    private PasswordEncoder passwordEncoder;

    public UsersImplService(@Qualifier("usersRepositoryImpl")UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        System.out.println(passwordEncoder.getClass());
    }

    @Transactional
    public Users insert(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.create(users);
    }

    @Transactional(readOnly = true)
    public Users get(Long id) {
        return usersRepository.get(id);
    }

    @Transactional(readOnly = true)
    public List<Users> getAll() {
        return usersRepository.getAll();
    }

    @Transactional
    public Users update(Users users) {

        users.setPassword(passwordEncoder.encode(users.getPassword()));
        return usersRepository.update(users);
    }

    @Transactional
    public void delete(Long id) {
        usersRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public Users getByUsername(String username) { return usersRepository.getByUsername(username); }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = getByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), users.getAuthorities());
    }
}
