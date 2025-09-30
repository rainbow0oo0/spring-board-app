package kr.co.sboard;

import com.querydsl.core.Tuple;
import kr.co.sboard.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class SboardApplicationTests {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    void test1(){

        Pageable pageable = PageRequest.of(0, 10);

        Page<Tuple> pageTuple= articleRepository.selectArticleAllForList(pageable);

        List<Tuple> tupleList = pageTuple.getContent();

        System.out.println(tupleList);

    }

}
