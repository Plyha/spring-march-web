package ru.specialist.spring.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class PasswordHasher {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = new Scanner(System.in).nextLine();
        System.out.println(encoder.encode(password));
    }
}
