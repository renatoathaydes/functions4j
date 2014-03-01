package com.athaydes.functions4j.monoid;

import java.util.Random;

/**
 * @author Renato
 */
public class AnyMonoidTest extends MonoidTest<Boolean> {

    Random rand = new Random();

    @Override
    protected Monoid<Boolean> monoid() {
        return new AllMonoid();
    }

    @Override
    protected Boolean randomSample() {
        return rand.nextBoolean();
    }

}
