package com.athaydes.functions4j.compare;

import com.athaydes.functions4j.Monoid;

import static com.athaydes.functions4j.compare.Ordering.*;


/**
 * @author Renato
 */
public class OrderingMonoid implements Monoid<Ordering> {


    @Override
    public Ordering operator( Ordering o1, Ordering o2 ) {
        switch ( o1 ) {
            case LT:
                return LT;
            case EQ:
                return o2;
            default:
                return GT;
        }
    }

    @Override
    public Ordering identity() {
        return EQ;
    }

}
