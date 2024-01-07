package website.chatx.service.impl;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.chatx.core.common.CommonAuthContext;
import website.chatx.core.common.CommonListResponse;
import website.chatx.core.common.CommonPaginator;
import website.chatx.core.utils.BeanCopyUtils;
import website.chatx.dto.prt.userchannel.GetListMemberPrt;
import website.chatx.dto.res.userchannel.list.ListMemberRes;
import website.chatx.repositories.mybatis.UserChannelMybatisRepository;
import website.chatx.service.UserChannelService;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserChannelServiceImpl implements UserChannelService {

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
}
