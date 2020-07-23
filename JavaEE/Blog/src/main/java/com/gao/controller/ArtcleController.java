package com.gao.controller;

import com.gao.model.Article;
import com.gao.service.ArtcleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ArtcleController {

    @Autowired
    private ArtcleService artcleService;

    @RequestMapping("/")
    public String index(Model model){
        List<Article> articles = artcleService.queryArticles();
        model.addAttribute("articleList", articles);
        return "index";
    }
}
