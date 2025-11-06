/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enkapsulasi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class no3 {
    public static void main(String[] args) {
        Student s1 = new Student("Affan", 90);
        Student s2 = new Student("Daffa", 85);
        Student s3 = new Student("Rafi", 78);

        Team team = new Team();
        team.addMember(s1);
        team.addMember(s2);
        team.addMember(s3);

        System.out.println("Daftar anggota tim:");
        for (Student s : team.getMembers()) {
            System.out.println("- " + s.getName() + " (" + s.getScore() + ")");
        }

        List<Student> externalList = team.getMembers();
        externalList.clear(); 

        System.out.println("\nSetelah mencoba mengubah di list eksternal:");
        for (Student s : team.getMembers()) {
            System.out.println("- " + s.getName());
        }
    }
}
class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Nilai awal harus antara 0 sampai 100!");
        }
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Penambahan tidak boleh negatif!");
        }
        if (score + delta > 100) {
            throw new IllegalArgumentException("Nilai tidak boleh lebih dari 100!");
        }
        score += delta;
    }

    public void reduceScore(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Pengurangan tidak boleh negatif!");
        }
        if (score - delta < 0) {
            throw new IllegalArgumentException("Nilai tidak boleh kurang dari 0!");
        }
        score -= delta;
    }
}
class Team {
    private List<Student> members;

    public Team() {
        members = new ArrayList<>();
    }

    public void addMember(Student s) {
        if (s == null) {
            throw new IllegalArgumentException("Member tidak boleh null!");
        }
        members.add(s);
    }

    public List<Student> getMembers() {
        return new ArrayList<>(members);
    }
}
