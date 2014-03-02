package com.athaydes.functions4j.functor;

import org.junit.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class FunctionFunctorTest {

    FunctionFunctor<Optional<String>, Optional<Integer>, Boolean> functor =
            new FunctionFunctor<>();

    OptionalFunctor<String, Integer> optionalFunctor =
            new OptionalFunctor<>();

    Collection<Optional<String>> ages = asList(
            Optional.of( "30" ), Optional.<String>empty(), Optional.of( "15" )
    );

    @Test
    public void canUseFunctionFunctor() {
        Function<Optional<String>, Boolean> isMinor = functor.fmap(
                ( intOptional ) -> intOptional.orElse( 100 ) < 18,
                ( strOptional ) -> optionalFunctor.fmap( Integer::parseInt, strOptional ) );

        Stream<Optional<String>> onlyMinors = ages.stream()
                .filter( isMinor::apply );

        assertResult( onlyMinors );
    }

    private void assertResult( Stream<Optional<String>> result ) {
        assertEquals( asList( Optional.of( "15" ) ), result.collect( Collectors.toList() ) );
    }

}
