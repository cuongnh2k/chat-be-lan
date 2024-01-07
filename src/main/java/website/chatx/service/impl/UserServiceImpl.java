package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.core.common.CommonPaginator;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.core.enums.UserChannelStatusEnum;
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.core.mapper.UserMapper;
import website.chatx.core.utils.BeanCopyUtils;
import website.chatx.dto.prt.user.GetListFriendToAddGroupPrt;
import website.chatx.dto.prt.user.GetOneUserToAddFriendPrt;
import website.chatx.dto.res.user.ListFriendToAddGroupRes;
import website.chatx.dto.res.user.OneUserToAddFriendRes;
import website.chatx.dto.rss.user.OneUserToAddFriendRss;
import website.chatx.repositories.jpa.UserChannelJpaRepository;
import website.chatx.repositories.jpa.UserJpaRepository;
import website.chatx.repositories.mybatis.UserMybatisRepository;
import website.chatx.service.UserService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserJpaRepository userJpaRepository;
    private final UserChannelJpaRepository userChannelJpaRepository;

    private final UserMybatisRepository userMybatisRepository;

    private final CommonAuthContext commonAuthContext;

    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public OneUserToAddFriendRes getOneUserToAddFriend(String email) {
        OneUserToAddFriendRss oneUserToAddFriendRss = userMybatisRepository.getOneUserToAddFriend(GetOneUserToAddFriendPrt.builder()
                .userId(commonAuthContext.getUserEntity().getId())
                .email(email)
                .build());
        if (oneUserToAddFriendRss == null) {
            throw new BusinessLogicException(-12);
        }
        OneUserToAddFriendRes oneUserToAddFriendRes = new OneUserToAddFriendRes();
        BeanCopyUtils.copyProperties(oneUserToAddFriendRes, oneUserToAddFriendRss);
        return oneUserToAddFriendRes;
    }

    @Override
    public CommonListResponse<ListFriendToAddGroupRes> getListFriendToAddGroup(String channelId, String search, Integer page, Integer size) {
        if (StringUtils.hasText(channelId)
                && userChannelJpaRepository.findByUserIdAndChannelIdAndStatusAndChannelType(
                commonAuthContext.getUserEntity().getId(),
                channelId,
                UserChannelStatusEnum.ACCEPT,
                ChannelTypeEnum.GROUP) == null) {
            throw new BusinessLogicException(-13);
        }
        Long countListFriend = userMybatisRepository.countListFriendToAddGroup(GetListFriendToAddGroupPrt.builder()
                .userId(commonAuthContext.getUserEntity().getId())
                .channelId(channelId)
                .search(search)
                .build());
        CommonPaginator commonPaginator = new CommonPaginator(page, size, countListFriend);
        if (countListFriend == 0) {
            return CommonListResponse.<ListFriendToAddGroupRes>builder()
                    .content(new ArrayList<>())
                    .page(commonPaginator.getPageNo())
                    .size(commonPaginator.getPageSize())
                    .totalPages(commonPaginator.getTotalPages())
                    .totalElements(commonPaginator.getTotalItems())
                    .build();
        }
        return CommonListResponse.<ListFriendToAddGroupRes>builder()
                .content(userMybatisRepository.getListFriendToAddGroup(GetListFriendToAddGroupPrt.builder()
                                .userId(commonAuthContext.getUserEntity().getId())
                                .channelId(channelId)
                                .search(search)
                                .offset(commonPaginator.getOffset())
                                .limit(commonPaginator.getLimit())
                                .build()).stream()
                        .map(o -> {
                                    ListFriendToAddGroupRes listUserToAddGroupRes = new ListFriendToAddGroupRes();
                                    BeanCopyUtils.copyProperties(listUserToAddGroupRes, o);
                                    return listUserToAddGroupRes;
                                }
                        )
                        .collect(Collectors.toList())
                )
                .page(commonPaginator.getPageNo())
                .size(commonPaginator.getPageSize())
                .totalPages(commonPaginator.getTotalPages())
                .totalElements(commonPaginator.getTotalItems())
                .build();
    }
}