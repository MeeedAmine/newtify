package sk.best.newtify.web.connector;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.CastUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.best.newtify.api.dto.MovieDTO;

import java.awt.*;
import java.util.Map;
import java.util.List;


@Slf4j
@Service
public class MovieConnectorService {
    private static final String MOVIE_API_URL = "https://imdb-api.com/en/API/BoxOffice/k_n17e82s1";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<Map<String, Object>> moviesResponseEntity = CastUtils.cast(
            restTemplate.getForEntity(MOVIE_API_URL, Map.class)
    );
    Map<String, Object> moviesApiParam2DataMap = moviesResponseEntity.getBody();



    public List<Map<String, Object>> getMoviesResponseEntity() {
        List<Map<String, Object>> items = (List<Map<String, Object>>) moviesResponseEntity.getBody().get("items");

        items.get(0).get("title");
        return items;
    }
//    private final RestTemplate restTemplate = new RestTemplate();
//
//    public ResponseEntity<MovieDTO> retrieveMovies() {
//        try {
//            return restTemplate.getForEntity(MOVIE_API_URL, MovieDTO.class);
//        } catch (Exception e) {
//            log.error("ERROR movie", e);
//            return ResponseEntity
//                    .internalServerError()
//                    .build();
//        }
//    }
}
