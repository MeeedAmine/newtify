package sk.best.newtify.backend.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sk.best.newtify.backend.entity.Article;
import sk.best.newtify.backend.entity.enums.TopicType;

import java.util.List;

@Repository
public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {

    List<Article> findAllByOrderByCreatedAt();

    List<Article> findAllByTopicType(TopicType topicType);
}
