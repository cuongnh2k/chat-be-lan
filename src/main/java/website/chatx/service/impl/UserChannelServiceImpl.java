package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.core.common.CommonPaginator;
import website.chatx.core.entities.ChannelEntity;
import website.chatx.core.entities.UserChannelEntity;
import website.chatx.core.entities.UserEntity;
import website.chatx.core.enums.ChannelTypeEnum;
import website.chatx.core.enums.UserChannelStatusEnum;
import website.chatx.core.exception.BusinessLogicException;
import website.chatx.core.utils.BeanCopyUtils;
import website.chatx.dto.prt.userchannel.GetListMemberPrt;
import website.chatx.dto.req.channel.AddFriendReq;
import website.chatx.dto.res.userchannel.list.ListMemberRes;
import website.chatx.repositories.jpa.ChannelJpaRepository;
import website.chatx.repositories.jpa.UserChannelJpaRepository;
import website.chatx.repositories.jpa.UserJpaRepository;
import website.chatx.repositories.mybatis.UserChannelMybatisRepository;
import website.chatx.service.UserChannelService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserChannelServiceImpl implements UserChannelService {

    private final UserChannelJpaRepository userChannelJpaRepository;
    private final ChannelJpaRepository channelJpaRepository;
    private final UserJpaRepository userJpaRepository;

    private final UserChannelMybatisRepository userChannelMybatisRepository;

    private final CommonAuthContext commonAuthContext;

    private final Log LOGGER = LogFactory.getLog(getClass());

    @Override
    @Transactional(readOnly = true)
    public CommonListResponse<ListMemberRes> getListMember(String channelId, String search, Integer page, Integer size) {
        Long countListMember = userChannelMybatisRepository.countListMember(GetListMemberPrt.builder()
                .userId(commonAuthContext.getUserEntity().getId())
                .channelId(channelId)
                .search(search)
                .build());
        CommonPaginator commonPaginator = new CommonPaginator(page, size, countListMember);
        if (countListMember == 0) {
            return CommonListResponse.<ListMemberRes>builder()
                    .content(new ArrayList<>())
                    .page(commonPaginator.getPageNo())
                    .size(commonPaginator.getPageSize())
                    .totalPages(commonPaginator.getTotalPages())
                    .totalElements(commonPaginator.getTotalItems())
                    .build();
        }
        return CommonListResponse.<ListMemberRes>builder()
                .content(userChannelMybatisRepository.getListMember(GetListMemberPrt.builder()
                                .userId(commonAuthContext.getUserEntity().getId())
                                .channelId(channelId)
                                .search(search)
                                .offset(commonPaginator.getOffset())
                                .limit(commonPaginator.getLimit())
                                .build()).stream()
                        .map(o -> {
                            ListMemberRes listMemberRes = new ListMemberRes();
                            BeanCopyUtils.copyProperties(listMemberRes, o);
                            return listMemberRes;
                        })
                        .collect(Collectors.toList())
                )
                .page(commonPaginator.getPageNo())
                .size(commonPaginator.getPageSize())
                .totalPages(commonPaginator.getTotalPages())
                .totalElements(commonPaginator.getTotalItems())
                .build();
    }

    @Override
    public void addFriend(AddFriendReq req) {
        UserEntity userEntity = userJpaRepository.findById(req.getUserId())
                .orElseThrow(() -> new BusinessLogicException(-14));
        List<UserChannelEntity> userChannelEntities = userChannelJpaRepository.findMyIdAndTheirId(
                commonAuthContext.getUserEntity().getId(),
                req.getUserId());
        if (CollectionUtils.isEmpty(userChannelEntities)) {
            ChannelEntity channelEntity = channelJpaRepository.save(ChannelEntity.builder()
                    .type(ChannelTypeEnum.FRIEND)
                    .build());
            UserChannelEntity userChannelEntity1 = UserChannelEntity.builder()
                    .status(UserChannelStatusEnum.ACCEPT)
                    .user(commonAuthContext.getUserEntity())
                    .channel(channelEntity)
                    .build();
            UserChannelEntity userChannelEntity2 = UserChannelEntity.builder()
                    .status(UserChannelStatusEnum.NEW)
                    .user(userEntity)
                    .channel(channelEntity)
                    .build();
            userChannelJpaRepository.saveAll(Arrays.asList(userChannelEntity1, userChannelEntity2));
            return;
        }
        userChannelEntities.forEach(o -> {
            if (o.getUser().getId().equals(commonAuthContext.getUserEntity().getId())
                    && (o.getStatus() == UserChannelStatusEnum.NEW || o.getStatus() == UserChannelStatusEnum.REJECT)) {
                o.setStatus(UserChannelStatusEnum.ACCEPT);
            } else {
                if (o.getStatus() == UserChannelStatusEnum.REJECT) {
                    o.setStatus(UserChannelStatusEnum.NEW);
                }
            }
        });
        userChannelJpaRepository.saveAll(userChannelEntities);
    }
}
