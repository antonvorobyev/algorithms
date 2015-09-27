package co.vorobyev.algorithms.gcd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import static co.vorobyev.algorithms.gcd.EuclidianGcd.gcd;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Random;

public class EuclidianGcdTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void gcdShouldBeEqualToProductWhenQuotientIsZero() {
        int p = anyNatural();

        int gcd = gcd(p, 0);

        assertThat(gcd, equalTo(p));
    }

    @Test
    public void gcdShouldBeEqualToLastNonZeroReminder() throws Exception {
        // NOTE: r1*q1*q0 + r1 < Integer.MAX_VALUE
        int r1 = anyNaturalLessThan(100);
        int q1 = anyNaturalLessThan(100);
        int q0 = anyNaturalLessThan(100);

        int q = r1 * q1;
        int p = q*q0 + r1;


        int gcd = gcd(p, q);

        assertThat(gcd, equalTo(r1));
    }

    @Test
    public void gcdShouldBeEqualToQuotientWhenProductIsZero() throws Exception {
        int q = anyNatural();

        int gcd = gcd(0, q);

        assertThat(gcd, equalTo(q));
    }

    @Test
    public void gcdShouldThrowWhenProductIsNegative() throws Exception {
        int p = anyNegativeInteger();
        int q = anyNatural();

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("p must be nonnegative: " + p);

        gcd(p, q);
    }

    @Test
    public void gcdShouldThrowWhenQuotienIsNegative() throws Exception {
        int p = anyNatural();
        int q = anyNegativeInteger();

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("q must be nonnegative: " + q);

        gcd(p, q);
    }

    private static Random random = new Random();

    private int anyNaturalLessThan(int bound) {
        return random.nextInt(bound);
    }

    public static int anyNatural() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    public static int anyNegativeInteger() {
        return -anyNatural() - 1;
    }

}
