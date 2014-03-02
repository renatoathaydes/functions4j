package functor;

import com.athaydes.functions4j.functor.OptionalFunctor;
import org.junit.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class OptionalFunctorExample {

    OptionalFunctor<String, Integer> functor = new OptionalFunctor<>();

    Collection<Optional<String>> optionals = asList(
            Optional.of( "200" ), Optional.of( "250" ), Optional.empty(), Optional.of( "100" )
    );

    @Test
    public void transformingOptionals() {
        Collection<Optional<Integer>> intOptionals = optionals.stream()
                .map( ( optional ) -> functor.fmap( Integer::parseInt, optional ) )
                .collect( Collectors.toList() );

        assertResult( intOptionals );
    }

    @Test
    public void usingPartiallyAppliedFunctors() {
        Function<Optional<String>, Optional<Integer>> partiallyAppliedFunctor =
                functor.partiallyApply( Integer::parseInt );

        Collection<Optional<Integer>> intOptionals = optionals.stream()
                .map( partiallyAppliedFunctor )
                .collect( Collectors.toList() );

        assertResult( intOptionals );
    }

    @Test
    public void usingOnlyJava8() {
        Collection<Optional<Integer>> intOptionals = optionals.stream()
                .map( ( opt ) -> opt.isPresent() ?
                        Optional.of( Integer.parseInt( opt.get() ) ) :
                        Optional.<Integer>empty() )
                .collect( Collectors.toList() );

        assertResult( intOptionals );
    }

    private void assertResult( Collection<Optional<Integer>> intOptionals ) {
        assertEquals( intOptionals, asList(
                Optional.of( 200 ), Optional.of( 250 ), Optional.<Integer>empty(), Optional.of( 100 )
        ) );
    }


}
