package com.athaydes.functions4j.monoid;

import com.athaydes.functions4j.monoid.Monoid;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author Renato
 */
public class CollectionMonoid<T> implements Monoid<Collection<T>> {

    @Override
    public Collection<T> operator( Collection<T> s1, Collection<T> s2 ) {
        return Stream.concat( s1.stream(), s2.stream() ).collect( toList() );
    }

    @Override
    public Collection<T> identity() {
        return Collections.emptyList();
    }
}
