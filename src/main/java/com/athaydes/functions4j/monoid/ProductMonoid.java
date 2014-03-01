package com.athaydes.functions4j.monoid;

/**
 * @author Renato
 */
public abstract class ProductMonoid<T extends Number> implements Monoid<T> {

    public static ProductMonoid<Long> multiplyLongsMonoid() {
        return new ProductMonoid<Long>() {
            @Override
            public Long operator( Long m1, Long m2 ) {
                return m1 * m2;
            }

            @Override
            public Long identity() {
                return 1L;
            }
        };
    }

    public static ProductMonoid<Double> multiplyDoublesMonoid() {
        return new ProductMonoid<Double>() {
            @Override
            public Double operator( Double m1, Double m2 ) {
                return m1 * m2;
            }

            @Override
            public Double identity() {
                return 1D;
            }
        };
    }


}
