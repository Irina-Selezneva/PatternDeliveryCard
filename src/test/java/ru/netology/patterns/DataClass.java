package ru.netology.patterns;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataClass {

    private DataClass() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
    // public static String generateCity(String locale) {
       // var faker = new Faker(new Locale(locale));
        //return faker.address().cityName();
    //}
    public static String generateCity(String locale) {
        var cities = new String[]{"Новосибирск", "Уфа", "Улан-удэ", "Екатеринбург", "Владивосток", "Йошкар-Ола", "Москва", "Санкт-Петербург"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));


        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

