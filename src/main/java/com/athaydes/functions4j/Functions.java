package com.athaydes.functions4j;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author Renato
 */
public class Functions {

    public static <T> T[] repeat( int times, Class<T> type, T item ) {
        try {
            T[] result = ( T[] ) Array.newInstance( type, times );
            Arrays.fill( result, item );
            return result;
        } catch ( NegativeArraySizeException e ) {
            throw new RuntimeException( e );
        }
    }

    public static <T> T[] generate( int count, Class<T> type, Callable<T> generator ) {
        T[] result = ( T[] ) Array.newInstance( type, count );
        try {
            for ( int i = 0; i < count; i++ ) {
                result[ i ] = generator.call();
            }
            return result;
        } catch ( Exception e ) {
            throw new RuntimeException( e );
        }
    }

}
