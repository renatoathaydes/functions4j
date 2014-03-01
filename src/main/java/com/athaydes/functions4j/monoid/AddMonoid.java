package com.athaydes.functions4j.monoid;

/**
 * @author Renato
 */
public abstract class AddMonoid<T extends Number> implements Monoid<T> {

    public static AddMonoid<Integer> addIntsMonoid() {
        return new AddMonoid<Integer>() {
            @Override
            public Integer operator( Integer m1, Integer m2 ) {
                return m1 + m2;
            }

            @Override
            public Integer identity() {
                return 0;
            }
        };
    }

    public static AddMonoid<Long> addLongsMonoid() {
        return new AddMonoid<Long>() {
            @Override
            public Long operator( Long m1, Long m2 ) {
                return m1 + m2;
            }

            @Override
            public Long identity() {
                return 0L;
            }
        };
    }

    public static AddMonoid<Double> addDoublesMonoid() {
        return new AddMonoid<Double>() {
            @Override
            public Double operator( Double m1, Double m2 ) {
                return m1 + m2;
            }

            @Override
            public Double identity() {
                return 0D;
            }
        };
    }

}
