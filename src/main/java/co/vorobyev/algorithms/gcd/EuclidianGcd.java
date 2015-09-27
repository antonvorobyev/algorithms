package co.vorobyev.algorithms.gcd;

import javax.annotation.Nonnegative;

import static com.google.common.base.Preconditions.checkArgument;


public final class EuclidianGcd {

    private EuclidianGcd() {
        throw new AssertionError();
    }

    public static int gcd(@Nonnegative int p, @Nonnegative int q) {
        checkArgument(p >= 0, "p must be nonnegative: %s", p);
        checkArgument(q >= 0, "q must be nonnegative: %s", q);

        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

}
