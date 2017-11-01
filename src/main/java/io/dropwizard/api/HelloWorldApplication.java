package io.dropwizard.api;

import io.dropwizard.Application;
import io.dropwizard.helath.TemplateHealthCheck;
import io.dropwizard.services.HelloWorldResource;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
  public static void main(String[] args) throws Exception {
    new HelloWorldApplication().run(args);
  }

  public String getName() {
    return "hello-world";
  }

  public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {

  }

  public void run(HelloWorldConfiguration configuration, Environment environment) {
    final HelloWorldResource resource = new HelloWorldResource(
        configuration.getTemplate(),
        configuration.getDefaultName()
    );
    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }
}
