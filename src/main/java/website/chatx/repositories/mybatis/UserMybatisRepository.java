package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import website.chatx.dto.prt.user.GetListFriendToAddGroupPrt;
import website.chatx.dto.prt.user.GetOneUserToAddFriendPrt;
import website.chatx.dto.rss.user.ListFriendToAddGroupRss;
import website.chatx.dto.rss.user.OneUserToAddFriendRss;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMybatisRepository {

    private final SqlSession sqlSession;

    public OneUserToAddFriendRss getOneUserToAddFriend(GetOneUserToAddFriendPrt prt) {
        return sqlSession.selectOne("UserMybatisRepository.getOneUserToAddFriend", prt);
    }

    public Long countListFriendToAddGroup(GetListFriendToAddGroupPrt prt) {
        return sqlSession.selectOne("UserMybatisRepository.countListFriendToAddGroup", prt);
    }

    public List<ListFriendToAddGroupRss> getListFriendToAddGroup(GetListFriendToAddGroupPrt prt) {
        return sqlSession.selectList("UserMybatisRepository.getListFriendToAddGroup", prt);
    }
}
