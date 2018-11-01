package com.liyosi;

import com.liyosi.health.TemplateHealthCheck;
import com.liyosi.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by liyosi on Nov, 2018
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

  public static void main(String[] args) throws Exception {
    new HelloWorldApplication().run(args);
  }

  @Override
  public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {

    final HelloWorldResource resource = new HelloWorldResource(
        helloWorldConfiguration.getTemplate(),
        helloWorldConfiguration.getDefaultName());

    final TemplateHealthCheck healthCheck =
        new TemplateHealthCheck(helloWorldConfiguration.getTemplate());

    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);
  }

  @Override
  public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
    super.initialize(bootstrap);
  }

  @Override
  public String getName() {
    return "hellworld-dropwizard";
  }
}
