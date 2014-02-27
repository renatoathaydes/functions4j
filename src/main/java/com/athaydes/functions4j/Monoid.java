package com.athaydes.functions4j;

import java.util.Collection;

/**
 * @author Renato
 */
public interface Monoid<M> {

    public M operator( M m1, M m2 );

    public M identity();

    default M append( Collection<M> ms ) {
        return ms.stream().reduce( identity(), this::operator );
    }

}
