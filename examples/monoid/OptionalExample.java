package monoid;

import com.athaydes.functions4j.monoid.AddMonoid;
import com.athaydes.functions4j.monoid.OptionalMonoid;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class OptionalExample {

    public static class Person {
        final String name;
        final Optional<Integer> age;

        public Person( String name, Integer age ) {
            this.name = name;
            this.age = Optional.ofNullable( age );
        }

        @Override
        public String toString() {
            return "(" + name + "," + age + ")";
        }

    }

    OptionalMonoid<Integer> optionalMonoid = new OptionalMonoid<>( AddMonoid.addIntsMonoid() );

    @Test
    public void usingTheOptionalMonoid() {
        List<Person> people = Arrays.asList(
                new Person( "John", 30 ),
                new Person( "Mary", null ),
                new Person( "Hans", 25 ),
                new Person( "Julia", 20 ),
                new Person( "Julia", null ),
                new Person( "Hans", null ) );

        int sumOfKnownAges = optionalMonoid.applyOn(
                people.stream().map( ( p ) -> p.age ) ).get().intValue();

        assertEquals( sumOfKnownAges, 30 + 25 + 20 );
    }

}
