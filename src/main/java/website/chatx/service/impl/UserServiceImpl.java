package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.entities.UserEntity;
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.core.mapper.UserMapper;
import website.chatx.dto.prt.user.GetStatusFriendPrt;
import website.chatx.dto.res.user.UserToAddFriendRes;
import website.chatx.dto.rss.user.StatusFriendRss;
import website.chatx.repositories.jpa.UserJpaRepository;
import website.chatx.repositories.mybatis.UserMybatisRepository;
import website.chatx.service.UserService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;

    private final UserMybatisRepository userMybatisRepository;

    private final CommonAuthContext commonAuthContext;

    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public UserToAddFriendRes getUserToAddFriend(String email) {
        UserEntity userEntity = userJpaRepository.findUserToAddFriend(email, commonAuthContext.getUserEntity().getId())
                .orElseThrow(() -> new BusinessLogicException(-12));

        UserToAddFriendRes userToAddFriendRes = userMapper.toUserToAddFriendRes(userEntity);

        List<StatusFriendRss> statusFriendRss = userMybatisRepository.getStatusFriend(GetStatusFriendPrt.builder()
                .userId(commonAuthContext.getUserEntity().getId())
                .email(email)
                .build());
        if (!CollectionUtils.isEmpty(statusFriendRss)) {
            statusFriendRss.forEach(o -> {
                if (o.getUserId().equals(commonAuthContext.getUserEntity().getId())) {
                    userToAddFriendRes.setMyStatus(o.getStatus());
                }
                userToAddFriendRes.setTheirStatus(o.getStatus());
            });
        }
        return userToAddFriendRes;
    }
}