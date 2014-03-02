package functor;

import com.athaydes.functions4j.functor.CollectionFunctor;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class CollectionFunctorExample {

    CollectionFunctor<String, String> collectionFunctor = new CollectionFunctor<>();

    Collection<String> vowels = asList( "a", "e", "i", "o", "u" );
    Collection<String> consonants = asList( "b", "c", "d", "f", "g" );

    @Test
    public void can() {
        Function<Collection<String>, Collection<String>> toUpper =
                collectionFunctor.partiallyApply( String::toUpperCase );

        Collection<Collection<String>> uppercasedVowelsAndConsonants =
                asList( vowels, consonants ).stream()
                        .map( toUpper )
                        .collect( Collectors.toList() );

        assertResult( uppercasedVowelsAndConsonants );
    }

    private void assertResult( Collection<Collection<String>> result ) {
        assertEquals( asList(
                asList( "A", "E", "I", "O", "U" ),
                asList( "B", "C", "D", "F", "G" ) ), result );
    }

}
