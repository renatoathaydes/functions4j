package com.athaydes.functions4j.monoid;

/**
 * @author Renato
 */
public class ProductMonoidTest extends MonoidTest<Long> {

    @Override
    protected Monoid<Long> monoid() {
        return ProductMonoid.multiplyLongsMonoid();
    }

    @Override
    protected Long randomSample() {
        return rand.nextLong();
    }
}
