/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enkapsulasi;

public class no1 {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("Affan", 90);
            System.out.println("Nama Mahasiswa: " + s1.getName());
            System.out.println("Nilai Awal: " + s1.getScore());

            s1.setScore(75);
            System.out.println("Nilai baru: " + s1.getScore());

            s1.setScore(150); 
            System.out.println("Nilai akhir: " + s1.getScore());
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        setScore(score);
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

    public void setScore(int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Nilai harus antara 0 sampai 100!");
        }
        this.score = score;
    }
}



