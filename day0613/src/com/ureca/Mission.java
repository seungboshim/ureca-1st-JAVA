package com.ureca;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Person implements Comparable<Person> {
    public String name;
    public int age;
    public String job;
    public int score;

    public Person(String name, int age, String job, int score) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.score = score;
    }

    @Override
    public int compareTo(Person o) { // 이름 기준 정렬로 오버라이딩
        int compareResult = this.name.compareTo(o.name);
        if (compareResult < 0) {
            return -1;
        } else if (compareResult > 0) {
            return 1;
        } else return 0;
    }
}

public class Mission {
    static int[] su = {13, 8, 7, 10, 100, 5};
    static char[] ch = {'J', 'a', 'v', 'A'};
    static String[] names = {"홍길동", "길라임", "김주원"};

    static void sortSu() { // bubble sort
        for (int i = 0; i < su.length; i++) {
            for (int j = i + 1; j < su.length; j++) {
                if (su[i] > su[j]) {
                    int temp = su[i];
                    su[i] = su[j];
                    su[j] = temp;
                }
            }
        }
    }

    static void sortCh() { // 메소드 사용
        Arrays.sort(ch);
    }

    static void sortNames() {
        Arrays.sort(names);
    }

    static Person p = new Person("갓길동", 11, "학생", 95);
    static Person[] persons = {p,
            new Person("빛길동", 19, "학생", 80),
            new Person("남길동", 14, "학생", 100),
            new Person("여길동", 17, "학생", 99),
            new Person("킹길동", 15, "학생", 56),
    };

    static void sortPersons() {
        Arrays.sort(persons);
    }

    public static void main(String[] args) {
        System.out.println("<미션 1>");
        sortSu();
        for (int j : su) {
            System.out.print(j + " ");
        }

        System.out.println("\n" + "<미션 2>");
        sortCh();
        sortNames();
        for (char j : ch) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (String s : names) {
            System.out.print(s + " ");
        }

        System.out.println("\n" + "<미션 3>");
        sortPersons();
        for (Person p : persons) {
            System.out.println("[" + p.name + "," + p.age + "," + p.job + "," + p.score + "]");
        }
    }
}
