package com.athaydes.functions4j.monoid;

import com.athaydes.functions4j.monoid.Monoid;

/**
 * @author Renato
 */
public class AllMonoid implements Monoid<Boolean> {

    @Override
    public Boolean operator( Boolean m1, Boolean m2 ) {
        return m1 && m2;
    }

    @Override
    public Boolean identity() {
        return true;
    }

}
