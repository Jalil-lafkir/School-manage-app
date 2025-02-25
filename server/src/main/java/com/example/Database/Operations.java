package com.example.Database;

import java.util.ArrayList;


public class Operations {

    public static <Type> Boolean Insert(ArrayList<Type> dataArrayList, Type object) {
        dataArrayList.add(object);
        return true;
    }

    public static ArrayList<Object> SelectAll(ArrayList<Object> objects) {
        return objects;
    }

    public static <Type> Type SelectOne(ArrayList<Type> objects, String token) {
        for (Type dbobject : objects) {
            try {
                String id = (String) dbobject.getClass().getMethod("getId").invoke(dbobject);
                String name = (String) dbobject.getClass().getMethod("getName").invoke(dbobject);
                String email = "";
                try {
                     email = (String) dbobject.getClass().getMethod("getEmail").invoke(dbobject);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                
                if (id.equalsIgnoreCase(token) || name.equalsIgnoreCase(token) || email.equalsIgnoreCase(token)) {
                    return dbobject;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null; 
    }

    public static <Type> Boolean Update(ArrayList<Type> objects, Type object) {
        for (Type dbobject : objects) {
            try {

                String dbobjectId = (String) dbobject.getClass().getMethod("getId").invoke(dbobject);
                String objectId = (String) object.getClass().getMethod("getId").invoke(object);

                if (dbobjectId.equalsIgnoreCase(objectId)) {
                    objects.remove(dbobject);
                    objects.add(object);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static <Type> Boolean Delete(ArrayList<Type> objects, Type object) {
        for (Type dbobject : objects) {
            try {
                String dbobjectId = (String) dbobject.getClass().getMethod("getId").invoke(dbobject);
                String objectId = (String) object.getClass().getMethod("getId").invoke(object);

                if (dbobjectId.equalsIgnoreCase(objectId)) {
                    objects.remove(dbobject);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }





    /*
     * public static Identifiable SelectOne(ArrayList<Object> objects, String token)
     * {
     * for (Object obj : objects) {
     * if (obj instanceof Identifiable) {
     * Identifiable item = (Identifiable) obj;
     * if (item.getId().equalsIgnoreCase(token) ||
     * item.getName().equalsIgnoreCase(token)) {
     * return item;
     * }
     * }
     * }
     * return null; // Not found
     * }
     */




}
