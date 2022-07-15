package sk.best.newtify.web.gui.component.widget;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sk.best.newtify.api.dto.MovieDTO;
import sk.best.newtify.web.connector.CocktailConnectorService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CocktailWidgetComponent extends FlexLayout{
    private static final long              serialVersionUID    = 1414727226197592073L;

    private final CocktailConnectorService cocktailAPI;


    MovieDTO mv ;
    public CocktailWidgetComponent(CocktailConnectorService cocktailAPI) {
        this.cocktailAPI = cocktailAPI;
    }


    @PostConstruct
    private void init() {


        List<Map<String, Object>> cocktail = cocktailAPI.getCocktailsResponseEntity();

        for (int i=0; i<cocktail.toArray().length; i++) {
            String imageUrl =  cocktail.get(i).get("strDrinkThumb").toString();
            String name =  cocktail.get(i).get("strDrink").toString();


            createFiledPart(imageUrl, name);
        }

        this.getStyle()
                .set("background", "var(--lumo-contrast-10pct)")
                .set("border-radius", "1em");
        this.setFlexDirection(FlexDirection.COLUMN);
        this.setAlignItems(Alignment.CENTER);
        this.setWidthFull();
    }

    private void createFiledPart(String imageUrl, String name) {

        Image image = new Image(imageUrl, name);
        H3 FieldValue = new H3(name);
        FieldValue.getStyle()
                .set("color", "white")
                .set("font-style", "italic")
                .set("margin", "0")
                .set("text-allign","left");


        this.add(FieldValue,image);
    }

    private void createWidgetIcon() {
        Icon drinkIcon = VaadinIcon.GLASS.create();
        drinkIcon.setSize("2em");
        drinkIcon.setColor("var(--lumo-contrast-color)");

        this.add(drinkIcon);
    }
    private void createTitlePart() {
        Label TitleLabel = new Label("Your drink of the day");
        TitleLabel.getStyle()
                .set("color", "var(--lumo-contrast-color)")
                .set("margin", "1em 0 0 0");

        H3 TitleValue = new H3("Your drink of the day");
        TitleValue.getStyle()
                .set("color", "white")
                .set("font-style", "italic")
                .set("margin", "0 0 1em 0");

        this.add(TitleLabel, TitleValue);
    }
}
