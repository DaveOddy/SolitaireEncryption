package tests

import crypto.Crypto
import org.junit.Test

import org.junit.Assert.*
import utility.OutputChunker

class CryptoTest {

    @Test
    fun encryptDecrypt() {
        val toEncrypt = "Work at Square, have more fun!"
        val keyStreamFactory = ConstantKeyStreamFactory("DWJXHYRFDGTMSHPUURXJZYWYH")

        val crypto = Crypto(keyStreamFactory, OutputChunker(5))

        val encrypted = crypto.encrypt(toEncrypt)
        val decrypted = crypto.decrypt(encrypted)

        assertEquals("ALBII SKWYH LRAIL ZHGPO FTKWF", encrypted)
        assertEquals("WORKA TSQUA REHAV EMORE FUNXX", decrypted)
    }


    class ConstantKeyStreamFactory(val keyStream: String) : Crypto.KeyStreamFactory {
        override fun getKeyStream(length: Int): String {
            if (length != keyStream.length) {
                throw IllegalArgumentException("ConstantKeyStreamFactory only accepts length of preset key stream - for testing only.")
            }

            return keyStream
        }
    }
}