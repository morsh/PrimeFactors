package PrimeFactors

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class PrimeFactorsTest {

    @Test fun factors() {
        assertThat(factorOf(1), `is`(emptyList()))
        assertThat(factorOf(2), `is`(listOf(2)))
        assertThat(factorOf(3), `is`(listOf(3)))
        assertThat(factorOf(4), `is`(listOf(2, 2)))
        assertThat(factorOf(5), `is`(listOf(5)))
        assertThat(factorOf(6), `is`(listOf(2, 3)))
        assertThat(factorOf(7), `is`(listOf(7)))
        assertThat(factorOf(8), `is`(listOf(2, 2, 2)))
        assertThat(factorOf(9), `is`(listOf(3, 3)))
        assertThat(factorOf(10), `is`(listOf(2, 5)))

        assertThat(factorOf(19), `is`(listOf(19)))
        assertThat(factorOf(2*2*3*3*5*7*11*11*13), `is`(listOf(2,2,3,3,5,7,11,11,13)))
    }

    private fun factorOf(n: Int): List<Int> {
        var remainder = n
        val factors = mutableListOf<Int>()
        var divisor = 2

        do {
            while (remainder % divisor == 0) {
                factors.add(divisor)
                remainder /= divisor
            }
        } while (++divisor < remainder)

        if (remainder > 1)
            factors.add(remainder)

        return factors
    }
}