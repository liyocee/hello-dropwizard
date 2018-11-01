package com.liyosi.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by liyosi on Nov, 2018
 */
public class Saying {

  private Long id;

  @Length(max = 3)
  private String content;

  public Saying() {
  }

  public Saying(Long id, String content) {
    this.id = id;
    this.content = content;
  }

  @JsonProperty
  public Long getId() {
    return id;
  }

  @JsonProperty
  public String getContent() {
    return content;
  }
}
