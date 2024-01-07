package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import website.chatx.dto.prt.user.GetStatusFriendPrt;
import website.chatx.dto.rss.user.StatusFriendRss;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMybatisRepository {

    private final SqlSession sqlSession;

    public List<StatusFriendRss> getStatusFriend(GetStatusFriendPrt prt) {
        return sqlSession.selectList("UserMybatisRepository.getStatusFriend", prt);
    }
}
