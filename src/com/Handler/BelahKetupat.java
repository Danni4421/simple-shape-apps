package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BelahKetupat extends Shape {
  private double diagonal1;
  private double diagonal2;
  private double sisi;

  public BelahKetupat(String name) {
    super(name);
  }

  public void setDiagonal(double diagonal1, double diagonal2) {
    this.diagonal1 = diagonal1;
    this.diagonal2 = diagonal2;

    double jariJari1 = diagonal1 / 2;
    double jariJari2 = diagonal2 / 2;

    this.sisi = Math.sqrt((jariJari1 * jariJari1) + (jariJari2 * jariJari2));
  }

  public double getLuas() {
    this.luas = (this.diagonal1 * this.diagonal2) / 2;
    return this.luas;
  }

  public double getKeliling() {
    this.keliling = this.sisi * 4;
    return this.keliling;
  }

  public void getRumusLuas() {
    System.out.println("(Diagonal 1 * Diagonal 2) / 2");
  }

  public void getRumusKeliling() {
    System.out.println("Sisi * 4");
  }

  static Scanner sc = new Scanner(System.in);

  public void setInput() {
    boolean input = false;

    do {
      try {

        System.out.println("Masukkan Diagonal 1 : ");
        double diagonal1 = sc.nextDouble();
        System.out.println("Masukkan Diagonal 2 : ");
        double diagonal2 = sc.nextDouble();

        setDiagonal(diagonal1, diagonal2);

        input = false;
      } catch (InputMismatchException err) {
        System.out.println("Mohon masukkan input yang benar");

        input = true;
      }
    } while (input);
  }

  public void belahKetupatMethod() {
    boolean program = false;

    do {

      System.out.println("MENU : ");
      System.out.println("1. Luas Belah ketupat");
      System.out.println("2. Keliling Belah ketupat");
      System.out.println("3. Ganti nilai");
      System.out.println("4. Rumus Luas");
      System.out.println("5. Rumus Keliling");

      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas Belah Ketupat adalah : %.2f", getLuas());
          break;
        case 2:
          System.out.printf("Keliling Belah Ketupat adalah : %.2f", getKeliling());
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
      }

      System.out.println("Ingin melihat lagi? ");
      char getInputChar = sc.next().charAt(0);
      if (getInputChar == 'y') {
        program = true;
      } else {
        program = false;
      }

    } while (program);
  }
}
