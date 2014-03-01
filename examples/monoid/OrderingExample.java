package monoid;

import com.athaydes.functions4j.monoid.OrderingMonoid;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static com.athaydes.functions4j.compare.Ordering.asOrdering;
import static org.junit.Assert.assertEquals;

/**
 * @author Renato
 */
public class OrderingExample {

    public static class Person {
        final int id;
        final String fname;
        final String lname;
        final int age;

        public Person( int id, String fname, String lname, int age ) {
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.age = age;
        }

        @Override
        public String toString() {
            return "(" + id + "," + fname + "," + lname + "," + age + ")";
        }

    }

    private OrderingMonoid orderingM = new OrderingMonoid();

    List<Person> people = Arrays.asList(
            new Person( 1, "John", "Meyer", 27 ),
            new Person( 2, "Mary", "Jane", 25 ),
            new Person( 3, "Hans", "Hansson", 39 ),
            new Person( 4, "Julia", "Roberts", 41 ),
            new Person( 5, "Julia", "Roberts", 22 ),
            new Person( 6, "Hans", "Schneider", 19 ) );

    @Test
    public void usingTheOrderingMonoidToSortPeopleByEachField() {
        people.sort( ( p1, p2 ) -> orderingM.applyOn( Stream.of(
                asOrdering( p1.fname, p2.fname ),
                asOrdering( p1.lname, p2.lname ),
                asOrdering( p1.age, p2.age )
        ) ).intValue );

        assertEquals( people.toString(),
                "[(3,Hans,Hansson,39), (6,Hans,Schneider,19), (1,John,Meyer,27), (5,Julia,Roberts,22)," +
                        " (4,Julia,Roberts,41), (2,Mary,Jane,25)]" );
    }

    @Test
    public void usingJava7() {
        people.sort( new Comparator<Person>() {
            @Override
            public int compare( Person p1, Person p2 ) {
                int comparison = p1.fname.compareTo( p2.fname );
                if ( comparison == 0 )
                    comparison = p1.lname.compareTo( p2.lname );
                if ( comparison == 0 )
                    comparison = Integer.valueOf( p1.age ).compareTo( p2.age );
                if ( comparison == 0 )
                    comparison = Integer.valueOf( p1.id ).compareTo( p2.id );
                return comparison;
            }
        } );

        assertEquals( people.toString(),
                "[(3,Hans,Hansson,39), (6,Hans,Schneider,19), (1,John,Meyer,27), (5,Julia,Roberts,22)," +
                        " (4,Julia,Roberts,41), (2,Mary,Jane,25)]" );
    }

}
