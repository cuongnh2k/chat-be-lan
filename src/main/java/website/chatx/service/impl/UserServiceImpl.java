package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.core.common.CommonPaginator;
import website.chatx.core.utils.BeanCopyUtils;
import website.chatx.dto.prt.user.GetListUserToAddFriendPrt;
import website.chatx.dto.res.user.ListUserToAddFriendRes;
import website.chatx.repositories.mybatis.UserMybatisRepository;
import website.chatx.service.UserService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMybatisRepository userMybatisRepository;

    private final CommonAuthContext commonAuthContext;

    @Override
    @Transactional(readOnly = true)
    public CommonListResponse<ListUserToAddFriendRes> getListUserToAddFriend(String search, Integer page, Integer size) {
        Long countListUserToAddFriend = userMybatisRepository.countListUserToAddFriend(GetListUserToAddFriendPrt.builder()
                .userId(commonAuthContext.getUserEntity().getId())
                .search(search)
                .build());
        if (countListUserToAddFriend == 0) {
            return CommonListResponse.<ListUserToAddFriendRes>builder()
                    .content(new ArrayList<>())
                    .page(page)
                    .size(size)
                    .totalPages(0)
                    .totalElements(0L)
                    .build();
        }
        CommonPaginator commonPaginator = new CommonPaginator(page, size, countListUserToAddFriend);
        return CommonListResponse.<ListUserToAddFriendRes>builder()
                .content(userMybatisRepository.getListUserToAddFriend(GetListUserToAddFriendPrt.builder()
                                .userId(commonAuthContext.getUserEntity().getId())
                                .search(search)
                                .offset(commonPaginator.getOffset())
                                .limit(commonPaginator.getLimit())
                                .build()).stream()
                        .map(o -> {
                                    ListUserToAddFriendRes listUserToAddFriendRes = new ListUserToAddFriendRes();
                                    BeanCopyUtils.copyProperties(listUserToAddFriendRes, o);
                                    return listUserToAddFriendRes;
                                }
                        )
                        .collect(Collectors.toList())
                )
                .page(commonPaginator.getPageNo())
                .size(commonPaginator.getPageSize())
                .totalPages(commonPaginator.getTotalPages())
                .totalElements(countListUserToAddFriend)
                .build();
    }
}