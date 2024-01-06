package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import website.chatx.dto.prt.user.GetListUserToAddFriendPrt;
import website.chatx.dto.rss.user.ListUserToAddFriendRss;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMybatisRepository {

    private final SqlSession sqlSession;

    public Long countListUserToAddFriend(GetListUserToAddFriendPrt prt) {
        return sqlSession.selectOne("UserMybatisRepository.countListUserToAddFriend", prt);
    }

    public List<ListUserToAddFriendRss> getListUserToAddFriend(GetListUserToAddFriendPrt prt) {
        return sqlSession.selectList("UserMybatisRepository.getListUserToAddFriend", prt);
    }
}
