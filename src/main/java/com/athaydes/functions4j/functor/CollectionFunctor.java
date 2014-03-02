package com.athaydes.functions4j.functor;

import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Renato
 */
public class CollectionFunctor<K, R> implements Functor<Collection<K>, K, Collection<R>, R> {

    @Override
    public Collection<R> fmap( Function<K, R> f, Collection<K> item ) {
        return item.stream().map( f ).collect( Collectors.toList() );
    }

}
