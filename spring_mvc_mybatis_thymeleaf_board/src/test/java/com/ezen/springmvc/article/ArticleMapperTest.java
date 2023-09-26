package com.ezen.springmvc.article;

import com.ezen.springmvc.domain.article.ArticleService;
import com.ezen.springmvc.domain.article.dto.ArticleDTO;
import com.ezen.springmvc.domain.article.page.PageParams;
import com.ezen.springmvc.domain.member.dto.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ezen.springmvc.domain.article.mapper.ArticleMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@SpringBootTest
@Slf4j
public class ArticleMapperTest {

    @Autowired
    private ArticleService articleMapper;

    @Test
    public void findByAllTest() {
        PageParams pageParams = new PageParams();
        List<ArticleDTO> list = articleMapper.findByAll(pageParams);
        for (ArticleDTO aa : list) {
            log.info("{}", aa);
        }
    }
}
	
	
