package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.Assert.assertTrue;

public class PasswordEncoderTest {

    static final String PASSWORD = "password";

    @Test
    void testLDAP(){
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        System.out.println(ldap.encode(PASSWORD));
        System.out.println(ldap.encode(PASSWORD));
        System.out.println(ldap.encode(PASSWORD));

        String encodedPwd = ldap.encode(PASSWORD);
        assertTrue(ldap.matches(PASSWORD, encodedPwd));
    }

    @Test
    void testNoOp(){
        PasswordEncoder noOp = NoOpPasswordEncoder.getInstance();
        System.out.println(noOp.encode(PASSWORD));
    }

    @Test
    void hashingExample() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

        String salted = PASSWORD + "this is my Salt value";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));

    }

}