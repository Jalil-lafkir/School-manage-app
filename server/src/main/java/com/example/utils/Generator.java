package com.example.utils;

import java.util.Random;
import java.util.UUID;

public class Generator {


    public static String generatId(){

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id;
    }

    public static String generateStudentId() {
        Integer randInt = (int) (Math.random() * 4800);
        String id = "S00" + randInt.toString();
        return id;
    }

    public static String generateProfessorId() {
        Integer randInt = (int) (Math.random() * 160);
        String id = "P00" + randInt.toString();
        return id;
    }
    
    public static String generateModuleId() {
        Integer randInt = (int) (Math.random() * 150);
        String id = "M00" + randInt.toString();
        return id;
    }

    public static String generateSessionId() {
        Integer randInt = (int) (Math.random() * 2000);
        String id = "S00" + randInt.toString();
        return id;
    }

    public static String generateRoomId() {
        Integer randInt = (int) (Math.random() * 500);
        String id = "R00" + randInt.toString();
        return id;
    }

    public static Float generateRandomSessionPrice(){
        Random random = new Random();
        return 2550 + random.nextFloat() * (9000 - 2550);
    }
    public static Float generateRandomBonus() {
        Random random = new Random();
        return 13000 + random.nextFloat() * (50000 - 13000);
    }
    
}
