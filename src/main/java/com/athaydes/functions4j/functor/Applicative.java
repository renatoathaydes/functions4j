package com.athaydes.functions4j.functor;

/**
 * @author Renato
 */
public interface Applicative<T, T_, R, R_, F> extends Functor<T, T_, R, R_> {

    public T pure( T_ value );

    public R apply( F wrappedFunction, T value );

}
