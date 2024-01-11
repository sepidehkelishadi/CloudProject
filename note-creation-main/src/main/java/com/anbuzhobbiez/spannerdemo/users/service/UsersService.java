package com.anbuzhobbiez.spannerdemo.users.service;

import com.anbuzhobbiez.spannerdemo.users.domain.Users;
import com.anbuzhobbiez.spannerdemo.users.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info(email);
        return usersRepository.findByEmail(email);
    }

    public List<Users> findAll() {
        return (List<Users>) usersRepository.findAll();
    }

    public Users findById(String id) {
        return usersRepository.findById(id).get();
    }

    @PreAuthorize("#users.email != authentication.name")
    public void deleteById(Users users) {
        usersRepository.deleteById(users.getId());
    }

    @Transactional
    public void registerUser(Users users) {
        usersRepository.save(users);
    }
}
