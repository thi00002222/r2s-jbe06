package com.example.demo.security;

import com.example.demo.entity.Authority;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository UserRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = UserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        Set<GrantedAuthority> granted = new HashSet<>();

//        add roles to granted authorities
        if (username != null) {
            for (Role role : user.getRoles()) {
                if (role != null) {
                    granted.add(() -> "ROLE_" + role.getRoleName());
                }
//            add more authorities if needed
                if (role.getAuthorities() != null) {
                    for (Authority authority : role.getAuthorities()) {
                        if (authority != null) {
                            granted.add(new SimpleGrantedAuthority(authority.getAuthorityName()));
                        }

                    }
                }
            }

        }
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                granted
        );
    }
}
