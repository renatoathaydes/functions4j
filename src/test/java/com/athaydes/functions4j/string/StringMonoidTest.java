package com.athaydes.functions4j.string;

import com.athaydes.functions4j.Monoid;
import com.athaydes.functions4j.MonoidTest;

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
    protected String randomSample() {
        return UUID.randomUUID().toString();
    }
}
