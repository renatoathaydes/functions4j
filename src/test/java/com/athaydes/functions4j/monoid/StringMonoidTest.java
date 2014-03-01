package com.athaydes.functions4j.monoid;

import java.util.UUID;

/**
 * @author Renato
 */
public class StringMonoidTest extends MonoidTest<String> {

    @Override
    protected Monoid<String> monoid() {
        return new StringMonoid();
    }

    @Override
    public String randomSample() {
        return UUID.randomUUID().toString();
    }

}
