package com.athaydes.functions4j.monoid;

import java.util.Collection;
import java.util.Random;

import static com.athaydes.functions4j.Functions.generate;
import static java.util.Arrays.asList;

/**
 * @author Renato
 */
public class CollectionMonoidTest extends MonoidTest<Collection<String>> {

    StringMonoidTest stringMonoidTest = new StringMonoidTest();
    Random rand = new Random();

    @Override
    protected Monoid<Collection<String>> monoid() {
        return new CollectionMonoid<>();
    }

    @Override
    protected Collection<String> randomSample() {
        final int maxLength = 100;
        int randomLength = rand.nextInt( maxLength + 1 );
        return asList( generate( randomLength, String.class, stringMonoidTest::randomSample ) );
    }

}
