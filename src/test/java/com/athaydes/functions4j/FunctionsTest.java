package com.athaydes.functions4j;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Renato
 */
public class FunctionsTest {

    @Test
    public void testRepeat() {
        String[] strResult = Functions.repeat( 2, String.class, "hi" );
        String[] strExpected = { "hi", "hi" };
        assertArrayEquals( strResult, strExpected );

        Integer[] intResult = Functions.repeat( 0, Integer.class, null );
        Integer[] intExpected = { };
        assertArrayEquals( intResult, intExpected );

        intResult = Functions.repeat( 10, Integer.class, 2 );
        intExpected = new Integer[]{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 };
        assertArrayEquals( intResult, intExpected );
    }

    @Test
    public void testGenerate() {
        String[] strResult = Functions.generate( 2, String.class, () -> "hi" );
        String[] strExpected = { "hi", "hi" };
        assertArrayEquals( strResult, strExpected );

        Integer[] intResult = Functions.generate( 0, Integer.class, () -> 0 );
        Integer[] intExpected = { };
        assertArrayEquals( intResult, intExpected );

        AtomicInteger count = new AtomicInteger( 0 );
        intResult = Functions.generate( 10, Integer.class, count::getAndIncrement );
        intExpected = new Integer[]{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        assertArrayEquals( intResult, intExpected );
    }

}
