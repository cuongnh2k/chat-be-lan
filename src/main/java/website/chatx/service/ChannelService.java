package website.chatx.service;

import org.springframework.data.domain.Pageable;
import website.chatx.core.common.CommonListResponse;
import website.chatx.dto.res.jpa.ChannelRes;
import website.chatx.core.enums.ChannelTypeEnum;

public interface ChannelService {

    CommonListResponse<ChannelRes> search(ChannelTypeEnum type, String name, Pageable pageable);
}
