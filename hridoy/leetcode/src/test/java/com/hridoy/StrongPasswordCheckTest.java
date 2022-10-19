package com.hridoy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrongPasswordCheckTest {


    @Test
    void test() {

        String password = "aA!A!A!1";

        StrongPasswordCheck obj = new StrongPasswordCheck();
        System.out.println(obj.strongPasswordCheckerII(password));

    }
    @Test
    void  test2(){
        String password = "aA!A!A!";

        StrongPasswordCheck obj = new StrongPasswordCheck();
        System.out.println(obj.strongPasswordCheckerII(password));

    }
}