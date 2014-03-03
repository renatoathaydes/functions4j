package com.athaydes.functions4j.functor;

import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * @author Renato
 */
public class OptionalApplicativeTest {

    OptionalApplicative<Integer, String> applicative = new OptionalApplicative<>();

    @Test
    public void canApplyFunctionOptionalToOptional() {
        Optional<String> result = applicative.apply(
                Optional.of( ( s ) -> "The number " + s ), Optional.of( 4 ) );

        assertTrue( result.isPresent() );
        assertThat( result.get(), is( "The number 4" ) );
    }

    @Test
    public void canApplyFunctionOptionalToEmptyOption() {
        Optional<String> result = applicative.apply(
                Optional.of( ( s ) -> "The number " + s ), Optional.empty() );

        assertFalse( result.isPresent() );
    }

    @Test
    public void canApplyEmptyFunctionOptionalToOptional() {
        Optional<String> result = applicative.apply(
                Optional.empty(), Optional.of( 4 ) );

        assertFalse( result.isPresent() );

    }

}
