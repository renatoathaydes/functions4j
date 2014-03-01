package com.athaydes.functions4j.compare;

/**
 * Enumerator that represents the result of comparing two values.
 * <p>
 * LT = Less Than
 * <p>
 * GT = Greater Than
 * <p>
 * EQ = Equal
 *
 * @author Renato
 */
public enum Ordering {

    LT( -1 ), GT( 1 ), EQ( 0 );

    public final int intValue;

    private Ordering( int intValue ) {
        this.intValue = intValue;
    }

    /**
     * Converts the given int value to an Ordering using the convention:
     * <ul>
     * <li>0   - EQ</li>
     * <li>< 0 - LT</li>
     * <li>> 0 - GT</li>
     * </ul>
     *
     * @param intValue
     * @return Ordering from intValue
     */
    public static Ordering asOrdering( int intValue ) {
        return intValue == 0 ?
                EQ :
                intValue > 0 ?
                        GT :
                        LT;
    }

    /**
     * Compares the two given values, returning an Ordering representing the result of the comparison.
     *
     * @param c1  first value
     * @param c2  second value
     * @param <T> type of values being compared
     * @return Ordering resulting from comparing the given values
     */
    public static <T> Ordering asOrdering( Comparable<T> c1, T c2 ) {
        return asOrdering( c1.compareTo( c2 ) );
    }

}
