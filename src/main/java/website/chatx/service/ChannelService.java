package website.chatx.service;

import org.springframework.data.domain.Pageable;
import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.entity.ChannelEntityRes;
import website.chatx.core.enums.ChannelTypeEnum;

public interface ChannelService {

    CommonListResponse<ChannelEntityRes> search(ChannelTypeEnum type, String name, Pageable pageable);
}
