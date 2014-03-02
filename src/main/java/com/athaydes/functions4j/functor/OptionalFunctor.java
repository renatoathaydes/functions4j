package com.athaydes.functions4j.functor;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author Renato
 */
public class OptionalFunctor<K, R> implements Functor<Optional<K>, K, Optional<R>, R> {

    @Override
    public Optional<R> fmap( Function<K, R> f, Optional<K> optional ) {
        return optional.isPresent() ?
                Optional.ofNullable( f.apply( optional.get() ) ) :
                Optional.empty();
    }

}
