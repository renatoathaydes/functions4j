package com.athaydes.functions4j.monoid;

import com.athaydes.functions4j.compare.Ordering;

import java.util.Optional;

/**
 * @author Renato
 */
public class OptionalMonoid<T> implements Monoid<Optional<T>> {

    final Monoid<T> valueMonoid;

    public OptionalMonoid( Monoid<T> valueMonoid ) {
        this.valueMonoid = valueMonoid;
    }

    @Override
    public Optional<T> operator( Optional<T> m1, Optional<T> m2 ) {
        if ( !m1.isPresent() )
            return m2;
        if ( !m2.isPresent() )
            return m1;
        return Optional.of( valueMonoid.operator( m1.get(), m2.get() ) );
    }

    @Override
    public Optional<T> identity() {
        return Optional.empty();
    }

    public static OptionalMonoid<String> withString() {
        return new OptionalMonoid<>( new StringMonoid() );
    }

    public static OptionalMonoid<Ordering> withOrdering() {
        return new OptionalMonoid<>( new OrderingMonoid() );
    }

}
