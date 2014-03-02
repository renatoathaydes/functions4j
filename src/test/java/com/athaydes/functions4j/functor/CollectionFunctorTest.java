package com.athaydes.functions4j.functor;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class CollectionFunctorTest {

    CollectionFunctor<String, Integer> str2intFunctor = new CollectionFunctor<>();

    @Test
    public void canFmapOverCollections() {
        Collection<Integer> ints = str2intFunctor
                .fmap( Integer::parseInt, Arrays.asList( "1", "2", "3" ) );
        assertEquals( ints, Arrays.asList( 1, 2, 3 ) );
    }

    @Test
    public void canFmapOverEmptyCollections() {
        Collection<Integer> ints = str2intFunctor
                .fmap( Integer::parseInt, Arrays.asList() );
        assertEquals( ints, Arrays.<Integer>asList() );
    }

}
