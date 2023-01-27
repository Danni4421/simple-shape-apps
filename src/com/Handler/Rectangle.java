package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rectangle extends Shape {
  private double panjang;
  private double lebar;

  public Rectangle(String name) {
    super(name);
  }

  public void setXnY(double panjang, double lebar) {
    this.panjang = panjang;
    this.lebar = lebar;
  }

  public double getLuas() {
    this.luas = this.panjang * this.lebar;
    return this.luas;
  }

  public double getKeliling() {
    this.keliling = (this.panjang + this.lebar) * 2;
    return this.keliling;
  }

  public void showRumusLuas() {
    System.out.println("Panjang * Lebar");
  }

  public void showRumusKeliling() {
    System.out.println("(Panjang + Lebar) * 2");
  }

  static Scanner sc = new Scanner(System.in);

  public void RectangleMethod() {
    double panjang = 0, lebar = 0;
    boolean program = false, input = false;

    // program start
    do {
      try {
        System.out.print("\nInput Panjang : ");
        panjang = sc.nextDouble();
        System.out.print("Input Lebar : ");
        lebar = sc.nextDouble();
        setXnY(panjang, lebar);
        input = false;
      } catch (InputMismatchException err) {
        System.out.println("Mohon memasukkan tipe angka!");
        input = true;
        sc.nextLine();
      }
    } while (input);

    // menu
    do {
      System.out.println("\n1. Hitung Luas");
      System.out.println("2. Hitung Keliling");
      System.out.println("3. Ganti nilai panjang dan lebar");
      System.out.println("4. Lihat rumus luas");
      System.out.println("5. Lihat rumus keliling");
      System.out.print("Masukkan Perintah : ");
      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas dari persegi panjang adalah : %.2f\n", getLuas());
          break;
        case 2:
          System.out.printf("Keliling dari persegi panjang adalah : %.2f\n", getKeliling());
          break;
        case 3:
          System.out.print("Masukkan nilai panjang : ");
          panjang = sc.nextDouble();
          System.out.print("Masukkan nilai Lebar : ");
          lebar = sc.nextDouble();
          setXnY(panjang, lebar);
          break;
        case 4:
          showRumusLuas();
          System.out.println(this.luas);
          break;
        case 5:
          showRumusKeliling();
          break;
      }

      System.out.print("Anda yakin ingin keluar [y/n] : ");
      char getConfirm = sc.next().charAt(0);
      if (getConfirm == 'n') {
        program = true;
      } else {
        program = false;
      }
    } while (program);
  }
}
