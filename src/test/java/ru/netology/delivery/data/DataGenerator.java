package ru.netology.delivery.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate today = LocalDate.now();
        return today.plusDays(shift).format(formatter);
    }

    public static String generateCity() {
        String[] towns = {"Волгоград", "Казань", "Сыктывкар", "Ростов-на-Дону", "Биробиджан"};
        int randomCity = new Random().nextInt(5);
        return towns[randomCity];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber().replaceAll("[()-]", "");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo();
            user.city = generateCity();
            user.name = generateName(locale);
            user.phone = generatePhone(locale);
            return user;
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class UserInfo {
        private String city;
        private String name;
        private String phone;

    }
}




