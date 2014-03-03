package com.athaydes.functions4j.functor;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author Renato
 */
public class OptionalApplicative<K, R>
        extends OptionalFunctor<K, R>
        implements Applicative<Optional<K>, K, Optional<R>, R, Optional<Function<K, R>>> {

    @Override
    public Optional<K> pure( K value ) {
        return Optional.ofNullable( value );
    }

    @Override
    public Optional<R> apply( Optional<Function<K, R>> optionalF, Optional<K> value ) {
        return optionalF.isPresent() ?
                fmap( optionalF.get(), value ) :
                Optional.empty();
    }

}