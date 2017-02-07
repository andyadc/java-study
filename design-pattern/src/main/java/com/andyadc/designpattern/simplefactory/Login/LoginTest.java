package com.andyadc.designpattern.simplefactory.Login;

/**
 * @author andaicheng
 * @version 2017/2/7
 */
public class LoginTest {

    public static void main(String[] args) {
        String loginType = "passcode";

        String name = "name";
        String password = "password";

        Login login = LoginManager.factory(loginType);

        login.verify(name, password);
    }
}
