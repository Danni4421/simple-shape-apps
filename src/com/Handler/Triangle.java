package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Triangle extends Shape {
  private double alas;
  private double height;
  private double sisi1;
  private double sisi2;
  private double sisi3;
  private String jenis;

  public Triangle(String name) {
    super(name);
  }

  public void setSegitiga(double alas, double height, double sisi1, double sisi2, double sisi3) {
    this.alas = alas;
    this.height = height;

    if (sisi1 == 0) {
      this.sisi1 = Math.sqrt((sisi2 * sisi2) + (sisi3 * sisi3));
    } else if (sisi2 == 0) {
      this.sisi2 = Math.sqrt((sisi1 * sisi1) + (sisi3 * sisi3));
    } else if (sisi3 == 0) {
      this.sisi3 = Math.sqrt((sisi1 * sisi1) + (sisi2 * sisi2));
    } else {
      this.sisi1 = sisi1;
      this.sisi2 = sisi2;
      this.sisi3 = sisi3;
    }

    if (sisi1 == sisi2 && sisi1 == sisi3 && sisi2 == sisi3) {
      this.jenis = "Segitiga Sama Sisi";
    } else if (sisi1 == sisi2 || sisi2 == sisi3) {
      this.jenis = "Segitiga Sama Kaki";
    } else {
      this.jenis = "Segitiga Sembarang";
    }
  }

  public double getLuas() {
    this.luas = (this.alas * this.height) / 2;
    return this.luas;
  }

  public double getKeliling() {
    this.keliling = this.sisi1 + this.sisi2 + this.sisi3;
    return this.keliling;
  }

  public void getRumusLuas() {
    System.out.println("(Alas * Tinggi) / 2");
  }

  public void getRumusKeliling() {
    System.out.println("(Sisi 1 + Sisi 2 + Sisi 3)");
  }

  static Scanner sc = new Scanner(System.in);

  public void TriangleMethod() {
    boolean program = false;

    do {

      System.out.println("MENU : ");
      System.out.println("1. Luas Segitiga");
      System.out.println("2. Keliling Segitiga");
      System.out.println("3. Ganti nilai Segitiga");
      System.out.println("4. Rumus Luas Segitiga");
      System.out.println("5. Rumus Keliling Segitiga");
      System.out.println("6. Jenis Segitiga");

      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas dari Segitiga adalah : %.2f", getLuas());
          break;
        case 2:
          System.out.printf("Keliling dari Segitiga adalah : %.2f", getKeliling());
          break;
        case 3:
          setInput();
          break;
        case 4:
          getRumusLuas();
          break;
        case 5:
          getRumusKeliling();
          break;
        case 6:
          System.out.println("Jenis Segitiga adalah : " + this.jenis);
          break;
      }

    } while (program);
  }

  public void setInput() {
    boolean input = false;

    do {

      try {

        System.out.println("Masukkan nilai alas : ");
        double setAlas = sc.nextDouble();
        System.out.println("Masukkan nilai tinggi");
        double setTinggi = sc.nextDouble();
        System.out.println("Masukkan nilai sisi 1 : ");
        double setSisi1 = sc.nextDouble();
        System.out.println("Masukkan nilai sisi 2 : ");
        double setSisi2 = sc.nextDouble();
        System.out.println("Masukkan nilai sisi 3 : ");
        double setSisi3 = sc.nextDouble();

        setSegitiga(setAlas, setTinggi, setSisi1, setSisi2, setSisi3);

      } catch (InputMismatchException err) {
        System.out.println("Mohon masukkan input yang benar");
      }

    } while (input);
  }
}
