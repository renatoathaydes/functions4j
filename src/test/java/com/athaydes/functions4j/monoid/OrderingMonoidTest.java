package com.athaydes.functions4j.monoid;

import com.athaydes.functions4j.compare.Ordering;

import static com.athaydes.functions4j.compare.Ordering.asOrdering;

/**
 * @author Renato
 */
public class OrderingMonoidTest extends MonoidTest<Ordering> {

    @Override
    protected Monoid<Ordering> monoid() {
        return new OrderingMonoid();
    }

    @Override
    protected Ordering randomSample() {
        return asOrdering( rand.nextInt() );
    }

}
