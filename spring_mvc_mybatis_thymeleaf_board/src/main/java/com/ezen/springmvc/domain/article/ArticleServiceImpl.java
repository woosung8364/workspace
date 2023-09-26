package com.ezen.springmvc.domain.article;

import com.ezen.springmvc.domain.article.dto.ArticleDTO;
import com.ezen.springmvc.domain.article.mapper.ArticleMapper;
import com.ezen.springmvc.domain.article.page.PageParams;
import com.ezen.springmvc.domain.article.page.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{

    private final ArticleMapper articleMapper;

    @Override
    public void create(ArticleDTO articleDTO) {
        articleMapper.create(articleDTO);
    }

    @Override
    public List<ArticleDTO> findAll() {
       return articleMapper.findAll();


    }

    @Override
    public List<ArticleDTO> findByAll(PageParams pageParams) {
        return articleMapper.findByAll(pageParams);
    }

    @Override
    public int getCountAll() {
        return articleMapper.getCountAll();
    }

    @Override
    public void createArticle(ArticleDTO articleDTO) {
        articleMapper.createArticle(articleDTO);
    }
}
