package sk.best.newtify.web.gui.view;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import org.springframework.beans.factory.ObjectFactory;
import sk.best.newtify.api.ArticlesApi;
import sk.best.newtify.api.dto.ArticleDTO;
import sk.best.newtify.web.gui.component.article.ArticlePreviewComponent;
import sk.best.newtify.web.gui.component.widget.MovieWidgetComponent;
import sk.best.newtify.web.gui.component.widget.NameDayWidgetComponent;
import sk.best.newtify.web.gui.layout.MainLayout;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@PageTitle("Movie")
@Route(value = "movie", layout = MainLayout.class)
public class MovieView extends FlexLayout {

    private static final long serialVersionUID = 4107656392983873278L;

    private final ArticlesApi articlesApi;
    private final ObjectFactory<ArticlePreviewComponent> articlePreviewObjectFactory;
    private final ObjectFactory<NameDayWidgetComponent>  nameDayWidgetComponentObjectFactory;
    private final ObjectFactory<MovieWidgetComponent> movieWidgetComponentObjectFactory;

    private final VerticalLayout middleContent      = new VerticalLayout();
    private final VerticalLayout leftWidgetContent  = new VerticalLayout();
    private final VerticalLayout rightWidgetContent = new VerticalLayout();

    private List<ArticleDTO> articles = Collections.emptyList();

    public MovieView(ArticlesApi articlesApi,
                    ObjectFactory<ArticlePreviewComponent> articlePreviewObjectFactory,
                    ObjectFactory<NameDayWidgetComponent> nameDayWidgetComponentObjectFactory,
                    ObjectFactory<MovieWidgetComponent> movieWidgetComponentObjectFactory) {
        this.articlesApi                         = articlesApi;
        this.articlePreviewObjectFactory         = articlePreviewObjectFactory;
        this.nameDayWidgetComponentObjectFactory = nameDayWidgetComponentObjectFactory;
        this.movieWidgetComponentObjectFactory = movieWidgetComponentObjectFactory;
    }

    @PostConstruct
    protected void init() {
        createMainPane();
        createLeftWidgetPane();
        createRightWidgetPane();

        add(leftWidgetContent, middleContent, rightWidgetContent);
    }

    private void createMainPane() {
        middleContent.removeAll();
        middleContent.setAlignItems(Alignment.CENTER);
        setFlexShrink(1, middleContent);
        setFlexGrow(2, middleContent);

        fetchArticles();
        for (ArticleDTO article : articles) {
            ArticlePreviewComponent previewComponent = articlePreviewObjectFactory.getObject();
            previewComponent.setArticle(article);
            middleContent.add(previewComponent);
        }
    }

    private void createRightWidgetPane() {
        rightWidgetContent.removeAll();
        rightWidgetContent.setAlignItems(Alignment.CENTER);
        setFlexShrink(2, rightWidgetContent);
        setFlexGrow(1, rightWidgetContent);
    }

    private void createLeftWidgetPane() {
        leftWidgetContent.removeAll();
        leftWidgetContent.setAlignItems(Alignment.CENTER);
        setFlexShrink(2, leftWidgetContent);
        setFlexGrow(1, leftWidgetContent);

        //NameDayWidgetComponent nameDayWidget = nameDayWidgetComponentObjectFactory.getObject();
        MovieWidgetComponent movieWidgetComponent = movieWidgetComponentObjectFactory.getObject();

        leftWidgetContent.add(movieWidgetComponent);

    }

    private void fetchArticles() {
        articles = articlesApi.retrieveArticles(null).getBody();
    }

}
