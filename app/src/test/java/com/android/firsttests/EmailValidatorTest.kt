package com.android.firsttests

import org.junit.Assert
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(null))
    }

    /**
     * ДЗ:
     * 1.   Добавьте в приложение MyFirstTests несколько тестов в качестве негативного тестирования.
     * Например, убедитесь, что почта без указания домейна не будет пропущена программой.
     * Какие еще негативные тесты вы можете написать?
     *
     *      Сомнительный тест и сомнительный результат конечно. И регулярка совсем не совершенная :)
     * Ведь на самом деле почти везде у почтовых царей проверяется длина имени, как минимум от 3-5
     * символов должно быть. Плюс в регулярке после точки может ничего не стоять, т.к. длина от
     * 0 стоит, а почта вроде не может заканчиваться на точку.
     *      Можно наверное в регулярку вместо {1,256} сделать хотя бы {3,256}, а вместо {0,25}
     * хотя бы {2,25}
     * Но в данном случае результат True
     */

    @Test
    fun emailValidator_OnlyUnderlineBeforeDogSymbol_ReturnsTrue() {
        Assert.assertTrue(EmailValidator.isValidEmail("_@mail.ru"))
    }

    @Test
    fun emailValidator_SomeDogSymbol_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name@@mail.ru"))
    }

    @Test
    fun emailValidator_OnlyTopLevelDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail(".ru"))
    }

    @Test
    fun emailValidator_OnlyDogSymbolWithDomain_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("@mail"))
    }

    @Test
    fun emailValidator_OnlyName_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name"))
    }

    @Test
    fun emailValidator_UnusedSymbols_ReturnsFalse() {
        Assert.assertFalse(EmailValidator.isValidEmail("name/mail.ru"))
    }
}