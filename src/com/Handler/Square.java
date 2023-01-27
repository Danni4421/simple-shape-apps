package com.Handler;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Square extends Shape {
  private double sisi;

  public Square(String name) {
    super(name);
  }

  // setter
  public void setSisi(double sisi) {
    this.sisi = sisi;
  }

  public double getLuas() {
    this.luas = sisi * sisi;
    return this.luas;
  }

  public double getKeliling() {
    if (this.sisi == 0) {
      System.out.println("Harap memasukkan nilai sisi");
      return 0;
    } else {
      this.keliling = this.sisi * 4;
    }
    return this.keliling;
  }

  public void getRumusLuas() {
    System.out.println("Sisi * Sisi");
  }

  public void getRumusKeliling() {
    System.out.println("Sisi * 4");
  }

  static Scanner sc = new Scanner(System.in);

  // Square Method
  public void SquareMethod() {
    Square square1 = new Square("Persegi");

    // loop condition
    boolean loopCondition = false, inputCondition = false;

    // show menu
    System.out.println("\nMasukkan Sisi");
    double input = 0;

    do {
      try {
        System.out.print("Masukkan nilai sisi : ");
        input = sc.nextDouble();

        inputCondition = false;

      } catch (InputMismatchException message) {
        System.out.println("Tipe dari data yang Anda masukkan mungkins salah!!\n");
        inputCondition = true;
        sc.nextLine();
      }
    } while (inputCondition);

    square1.setSisi(input);

    if (input != 0) {
      while (!loopCondition) {
        System.out.println("\n1. Hitung Luas");
        System.out.println("2. Hitung Keliling");
        System.out.println("3. Ganti nilai sisi");
        System.out.println("4. Lihat rumus luas");
        System.out.println("5. Lihat rumus keliling");
        System.out.println("6. Keluar");
        System.out.print("Masukkan Perintah : ");
        int getInput = sc.nextInt();

        if (getInput == 1) {
          double resultLuas = square1.getLuas();
          System.out.printf("Hasil dari perhitungan luas Persegi adalah : %.2f\n", resultLuas);
        } else if (getInput == 2) {
          double resultKeliling = square1.getKeliling();
          System.out.printf("Hasil dari perhitungan Keliling Persegi adalah : %.2f\n", resultKeliling);
        } else if (getInput == 3) {
          System.out.print("Masukkan nilai baru sisi : ");
          double inputNewValue = sc.nextDouble();
          square1.setSisi(inputNewValue);
        } else if (getInput == 4) {
          square1.getRumusLuas();
        } else if (getInput == 5) {
          square1.getRumusKeliling();
        } else {
          System.out.print("Anda yakin ingin keluar [y/n] : ");
          char outInput = sc.next().charAt(0);
          if (outInput == 'y') {
            loopCondition = true;
          } else {
            loopCondition = false;
          }
        }
      }
    }
  }
}
