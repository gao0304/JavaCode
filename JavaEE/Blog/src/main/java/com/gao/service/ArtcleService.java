package com.gao.service;

import com.gao.mapper.ArticleMapper;
import com.gao.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtcleService {

    //mapper需要加上@Mapper，MyBatis才能将Mapper注册到Spring容器中
    @Autowired
    private ArticleMapper articleMapper;


    public List<Article> queryArticles() {
        return articleMapper.selectAll();
    }
}
