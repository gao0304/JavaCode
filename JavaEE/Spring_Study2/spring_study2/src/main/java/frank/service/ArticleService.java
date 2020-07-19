package frank.service;

import frank.mapper.ArticleMapper;
import frank.model.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public Article queryById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }
}
