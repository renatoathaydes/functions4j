package com.athaydes.functions4j.compare;

/**
 * @author Renato
 */
public enum Ordering {

    LT( -1 ), GT( 1 ), EQ( 0 );

    public final int intValue;

    private Ordering( int intValue ) {
        this.intValue = intValue;
    }

    public static Ordering asOrdering( int intValue ) {
        return intValue == 0 ?
                EQ :
                intValue > 0 ?
                        GT :
                        LT;
    }

}
