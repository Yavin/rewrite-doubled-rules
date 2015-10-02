package com.example;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Substitute;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class RewriteConfigurationProvider extends HttpConfigurationProvider {

    @Override
    public Configuration getConfiguration(ServletContext context) {
        return ConfigurationBuilder.begin()
            .addRule()
                .when(Direction.isOutbound().and(Path.matches("/faces/{file}.xhtml")))
                .perform(Substitute.with("/faces/{file}-rewrite.xhtml"));
    }

    @Override
    public int priority() {
        return 10;
    }
}
