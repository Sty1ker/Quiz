package com.example.quiz.web.security;

import com.example.quiz.domain.user.User;
import com.example.quiz.servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtUserDetalisService implements UserDetailsService {

    private final UserServis userServis;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServis.getByUsername(username);
        return JwtEntityFactory.create(user);
    }


}
