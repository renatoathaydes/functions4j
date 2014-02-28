package com.athaydes.functions4j.compare;

import com.athaydes.functions4j.Monoid;
import com.athaydes.functions4j.MonoidTest;

import java.util.Random;

import static com.athaydes.functions4j.compare.Ordering.asOrdering;

/**
 * @author Renato
 */
public class OrderingMonoidTest extends MonoidTest<Ordering> {

    private final Random rand = new Random();

    @Override
    protected Monoid<Ordering> monoid() {
        return new OrderingMonoid();
    }

    @Override
    protected Ordering randomSample() {
        return asOrdering( rand.nextInt() );
    }

}
