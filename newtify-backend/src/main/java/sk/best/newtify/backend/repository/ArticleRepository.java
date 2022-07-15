package sk.best.newtify.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import sk.best.newtify.backend.entity.Article;
import sk.best.newtify.backend.entity.enums.TopicType;

import java.util.List;

public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {

    List<Article> findAllByOrderByCreatedAt();

    List<Article> findAllByTopicType(TopicType topicType);
}
