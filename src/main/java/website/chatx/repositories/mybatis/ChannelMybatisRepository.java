package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import website.chatx.dto.prt.channel.GetListChannelPrt;
import website.chatx.dto.rss.channel.ListChannelRss;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ChannelMybatisRepository {

    private final SqlSession sqlSession;

    public Integer countListChannel(GetListChannelPrt prt) {
        return sqlSession.selectOne("ChannelMybatisRepository.countListChannel", prt);
    }

    public List<ListChannelRss> getListChannel(GetListChannelPrt prt) {
        return sqlSession.selectList("ChannelMybatisRepository.getListChannel", prt);
    }
}
