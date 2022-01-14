package java_core.lesson_4;

/**
 * Java Core. Homework for Lesson 4
 *
 * @author Marina Dumcheva
 * @version 09.01.2022
 */

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneDirectory {

    private HashMap<String, ArrayList<String>> phoneHashMap;

    public PhoneDirectory() {
        this.phoneHashMap = new HashMap<String, ArrayList<String>>();
    }

    public void add(String surname, String phone) {
        if (phoneHashMap.containsKey(surname)) {
            this.getPhoneHashMap().get(surname).add(phone);
        } else {
            ArrayList<String> phoneArrayList = new ArrayList<>();
            phoneArrayList.add(phone);
            phoneHashMap.put(surname, phoneArrayList);
        }
    }

    public ArrayList<String> get(String surname) {
        return phoneHashMap.get(surname);
    }

    public HashMap<String, ArrayList<String>> getPhoneHashMap() {
        return phoneHashMap;
    }

    public void setPhoneHashMap(HashMap<String, ArrayList<String>> phoneHashMap) {
        this.phoneHashMap = phoneHashMap;
    }

    @Override
    public String toString() {
        return "PhoneDirectory: " + phoneHashMap;
    }
}
