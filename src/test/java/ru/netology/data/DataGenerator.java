package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }
    public static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int numberDays) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate currentDate = LocalDate.now();
        return currentDate.plusDays(numberDays).format(dateFormat);
    }

    public static String generateCity() {
        return faker.address().city();
    }


    public static String generateName() {
        return faker.name().lastName() + " " + faker.name().firstName();

    }

    public static String generatePhone() {

        return faker.numerify("+79#########");
    }



    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser() {
            UserInfo user = new UserInfo(generateCity(), generateName(), generatePhone());
            return user;
        }


    }

    @AllArgsConstructor
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
