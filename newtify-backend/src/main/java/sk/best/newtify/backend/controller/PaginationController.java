package sk.best.newtify.backend.controller;

import sk.best.newtify.backend.entity.Article;
import sk.best.newtify.backend.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaginationController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("/news/{pageNo}/{pageSize}")
    public List<Article> getPaginatedArticles(@PathVariable int pageNo,
                                              @PathVariable int pageSize) {

        return articleService.findPaginated(pageNo, pageSize);
    }
}
