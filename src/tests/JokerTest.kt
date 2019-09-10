package tests

import cards.Joker
import org.junit.Assert.*
import org.junit.Test

class JokerTest {

    @Test
    fun toStringTest() {
        assertEquals("JA", Joker(Joker.AorB.A).toString())
        assertEquals("JB", Joker(Joker.AorB.B).toString())
    }
}