package website.chatx.service;

import org.springframework.data.domain.Pageable;
import website.chatx.common.CommonListResponse;
import website.chatx.dto.res.jpa.ChannelRes;
import website.chatx.enums.ChannelTypeEnum;

public interface ChannelService {

    CommonListResponse<ChannelRes> search(ChannelTypeEnum type, String name, Pageable pageable);
}
