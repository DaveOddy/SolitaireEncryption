package tests

import org.junit.Assert.*
import org.junit.Test
import utility.OutputChunker

class OutputChunkerTest {

    @Test
    fun getChunkedString() {

        val chunker = OutputChunker(5)

        assertEquals("None", chunker.getChunkedString("None"))
        assertEquals("Five!", chunker.getChunkedString("Five!"))
        assertEquals("Chunk sNeed ed", chunker.getChunkedString("ChunksNeeded"))
        assertEquals("Perfe ctAmo untPr ovide dForT ester", chunker.getChunkedString("PerfectAmountProvidedForTester"))
    }
}