package org.juannn.lockit.aplication.core.domain.service;


import org.juannn.lockit.aplication.core.domain.port.in.password.CreatePasswordPort;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PasswordGeneratorService  {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:',.<>?";
    private static final int PASSWORD_LENGTH = 14;

    private final Random random = new SecureRandom();

    public String generate() {
        StringBuilder passwordBuilder = new StringBuilder(PASSWORD_LENGTH);

        passwordBuilder.append(getRandomChar(LOWERCASE));
        passwordBuilder.append(getRandomChar(UPPERCASE));
        passwordBuilder.append(getRandomChar(DIGITS));
        passwordBuilder.append(getRandomChar(SPECIAL_CHARACTERS));

        String allCharacters = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;
        IntStream.range(0, PASSWORD_LENGTH - 4) // Ya hemos añadido 4 caracteres, así que generamos 10 más
                .forEach(i -> passwordBuilder.append(getRandomChar(allCharacters)));

        List<Character> passwordChars = passwordBuilder.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        Collections.shuffle(passwordChars);

        return passwordChars.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private char getRandomChar(String characterSet) {
        int randomIndex = random.nextInt(characterSet.length());
        return characterSet.charAt(randomIndex);
    }
}
