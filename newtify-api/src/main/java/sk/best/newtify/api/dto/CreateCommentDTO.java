package sk.best.newtify.api.dto;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreateCommentDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-15T14:11:33.660158200+02:00[Europe/Vienna]")
public class CreateCommentDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("articleID")
  private String articleID;

  @JsonProperty("text")
  private String text;

  @JsonProperty("createdAt")
  private Long createdAt = null;

  @JsonProperty("author")
  private String author;

  public CreateCommentDTO articleID(String articleID) {
    this.articleID = articleID;
    return this;
  }

  /**
   * Get articleID
   * @return articleID
  */
  
  @Schema(name = "articleID", required = false)
  public String getArticleID() {
    return articleID;
  }

  public void setArticleID(String articleID) {
    this.articleID = articleID;
  }

  public CreateCommentDTO text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
  */
  
  @Schema(name = "text", required = false)
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public CreateCommentDTO createdAt(Long createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  */
  
  @Schema(name = "createdAt", required = false)
  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public CreateCommentDTO author(String author) {
    this.author = author;
    return this;
  }

  /**
   * Get author
   * @return author
  */
  
  @Schema(name = "author", required = false)
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCommentDTO createCommentDTO = (CreateCommentDTO) o;
    return Objects.equals(this.articleID, createCommentDTO.articleID) &&
        Objects.equals(this.text, createCommentDTO.text) &&
        Objects.equals(this.createdAt, createCommentDTO.createdAt) &&
        Objects.equals(this.author, createCommentDTO.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(articleID, text, createdAt, author);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCommentDTO {\n");
    sb.append("    articleID: ").append(toIndentedString(articleID)).append("\n");
    sb.append("    text: ").append(toIndentedString(text)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    author: ").append(toIndentedString(author)).append("\n");
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

