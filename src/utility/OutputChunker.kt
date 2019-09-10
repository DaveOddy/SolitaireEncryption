package utility

import crypto.Crypto
import java.lang.StringBuilder

class OutputChunker(val chunkSize: Int) : Crypto.OutputFormatter {

    override fun getChunkedString(input: String) : String {
        val chunks = input.chunked(this.chunkSize)
        val builder = StringBuilder()
        for (chunk in chunks) {
            builder.append(chunk).append(" ")
        }
        return builder.trim().toString()
    }
}