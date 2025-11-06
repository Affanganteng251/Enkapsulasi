/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enkapsulasi;

public class no2 {
    public static void main(String[] args) {
        try {
            Student s1 = new Student("Affan", 90);
            System.out.println("Nama: " + s1.getName());
            System.out.println("Nilai awal: " + s1.getScore());

            s1.addScore(5);
            System.out.println("Setelah ditambah 5: " + s1.getScore());

            s1.reduceScore(20);
            System.out.println("Setelah dikurangi 20: " + s1.getScore());

            s1.addScore(30); 
            System.out.println("Setelah ditambahkan lagi: " + s1.getScore());
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
