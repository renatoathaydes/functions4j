package monoid;

import com.athaydes.functions4j.monoid.AddMonoid;
import com.athaydes.functions4j.monoid.OptionalMonoid;
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

    OptionalMonoid<Integer> addOptionalIntsMonoid = new OptionalMonoid<>( AddMonoid.addIntsMonoid() );

    List<Person> people = Arrays.asList(
            new Person( "John", 30 ),
            new Person( "Mary", null ),
            new Person( "Hans", 25 ),
            new Person( "Julia", 20 ),
            new Person( "Julia", null ),
            new Person( "Hans", null ) );

    @Test
    public void usingJava7Style() {
        int sumOfKnownAges = 0;
        for ( Person p : people ) {
            sumOfKnownAges += p.age.isPresent() ? p.age.get() : 0; // isPresent? would have been a null check in Java 7
        }
        assertEquals( sumOfKnownAges, 30 + 25 + 20 );
    }

    @Test
    public void usingPlainJava8() {
        int sumOfKnownAges = people.stream()
                .map( ( p ) -> p.age )
                .map( ( age ) -> age.orElse( 0 ) )
                .reduce( ( age1, age2 ) -> age1 + age2 ).orElse( 0 );

        assertEquals( sumOfKnownAges, 30 + 25 + 20 );
    }

    @Test
    public void usingTheOptionalMonoid() {
        int sumOfKnownAges = addOptionalIntsMonoid.applyOn(
                people.stream().map( ( p ) -> p.age ) ).orElse( 0 );

        assertEquals( sumOfKnownAges, 30 + 25 + 20 );
    }

    @Test
    public void evenWhenAllValuesAreNullTheMonoidWillWork() {
        List<Person> people = Arrays.asList(
                new Person( "John", null ),
                new Person( "Julia", null ),
                new Person( "Hans", null ) );

        int sumOfKnownAges = addOptionalIntsMonoid.applyOn(
                people.stream().map( ( p ) -> p.age ) ).orElse( 0 );

        assertEquals( sumOfKnownAges, 0 );
    }

}
