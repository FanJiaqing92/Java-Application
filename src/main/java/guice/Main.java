package guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MyModule());
        Feed feed = injector.getInstance(Feed.class);
        feed.feed();
    }
}
