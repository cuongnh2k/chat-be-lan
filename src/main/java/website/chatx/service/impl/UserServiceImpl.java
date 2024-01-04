package website.chatx.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.chatx.async.SendEmailAsync;
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.dto.auth.req.ActiveUserReq;
import website.chatx.dto.auth.req.ResetPasswordReq;
import website.chatx.dto.auth.req.SignInReq;
import website.chatx.dto.auth.req.SignUpReq;
import website.chatx.dto.res.SignInRes;
import website.chatx.entities.UserActivationCodeEntity;
import website.chatx.entities.UserEntity;
import website.chatx.repositories.UserActivationCodeRepository;
import website.chatx.repositories.UserRepository;
import website.chatx.service.UserService;

import java.util.Date;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserActivationCodeRepository userActivationCodeRepository;

    private final PasswordEncoder passwordEncoder;

    private final SendEmailAsync sendEmailAsync;

    private final DaoAuthenticationProvider daoAuthenticationProvider;

    private final HttpServletRequest request;
    //    private final CommonAuthContext authContext;
//    private final UserMapper userMapper;
    @Value("${application.jwt.secret-key}")
    private String SECRET_KEY;
    @Value("${application.jwt.access-token-age}")
    private Long ACCESS_TOKEN_AGE;

    @Override
    public void signUp(SignUpReq req) {
        UserEntity userEntity = userRepository.findByEmail(req.getEmail());
        if (userEntity != null) {
            throw new BusinessLogicException(-1);
        }
        userEntity = UserEntity.builder()
                .email(req.getEmail())
                .password(passwordEncoder.encode(req.getPassword()))
                .name(req.getName())
                .build();
        userRepository.save(userEntity);
        String verifyToken = RandomStringUtils.random(4, false, true);
        userActivationCodeRepository.save(UserActivationCodeEntity.builder()
                .code(verifyToken)
                .user(userEntity)
                .build());
        sendEmailAsync.sendSimpleMessage(req.getEmail(), "Mã kích hoạt tài khoản", verifyToken);
    }

    @Override
    @Transactional(readOnly = true)
    public SignInRes signIn(SignInReq req) {
        try {
            daoAuthenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        } catch (BadCredentialsException e) {
            throw new BusinessLogicException(-3);
        }
        UserEntity userEntity = userRepository.findByEmail(req.getEmail());
        if (!userEntity.isActivated()) {
            throw new BusinessLogicException(-4);
        }
        return new SignInRes(JWT.create()
                .withSubject(userEntity.getId())
                .withExpiresAt(new Date(System.currentTimeMillis() + ACCESS_TOKEN_AGE))
                .withIssuer(request.getRequestURL().toString())
                .sign(Algorithm.HMAC256(SECRET_KEY.getBytes())));
    }

    @Override
    public void active(ActiveUserReq req) {
        UserEntity userEntity = userRepository.findByEmail(req.getEmail());
        if (userEntity == null) {
            throw new BusinessLogicException(-5);
        }
        if (!req.getVerifyToken().equals(userEntity.getUserActivationCodes().get(0).getCode())) {
            throw new BusinessLogicException(-6);
        }
        userEntity.setActivated(true);
        userRepository.save(userEntity);
    }

    @Override
    public void resetPassword(ResetPasswordReq req) {
        UserEntity userEntity = userRepository.findByEmail(req.getEmail());
        if (userEntity == null) {
            throw new BusinessLogicException(-7);
        }
        String newPassword = RandomStringUtils.random(5, "1234567890")
                + RandomStringUtils.random(1, "qwertyuiop")
                + RandomStringUtils.random(1, "ASDFGHJKLZ")
                + RandomStringUtils.random(1, "!@#$%^&*()");
        userEntity.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(userEntity);
        sendEmailAsync.sendSimpleMessage(userEntity.getEmail(), "Mật khẩu mới", newPassword);
    }
}