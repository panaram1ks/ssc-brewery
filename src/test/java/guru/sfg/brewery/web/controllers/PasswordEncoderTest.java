package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

public class PasswordEncoderTest {

    static final String PASSWORD = "password";

    @Test
    void hashingExample() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));

        String salted = PASSWORD + "this is my Salt value";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));

    }

}
