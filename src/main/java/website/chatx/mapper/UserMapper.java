package website.chatx.mapper;

import org.mapstruct.Mapper;
import website.chatx.core.base.BaseCustomMapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseCustomMapper {
//    public abstract UserRes toUserRes(UserEntity userEntity);
}
