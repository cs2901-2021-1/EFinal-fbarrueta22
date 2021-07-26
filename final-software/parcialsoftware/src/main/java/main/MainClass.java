package main;

import java.util.Scanner;
import java.util.logging.Logger;

public class MainClass {
    public static void main(String[] args) {
        var logger = Logger.getLogger(MainClass.class.getName());
        logger.info("Hola test");
        var platform = Login.getInstance();
        platform.addUser();

        //Login
    }
}
