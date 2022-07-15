package sk.best.newtify.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.ObjectError;

import java.io.Serializable;
import java.util.Objects;

public class MovieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("rank")
    private String rank;

    @JsonProperty("title")
    private String title;

    @JsonProperty("image")
    private String image;

    @JsonProperty("weekend")
    private String weekend;

    @JsonProperty("gross")
    private String gross;

    @JsonProperty("weeks")
    private String weeks;
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public String getGross() {
        return gross;
    }

    public void setGross(String gross) {
        this.gross = gross;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }


    @Schema(name = "id", required = false)
    public MovieDTO id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get month
     * @return month
     */

    @Schema(name = "rank", required = false)
    public MovieDTO rank(String rank) {
        this.rank = rank;
        return this;
    }

    /**
     * Get day
     * @return day
     */

    @Schema(name = "title", required = false)
    public MovieDTO title(String title) {
        this.title = title;
        return this;
    }

   @Schema(name = "image", required = false)
    public MovieDTO image(String image) {
        this.image = image;
        return this;
    }

    @Schema(name = "weekend",required = false)
    public MovieDTO weekend(String weekend) {
        this.weekend = weekend;
        return this;
    }

    @Schema(name = "gross",required = false)
    public MovieDTO gross(String gross) {
        this.gross = gross;
        return this;
    }

    @Schema(name = "weeks",required = false)
    public MovieDTO weeks(String weeks) {
        this.weeks = weeks;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(this.id, movieDTO.id) &&
                Objects.equals(this.rank, movieDTO.rank) &&
                Objects.equals(this.title, movieDTO.rank) &&
                Objects.equals(this.image,movieDTO.image) &&
                Objects.equals(this.weekend,movieDTO.weekend) &&
                Objects.equals(this.gross,movieDTO.gross) &&
                Objects.equals(this.weeks,movieDTO.weeks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,rank,title,image,weekend,gross,weeks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MovieDTO {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    weekend: ").append(toIndentedString(weekend)).append("\n");
        sb.append("    gross: ").append(toIndentedString(gross)).append("\n");
        sb.append("    weeks: ").append(toIndentedString(weeks)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
