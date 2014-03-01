package com.athaydes.functions4j.monoid;

import com.athaydes.functions4j.monoid.Monoid;

/**
 * @author Renato
 */
public class StringMonoid implements Monoid<String> {

    @Override
    public String operator( String m1, String m2 ) {
        return m1 + m2;
    }

    @Override
    public String identity() {
        return "";
    }

}
