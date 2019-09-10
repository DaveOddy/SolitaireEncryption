package crypto
import utility.OutputChunker
import kotlin.text.StringBuilder

class Crypto(val keyStreamFactory: KeyStreamFactory, val outputFormatter: OutputFormatter) {

    companion object {

        private val LETTERS_IN_ALPHABET = 26

        private val ASCII_A = 65
        private val ASCII_Z = ASCII_A + LETTERS_IN_ALPHABET - 1 // 90

        private val BLOCK_SIZE = 5
        private val BLOCK_FILLER = "X"
    }

    fun encrypt(plainText: String): String {
        val workingString = prepareText(plainText)
        val stringAsNumbers = convertToNumbers(workingString)
        val keyStream = keyStreamFactory.getKeyStream(stringAsNumbers.size)
        val encryptedNumbers = applyKeyStream(stringAsNumbers, convertToNumbers(keyStream))
        return outputFormatter.getChunkedString(convertToString(encryptedNumbers))
    }

    fun decrypt(encryptedText: String): String {
        val workingString = prepareText(encryptedText)
        val encryptedNumbers = convertToNumbers(workingString)
        val keyStream = keyStreamFactory.getKeyStream(encryptedNumbers.size)
        val plainTextAsNumbers = removeKeyStream(encryptedNumbers, convertToNumbers(keyStream))
        return outputFormatter.getChunkedString(convertToString(plainTextAsNumbers))
    }


    private fun prepareText(plainText: String) : String {
        val stringBuilder = StringBuilder()
        for (char in plainText.toUpperCase().chars()) {
            if (char >= ASCII_A && char <= ASCII_Z)
                stringBuilder.append(Character.toString(char.toChar()))
        }
        while (stringBuilder.length % BLOCK_SIZE != 0) {
            stringBuilder.append(BLOCK_FILLER)
        }
        return stringBuilder.toString()
    }


    private fun convertToNumbers(string: String) : List<Int> {
        val numbers = ArrayList<Int>()
        for (char in string.chars()) {
            numbers.add(char - (ASCII_A - 1))
        }
        return numbers
    }


    private fun convertToString(numbers: List<Int>) : String {
        val stringBuilder = StringBuilder()
        for (number in numbers) {
            stringBuilder.append(Character.toString((number + ASCII_A - 1).toChar()))
        }
        return stringBuilder.toString()
    }


    private fun applyKeyStream(numbers: List<Int>, keyStreamNumbers: List<Int>) : List<Int> {
        val appliedList = ArrayList<Int>()
        for (i in 0..numbers.size - 1) {
            var number = numbers[i] + keyStreamNumbers[i]
            if (number > LETTERS_IN_ALPHABET) {
                number -= LETTERS_IN_ALPHABET
            }
            appliedList.add(number)
        }
        return appliedList
    }


    private fun removeKeyStream(numbers: List<Int>, keyStreamNumbers: List<Int>) : List<Int> {
        val plainList = ArrayList<Int>()
        for (i in 0..numbers.size - 1) {
            var number = numbers[i] - keyStreamNumbers[i]
            if (number < 1) {
                number += LETTERS_IN_ALPHABET
            }
            plainList.add(number)
        }
        return plainList
    }


    interface KeyStreamFactory {
        fun getKeyStream(length: Int) : String
    }

    interface OutputFormatter {
        fun getChunkedString(input: String) : String
    }
}