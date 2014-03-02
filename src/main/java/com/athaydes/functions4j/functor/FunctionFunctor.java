package com.athaydes.functions4j.functor;

import java.util.function.Function;

/**
 * A {@link com.athaydes.functions4j.functor.Functor} specialization for {@code Function}s.
 * @author Renato
 */
public class FunctionFunctor<R, A, B> implements Functor<Function<R, A>, A, Function<R, B>, B> {

    /**
     * Given a function from type A to type B, and a function from type R to type A,
     * {@code fmap} will return a function from type R to type B.
     * <p>
     * This can be visualized simply as:
     * <p>
     * ( (A -> B), (R -> A) ) -> (R -> B)
     *
     * @param f function A -> B
     * @param g function R -> A
     * @return function R -> B
     */
    @Override
    public Function<R, B> fmap( Function<A, B> f, Function<R, A> g ) {
        return f.compose( g );
    }

}
