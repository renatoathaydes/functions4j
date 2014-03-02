package com.athaydes.functions4j.functor;

import java.util.function.Function;

/**
 * A Functor can transform an instance of a type whose parameter is T, into an instance of a
 * type whose parameter is R.
 * <p>
 * For example:
 * <p>
 * Suppose you have a parameterized type, such as a {@code Optional<String>}, and you need to
 * convert an instance of this type into a {@code Optional<Integer>}. This could be achieved
 * with a {@code OptionalFunctor} as follows:
 * <p>
 * {@code Optional<String> stringOptional = ...}
 * <p>
 * {@code Optional<Integer> intOptional = functor.fmap( Integer::parseInt, stringOptional );}
 *
 * @author Renato
 */
public interface Functor<T, T_, R, R_> {

    /**
     * Maps the given item, using the function f, into something with a possibly different type
     *
     * @param f    function
     * @param item to be mapped over
     * @return transformed item
     */
    public R fmap( Function<T_, R_> f, T item );

    /**
     * Partially apply the given function f to this Functor, returning a function which can be
     * used to apply the functor to any item of type T.
     *
     * @param f to partially apply
     * @return partially applied Functor
     */
    public default Function<T, R> partiallyApply( Function<T_, R_> f ) {
        return ( T item ) -> fmap( f, item );
    }

}
