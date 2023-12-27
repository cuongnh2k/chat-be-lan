package website.chatx.service;

import website.chatx.dto.auth.req.ActiveUserReq;
import website.chatx.dto.auth.req.ResetPasswordReq;
import website.chatx.dto.auth.req.SignInReq;
import website.chatx.dto.auth.req.SignUpReq;
import website.chatx.dto.auth.res.SignInRes;

public interface UserService {

    void signUp(SignUpReq req);

    SignInRes signIn(SignInReq req);

    void active(ActiveUserReq req);

    void resetPassword(ResetPasswordReq req);
}
