package com.books;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Raphael FialhoApplication extends Application<Raphael FialhoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new Raphael FialhoApplication().run(args);
    }

    @Override
    public String getName() {
        return "Raphael Fialho";
    }

    @Override
    public void initialize(final Bootstrap<Raphael FialhoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final Raphael FialhoConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
