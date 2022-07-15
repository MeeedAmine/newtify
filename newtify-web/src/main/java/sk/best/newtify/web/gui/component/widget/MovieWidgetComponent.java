package sk.best.newtify.web.gui.component.widget;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//import sk.best.newtify.api.MovieWidgetComponent;
import sk.best.newtify.api.dto.MovieDTO;
import sk.best.newtify.web.connector.MovieConnectorService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class MovieWidgetComponent extends FlexLayout{
    private static final long              serialVersionUID    = 1414727226197592073L;

    private final MovieConnectorService movieApi;

    MovieDTO mv ;
    public MovieWidgetComponent(MovieConnectorService movieApi) {
        this.movieApi = movieApi;
    }


    @PostConstruct
    private void init() {


        List<Map<String, Object>> movies = movieApi.getMoviesResponseEntity();

        for (int i=0; i<movies.toArray().length; i++) {
            String rank =  movies.get(i).get("rank").toString();
            String title =  movies.get(i).get("title").toString();
            String gross =  movies.get(i).get("gross").toString();

            createFiledPart(rank, title ,gross);
        }

        this.getStyle()
                .set("background", "var(--lumo-contrast-10pct)")
                .set("border-radius", "1em");
        this.setFlexDirection(FlexLayout.FlexDirection.COLUMN);
        this.setAlignItems(FlexComponent.Alignment.CENTER);
        this.setWidthFull();
    }

//    private void createWidgetIcon() {
//        Icon calendarIcon = VaadinIcon.CALENDAR_USER.create();
//        calendarIcon.setSize("5em");
//        calendarIcon.setColor("var(--lumo-contrast-color)");
//
//        this.add(calendarIcon);
//    }


    private void createFiledPart(String rank, String title, String gross) {


        H3 FieldValue = new H3(rank + " " + title + " "+gross + " "
        );
        FieldValue.getStyle()
                .set("color", "white")
                .set("font-style", "italic")
                .set("margin", "0")
                .set("text-allign","left");


        this.add(FieldValue);
    }

    private void createTitlePart(MovieDTO titledata) {
        Label TitleLabel = new Label("The title is");
        TitleLabel.getStyle()
                .set("color", "var(--lumo-contrast-color)")
                .set("margin", "1em 0 0 0");

        H3 TitleValue = new H3(titledata != null ? titledata.getTitle() : "Unknown");
        TitleValue.getStyle()
                .set("color", "white")
                .set("font-style", "italic")
                .set("margin", "0 0 1em 0");

        this.add(TitleLabel, TitleValue);
    }
}
