package br.com.brasilprev.TesteBrasilPrev.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by @mriso_dev on 10/08/17.
 */
public class PasswordEncryptor {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final String encryptedPassword;
    private final String rawPassword;

    public PasswordEncryptor(final String password){
        this.encryptedPassword = bCryptPasswordEncoder.encode(password);
        this.rawPassword = password;
    }

    public Boolean returnMatch() {
        return bCryptPasswordEncoder.matches(this.rawPassword, this.encryptedPassword);
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

}
