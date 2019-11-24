package ru.arvelm.lesson_3;

import android.media.Image;
import android.widget.ImageView;

public class Person {

    String id;
    int image;
    String name;
    String surname;
    String email;
    String login;
    String region;

    Person(String id, int image, String name, String surname, String email, String login, String region){

        this.id = id;
        this.image = image;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.region = region;
    }

}
