package io.dropwizard.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Saying {
  private long id;

  @Length(max = 3)
  private String content;

  public Saying() {

  }

  public Saying(long id, String content) {
    this.id = id;
    this.content = content;
  }

  @JsonProperty
  public long getId() {
    return id;
  }

  @JsonProperty
  public void setId(long id) {
    this.id = id;
  }

  @JsonProperty
  public String getContent() {
    return content;
  }

  @JsonProperty
  public void setContent(String content) {
    this.content = content;
  }
}
