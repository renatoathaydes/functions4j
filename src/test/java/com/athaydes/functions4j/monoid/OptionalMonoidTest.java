package com.athaydes.functions4j.monoid;

import java.util.Optional;

/**
 * @author Renato
 */
public class OptionalMonoidTest extends MonoidTest<Optional<String>> {

    final StringMonoidTest stringMonoidTest = new StringMonoidTest();

    @Override
    protected Monoid<Optional<String>> monoid() {
        return OptionalMonoid.withString();
    }

    @Override
    protected Optional<String> randomSample() {
        return rand.nextFloat() < 0.05f ?
                Optional.empty() :
                Optional.of( stringMonoidTest.randomSample() );
    }

}
