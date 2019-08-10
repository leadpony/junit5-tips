package org.example.junit5.tips;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class BigIntegerTest {

    enum GcdTestCase {
        THIS_IS_BIGGER(25, 10, 5),
        OTHER_IS_BIGGER(14, 21, 7),
        BOTH_ARE_EVEN(12, 8, 4),
        BOTH_ARE_ODD(27, 45, 9),
        BOTH_ARE_ZERO(0, 0, 0),
        BOTH_ARE_ONE(1, 1, 1),
        THIS_IS_ZERO(0, 3, 3),
        OTHER_IS_ZERO(4, 0, 4),
        THIS_IS_DIVISOR(3, 12, 3),
        OTHER_IS_DIVISOR(20, 4, 4),
        NO_COMMON_DIVISOR(7, 9, 1);

        final BigInteger a;
        final BigInteger b;
        final BigInteger expected;

        GcdTestCase(long a, long b, long expected) {
            this.a = BigInteger.valueOf(a);
            this.b = BigInteger.valueOf(b);
            this.expected = BigInteger.valueOf(expected);
        }
    }


    @ParameterizedTest
    @EnumSource(GcdTestCase.class)
    public void gcdShouldReturnGreatestCommonDivisorAsExpected(GcdTestCase test) {
        BigInteger actual = test.a.gcd(test.b);
        assertThat(actual).isEqualTo(test.expected);
    }
}
