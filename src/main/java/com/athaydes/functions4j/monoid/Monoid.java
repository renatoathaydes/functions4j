package com.athaydes.functions4j.monoid;

import java.util.stream.Stream;

/**
 * @author Renato
 */
public interface Monoid<M> {

    public M operator( M m1, M m2 );

    public M identity();

    default M applyOn( Stream<M> ms ) {
        return ms.reduce( identity(), this::operator );
    }

}
