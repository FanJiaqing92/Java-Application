package guice;

import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {
    @Override
    public void configure() {
        bind(Animal.class).to(Cat.class);
        bind(Food.class).to(CatFood.class);
        bind(Feed.class).to(Person.class);
    }
}
