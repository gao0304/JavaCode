package frank.controller;

import frank.model.Article;
import frank.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/query/{id}")
    public Object queryById(@PathVariable("id") Integer id){
        Article article = articleService.queryById(id);
        return article;
    }
}
