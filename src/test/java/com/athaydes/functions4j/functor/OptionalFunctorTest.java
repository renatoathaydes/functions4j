package com.athaydes.functions4j.functor;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * @author Renato
 */
public class OptionalFunctorTest {

    OptionalFunctor<String, Integer> optionalFunctor = new OptionalFunctor<>();

    @Test
    public void canFmapOverOptional() {
        Optional<Integer> result = optionalFunctor.fmap( Integer::parseInt, Optional.of( "3" ) );
        assertEquals( 3, result.get().intValue() );
    }

    @Test
    public void canFmapOverEmptyOptional() {
        Optional<Integer> result = optionalFunctor.fmap( Integer::parseInt, Optional.empty() );
        assertFalse( result.isPresent() );
    }

}
