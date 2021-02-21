package ru.dmitryzaytsev.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//        Посчитать сколько раз встречается каждое слово.
        String[] words = {
                "мыло", "камень", "книга", "скрипка", "очки",
                "бумага", "картошка", "микрофон", "сало", "джава",
                "микрофон", "сало", "лампа", "планшет", "карандаш",
                "карандаш", "очки", "бумага", "сало", "камень"
        };
        String[] uniqueWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isNotRepeatedWord = true;
            if (i == 0) {
                uniqueWords[0] = word;
            } else {
                int j = i;
                while (j >= 0) {
                    if (uniqueWords[j] != null) {
                        if (uniqueWords[j].equals(word)) {
                            isNotRepeatedWord = false;
                            break;
                        }
                    }
                    j--;
                }
                if (isNotRepeatedWord) {
                    uniqueWords[i] = word;
                }
            }
        }
        for (String uniqueWord : uniqueWords) {
            if (uniqueWord != null) {
                int count = 0;
                for (String word : words) {
                    if (uniqueWord.equals(word)) count++;
                }
                System.out.printf("'%s', встречаемое количество раз: %d%n", uniqueWord, count);
            }
        }
        System.out.println("====================================");

        // Второй вариант первого задания
        HashSet<String> hs = new HashSet<>();
        for (String word : words) {
            hs.add(word);
        }
        System.out.println(hs);
        for (String h : hs) {
            int count = 0;
            for (String word : words) {
                if (h.equals(word)) count++;
            }
            System.out.printf("'%s', встречаемое количество раз: %d%n", h, count);
        }
        System.out.println("====================================");

        //2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        // В этот телефонный справочник с помощью метода add() можно добавлять записи.
        // С помощью метода get() искать номер телефона по фамилии.
        // Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        // тогда при запросе такой фамилии должны выводиться все телефоны.
        PhoneBook pb = new PhoneBook();
        pb.add("Левин", "+7-499-999-99-99");
        pb.add("Левин", "+7-499-777-77-77");
        pb.add("Романенко", "+7-499-888-88-88");
        pb.get("Левин");
        pb.get("Лобанов");
    }
}

class PhoneBook {
    private HashMap<String, ArrayList<String>> hm;

    public PhoneBook() {
        hm = new HashMap();
    }

    public void add(String name, String phone) {
        if (hm.containsKey(name)) {
            hm.get(name).add(phone);
        } else {
            ArrayList<String> al = new ArrayList<>();
            al.add(phone);
            hm.put(name, al);
        }
    }

    public void get(String name) {
        if (hm.containsKey(name)) {
            System.out.println(hm.get(name));
        } else {
            System.out.println("Нэт такого!");
        }
    }
}
