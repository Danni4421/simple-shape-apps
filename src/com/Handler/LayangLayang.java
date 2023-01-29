package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LayangLayang extends BelahKetupat {

  private double diagonal1;
  private double diagonal2;
  private double sisi1;
  private double sisi2;

  public LayangLayang(String name) {
    super(name);
  }

  public void setDiagonal(double diagonal1, double diagonal2, double sisi1, double sisi2) {
    this.diagonal1 = diagonal1;
    this.diagonal2 = diagonal2;
    this.sisi1 = sisi1;
    this.sisi2 = sisi2;
  }

  @Override
  public double getLuas() {
    this.luas = (diagonal1 * diagonal2) / 2;
    return this.luas;
  }

  public double getKeliling() {
    if (sisi1 == 0 && sisi2 != 0) {
      double sisi1Result = Math.sqrt((Math.pow(diagonal1, 2)) - Math.pow(sisi2, 2));
      this.sisi1 = sisi1Result;
    }

    this.keliling = (this.sisi1 + this.sisi2) * 2;

    return this.keliling;
  }

  public void getRumusLuas() {
    System.out.println("(diagonal 1 * diagonal 2) / 2");
  }

  public void getRumusKeliling() {
    System.out.println("(Sisi 1 + Sisi 2) * 2");
  }

  static Scanner sc = new Scanner(System.in);

  public void setInput() {
    boolean input = false;

    do {

      try {

        System.out.println("Masukkan diagonal 1 : ");
        double diagonal1 = sc.nextDouble();
        System.out.println("Masukkan diagonal 2 : ");
        double diagonal2 = sc.nextDouble();
        System.out.println("Masukkan nilai sisi 1 : ");
        double sisi1 = sc.nextDouble();
        System.out.println("Masukkan nilai sisi 2 : ");
        double sisi2 = sc.nextDouble();

        input = false;

        setDiagonal(diagonal1, diagonal2, sisi1, sisi2);

      } catch (InputMismatchException err) {
        System.out.println("Mohon masukkan input yang sesuai");

        input = true;

      }

    } while (input);
  }

  public void LayangLayangMethod() {
    boolean program = false;

    do {

      System.out.println("MENU : ");
      System.out.println("1. Luas layang layang");
      System.out.println("2. Keliling layang layang");
      System.out.println("3. Ganti nilai");
      System.out.println("4. Rumus luas");
      System.out.println("5. Rumus keliling");

      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas dari layang layang adalah : %.2f", getLuas());
          break;
        case 2:
          System.out.printf("Keliling dari layang layang adalah : %.2f", getKeliling());
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
