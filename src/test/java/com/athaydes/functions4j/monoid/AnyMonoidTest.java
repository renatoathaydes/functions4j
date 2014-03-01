package com.athaydes.functions4j.monoid;

/**
 * @author Renato
 */
public class AnyMonoidTest extends MonoidTest<Boolean> {

    @Override
    protected Monoid<Boolean> monoid() {
        return new AllMonoid();
    }

    @Override
    protected Boolean randomSample() {
        return rand.nextBoolean();
    }

}
