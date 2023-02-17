package com.example.backend.demo.appuser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService
{
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final AppUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        return repository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void signUpUser(AppUser appUser)
    {

        repository.save(appUser);
    }

    public Boolean userExists(String email)
    {
        return repository
                .findByEmail(email)
                .isPresent();
    }

//    public int enableAppUser(String email)
//    {
//        return repository.enableAppUser()
//    }
}