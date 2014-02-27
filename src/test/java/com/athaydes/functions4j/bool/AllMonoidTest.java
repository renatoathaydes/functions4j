package com.athaydes.functions4j.bool;

import com.athaydes.functions4j.Monoid;
import com.athaydes.functions4j.MonoidTest;

import java.util.Random;

/**
 * @author Renato
 */
public class AllMonoidTest extends MonoidTest<Boolean> {

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
