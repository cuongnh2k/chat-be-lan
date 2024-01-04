package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import website.chatx.exception.BusinessLogicException;
import website.chatx.entities.UserEntity;
import website.chatx.repositories.UserRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity == null) {
            throw new BusinessLogicException(-2);
        }
        return new User(userEntity.getEmail(),
                userEntity.getPassword(),
//                userEntity.getRoles().stream()
//                        .map(role -> new SimpleGrantedAuthority(role.name()))
//                        .collect(Collectors.toList())
                new ArrayList<>()
        );
    }
}