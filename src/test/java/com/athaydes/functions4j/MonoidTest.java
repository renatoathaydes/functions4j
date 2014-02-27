package com.athaydes.functions4j;

import com.google.code.tempusfugit.concurrency.RepeatingRule;
import com.google.code.tempusfugit.concurrency.annotations.Repeating;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Renato
 */
public abstract class MonoidTest<M> {

    @Rule
    public RepeatingRule rule = new RepeatingRule();


    protected abstract Monoid<M> monoid();

    protected abstract M randomSample();

    private static int testCount = 0;

    @Test
    @Repeating( repetition = 1_000 )
    public void identityLaw() {
        testCount++;
        M sample = randomSample();
        assertThat( monoid().operator( sample, monoid().identity() ), is( sample ) );
        assertThat( monoid().operator( monoid().identity(), sample ), is( sample ) );
    }

    @Test
    @Repeating( repetition = 1_000 )
    public void associativeLaw() {
        testCount++;
        M a = randomSample();
        M b = randomSample();
        M c = randomSample();
        assertThat( monoid().operator( monoid().operator( a, b ), c ),
                is( monoid().operator( a, monoid().operator( b, c ) ) ) );
    }

    @AfterClass
    public static void after() {
        System.out.println( "Total test runs: " + testCount );
    }

}
