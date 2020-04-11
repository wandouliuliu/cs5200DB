package com.example.cs5200sp20liuserverjava.daos;
import com.example.cs5200sp20liuserverjava.models.Developer;

import java.util.Collection;

public interface DeveloperImpl {
        //inserts properties in developer instance parameter in tables Developer and Person
        void createDeveloper(Developer developer);
        Collection<Developer> findAllDevelopers();
        Developer findDeveloperById(int developerId);
        Developer findDeveloperByUsername(String username);
        Developer findDeveloperByCredentials(String username, String password);
        int updateDeveloper(int developerId, Developer developer);
        int deleteDeveloper(int developerId);
    }

