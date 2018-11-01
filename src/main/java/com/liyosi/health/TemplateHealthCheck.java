package com.liyosi.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by liyosi on Nov, 2018
 */
public class TemplateHealthCheck extends HealthCheck {
  private final String template;

  public TemplateHealthCheck(String template) {
    this.template = template;
  }

  @Override
  protected Result check() throws Exception {
    final String param = "TEST";
    final String saying = String.format(template, param);

    if (!saying.contains(param)) {
      return Result.healthy("template doesn't include a name");
    }

    return Result.healthy();
  }
}
