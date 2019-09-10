package tests

import cards.RandomDeckLoader
import cards.SolitaireKeyStreamFactory
import cards.UnKeyedDeckLoader
import crypto.Crypto
import org.junit.Test

import org.junit.Assert.*
import utility.OutputChunker

class SystemTest {

    @Test
    fun encryptDecrypt() {
        val toEncrypt = "Work at Square, have more fun!"

        val crypto = Crypto(SolitaireKeyStreamFactory(UnKeyedDeckLoader()), OutputChunker(5))

        val encrypted = crypto.encrypt(toEncrypt)
        val decrypted = crypto.decrypt(encrypted)

        assertEquals("ALBII SKWYH LRAIL ZHGPO FTKWF", encrypted)
        assertEquals("WORKA TSQUA REHAV EMORE FUNXX", decrypted)
    }

    @Test
    fun knownDecryptions() {
        val toDecrypt1 = "CLEPK HHNIY CFPWH FDFEH"
        val toDecrypt2 = "ABVAW LWZSY OORYK DUPVH"

        val crypto = Crypto(SolitaireKeyStreamFactory(UnKeyedDeckLoader()), OutputChunker(5))

        assertEquals("YOURC IPHER ISWOR KINGX", crypto.decrypt(toDecrypt1))
        assertEquals("WELCO METOR UBYQU IZXXX", crypto.decrypt(toDecrypt2))
    }

    @Test
    fun encryptDecryptRandomKey() {
        val toEncrypt = "This is a test of encrypting and decrypting using a random key!"

        val crypto = Crypto(SolitaireKeyStreamFactory(RandomDeckLoader()), OutputChunker(5))

        val encrypted = crypto.encrypt(toEncrypt)
        val decrypted = crypto.decrypt(encrypted)

        assertEquals("THISI SATES TOFEN CRYPT INGAN DDECR YPTIN GUSIN GARAN DOMKE YXXXX", decrypted)
    }
}