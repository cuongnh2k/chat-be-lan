package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import website.chatx.dto.prt.user.GetListFriendToAddGroupPrt;
import website.chatx.dto.prt.user.GetStatusFriendPrt;
import website.chatx.dto.rss.user.ListFriendToAddGroupRss;
import website.chatx.dto.rss.user.StatusFriendRss;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMybatisRepository {

    private final SqlSession sqlSession;

    public List<StatusFriendRss> getStatusFriend(GetStatusFriendPrt prt) {
        return sqlSession.selectList("UserMybatisRepository.getStatusFriend", prt);
    }

    public Long countListFriendToAddGroup(GetListFriendToAddGroupPrt prt) {
        return sqlSession.selectOne("UserMybatisRepository.countListFriendToAddGroup", prt);
    }

    public List<ListFriendToAddGroupRss> getListFriendToAddGroup(GetListFriendToAddGroupPrt prt) {
        return sqlSession.selectList("UserMybatisRepository.getListFriendToAddGroup", prt);
    }
}
