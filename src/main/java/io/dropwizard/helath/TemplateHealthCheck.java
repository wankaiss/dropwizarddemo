package io.dropwizard.helath;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {

  private final String template;

  public TemplateHealthCheck(String template) {
    this.template = template;
  }

  protected Result check() throws Exception {
    final String saying = String.format(template, "TEST");
    if (!saying.contains("TEST")) {
      return Result.unhealthy("template doesn't incloud a name");
    }
    return Result.healthy();
  }
}
