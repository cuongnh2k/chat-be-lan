package website.chatx.repositories.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChannelMybatisRepository {

    private final SqlSession sqlSession;

    public Integer count() {
        return sqlSession.selectOne("ChannelMybatisRepository.test");
    }
}
