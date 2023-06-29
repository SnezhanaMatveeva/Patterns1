
package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

//@UtilityClass
public class DataGenerator {
    private DataGenerator() {
    }



    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern(("dd.MM.yyyy")));
        return date;
    }

    public static String generateCity(String locale) {
        var cities = new String[]{"Москва", "Санкт-Петербург", "Казань", "Уфа", "Калининград", "Красноярск", "Пермь"};
        return cities[new Random().nextInt(cities.length)];
    }


    public static String generateName(String locale) {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker();
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));

        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;

        public UserInfo(String generateCity, String generateName, String generatePhone) {
        }

        public String getCity() {
            return city;
        }

        public String getName() {
            return name;
        }

        public String getPhone() {
            return phone;
        }
    }
}