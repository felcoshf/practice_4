package com.example.flc.service;

import com.example.flc.model.User;
import com.example.flc.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public static Scanner scanner;

    @PostConstruct
    public void start() {
        save();
        show_user();
        delete();
        show_user();
        edit();
        show_user();
        findByEmail();
        existence();
        findAllByName();
    }

    public void save() {
        User user1 = new User("kostya@gmail.com", "Kostya");
        User user2 = new User("misha@gmail.com", "Misha");
        User user3 = new User("alena@gmail.com", "Alena");
        User user4 = new User("pasha@gmail.com", "Pasha");
        User user5 = new User("pavel@gmail.com", "Pasha");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
    }

    public void delete() {
        System.out.println("Удаление пользователя");
        System.out.println("Введите id пользователя:");
        Long id = (Long) 1L;
        userRepository.deleteById(id);
    }

    public void show_user() {
        userRepository.findAll().forEach(System.out::println);
    }

    public void edit() {
        Optional<User> users = userRepository.findById(Long.valueOf(2L));
        users.get().setName("Marta");
        userRepository.save(users.get());
    }

    public void findByEmail() {
        System.out.println(userRepository.findByEmail("alena@gmail.com"));
    }

    public void existence() {
        if (userRepository.existsByName("Pasha")) {
            System.out.println("Пользователь с таким именем есть");
        } else {
            System.out.println("Пользователя с таким именем нет");
        }
    }

    public void findAllByName() {
        userRepository.findAllByName("Pasha").forEach(System.out::println);
    }
}
