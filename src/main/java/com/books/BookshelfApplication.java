package com.books;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BookshelfApplication extends Application<BookshelfConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BookshelfApplication().run(args);
    }

    @Override
    public String getName() {
        return "Bookshelf";
    }

    @Override
    public void initialize(final Bootstrap<BookshelfConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final BookshelfConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
