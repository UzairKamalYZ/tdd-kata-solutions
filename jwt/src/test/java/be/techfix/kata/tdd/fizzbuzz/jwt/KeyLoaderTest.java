package be.techfix.kata.tdd.fizzbuzz.jwt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KeyLoaderTest {

    private KeyLoader keyLoader;

    @BeforeEach
    void setup() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        keyLoader = KeyLoader.forKeystore("pkcs12", "/jwt.p12", "password");
    }

    @ParameterizedTest
    @MethodSource("existingKeys")
    void keyStoreContainsPrivateKeyFor(String alias, String password) throws NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException, KeyStoreException, IOException {
        assertNotNull(keyLoader.getPrivateKey(alias, password));
    }

    @ParameterizedTest
    @MethodSource("nonExistingKeys")
    void keyStoreDoesNotContainPrivateKeyFor(String alias, String password) {
        Exception thrown = assertThrows(NullPointerException.class, () -> keyLoader.getPrivateKey(alias, password));
        Assertions.assertEquals(String.format("key '%s' not found", alias), thrown.getMessage());
    }

    @ParameterizedTest
    @MethodSource("existingKeys")
    void keyStoreContainsPublicKeyFor(String alias, String password) throws NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException, KeyStoreException, IOException {
        assertNotNull(keyLoader.getPublicKey(alias, password));
    }
    @ParameterizedTest
    @MethodSource("nonExistingKeys")
    void keyStoreDoesNotContainPublicKeyFor(String alias, String password) {
        Exception thrown = assertThrows(NullPointerException.class, () -> keyLoader.getPublicKey(alias, password));
        Assertions.assertEquals(String.format("key '%s' not found", alias), thrown.getMessage());
    }

    private static Stream<Arguments> existingKeys() {
        return Stream.of(
                Arguments.of("private1", "password"),
                Arguments.of("private2", "password")
        );
    }

    private static Stream<Arguments> nonExistingKeys() {
        return Stream.of(
                Arguments.of("private3", "unknown")
        );
    }

}
