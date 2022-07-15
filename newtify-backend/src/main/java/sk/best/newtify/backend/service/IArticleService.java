package sk.best.newtify.backend.service;
import sk.best.newtify.backend.entity.Article;
import java.util.List;

public interface IArticleService {
    List<Article> findPaginated(int pageNo, int pageSize) ;
}
