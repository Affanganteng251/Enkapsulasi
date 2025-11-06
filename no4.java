/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Enkapsulasi;

public class no4 {
    public static void main(String[] args) {
        ImmutableStudent s1 = new ImmutableStudent("Affan", 85);
        System.out.println("Nama: " + s1.getName());
        System.out.println("Nilai awal: " + s1.getScore());

        ImmutableStudent s2 = s1.withAddedScore(10);
        System.out.println("Nilai setelah ditambah 10: " + s2.getScore());

        System.out.println("Nilai objek lama tetap: " + s1.getScore());

        try {
            ImmutableStudent s3 = s1.withAddedScore(30);
        } catch (IllegalArgumentException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}

final class ImmutableStudent {
    private final String name;
    private final int score;

    public ImmutableStudent(String name, int score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Nilai harus antara 0 sampai 100!");
        }
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public ImmutableStudent withAddedScore(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Penambahan tidak boleh negatif!");
        }
        int newScore = this.score + delta;
        if (newScore > 100) {
            throw new IllegalArgumentException("Nilai tidak boleh lebih dari 100!");
        }
        return new ImmutableStudent(this.name, newScore);
    }
}
