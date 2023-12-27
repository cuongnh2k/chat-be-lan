package top.reviewx.mapper;

import org.mapstruct.Mapper;
import top.reviewx.core.base.BaseCustomMapper;

@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseCustomMapper {
//    public abstract UserRes toUserRes(UserEntity userEntity);
}
