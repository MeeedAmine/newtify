package sk.best.newtify.web.connector;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.CastUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class CocktailConnectorService {
    private static final String CK_API_URL = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Map<String, Object>> cocktailsResponseEntity = CastUtils.cast(
            restTemplate.getForEntity(CK_API_URL, Map.class)
    );
    Map<String, Object> moviesApiParam2DataMap = cocktailsResponseEntity.getBody();



    public List<Map<String, Object>> getCocktailsResponseEntity() {
        List<Map<String, Object>> items = (List<Map<String, Object>>) cocktailsResponseEntity.getBody().get("items");

        return items;
    }

}
