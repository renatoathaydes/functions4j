package com.athaydes.functions4j.functor;

import java.util.function.Function;

/**
 * A Functor can transform an instance of a type T whose parameter is T_, into an instance of the
 * same type but whose parameter is R_ (even though T and R must be the same parametrized type,
 * only with the type parameters possibly different, in Java it is not possible to declare types
 * with different parameters as having the same "root" type).
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
     * Maps the given item of parameterized type T, using the function f, into
     * an instance of T with a possibly different type parameter.
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
