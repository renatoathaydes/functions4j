package com.athaydes.functions4j.monoid;

/**
 * @author Renato
 */
public class AddMonoidTest extends MonoidTest<Long> {

    @Override
    protected Monoid<Long> monoid() {
        return AddMonoid.addLongsMonoid();
    }

    @Override
    protected Long randomSample() {
        return rand.nextLong();
    }

}
