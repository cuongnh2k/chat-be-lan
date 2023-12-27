package website.chatx.rest.basic.auth.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    //    private final UUserRepository userRepository;
//
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        UserEntity userEntity = userRepository.findByLocal_Email(email);
//        if (userEntity == null) {
//            throw new BusinessLogicException(-2);
//        }
//        return new User(userEntity.getLocal().getEmail(),
//                userEntity.getLocal().getPassword(),
//                userEntity.getRoles().stream()
//                        .map(role -> new SimpleGrantedAuthority(role.name()))
//                        .collect(Collectors.toList()));
        return null;
    }
}