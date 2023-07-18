package com.company.config.details;

import com.company.exp.ItemNotFoundException;
import com.company.user.entity.UserEntity;
import com.company.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomProfileDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public CustomProfileDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserEntity entity = userRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Profile Not Found"));

        return new CustomProfileDetails(entity);
    }

    public CustomProfileDetails loadUserByPhone(String id) throws UsernameNotFoundException {
        UserEntity entity = userRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Profile Not Found"));

        return new CustomProfileDetails(entity);
    }
}
