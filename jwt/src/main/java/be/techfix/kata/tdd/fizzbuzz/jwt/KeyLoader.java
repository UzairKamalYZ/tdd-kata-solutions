package be.techfix.kata.tdd.fizzbuzz.jwt;

import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Objects;

public class KeyLoader {

    private KeyStore keystore;

    private KeyLoader(KeyStore keystore) {
        this.keystore = keystore;
    }

    public static KeyLoader forKeystore(String type, String filename, String password) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException {
        KeyStore keystore = KeyStore.getInstance(type);

        try (InputStream keyStoreStream = KeyLoader.class.getResourceAsStream(filename)) {
            keystore.load(keyStoreStream, password.toCharArray());
        }
        return new KeyLoader(keystore);
    }

    private KeyStore.PrivateKeyEntry getPrivateKeyEntry(String alias, String password) throws NoSuchAlgorithmException, UnrecoverableEntryException, KeyStoreException, IOException, CertificateException {

        KeyStore.ProtectionParameter params = new KeyStore.PasswordProtection(password.toCharArray());
        final KeyStore.PrivateKeyEntry entry = (KeyStore.PrivateKeyEntry) keystore.getEntry(alias, params);
        return Objects.requireNonNull(entry, String.format("key '%s' not found", alias));
    }

    public PublicKey getPublicKey(String alias, String password) throws UnrecoverableEntryException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        return getPrivateKeyEntry(alias, password).getCertificate().getPublicKey();
    }
    public PrivateKey getPrivateKey(String alias, String password) throws UnrecoverableEntryException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        return getPrivateKeyEntry(alias, password).getPrivateKey();
    }

}
