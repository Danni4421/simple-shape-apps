package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Circle extends Shape {
  private final double PHI = Math.PI;
  private double diameter;
  private double jariJari;

  public Circle(String name) {
    super(name);
  }

  public void setDiameter(double diameter) {
    this.diameter = diameter;
    this.jariJari = diameter / 2;
  }

  public void setJariJari(double jariJari) {
    this.jariJari = jariJari;
    this.diameter = jariJari * 2;
  }

  public double getLuas() {
    this.luas = this.PHI * (this.jariJari * this.jariJari);
    return this.luas;
  }

  public double getKeliling() {
    this.keliling = this.PHI * this.diameter;
    return this.keliling;
  }

  private void getRumusLuas() {
    System.out.println("PHI * Jari Jari * Jari Jari");
  }

  private void getRumusKeliling() {
    System.out.println("2 (PHI * Jari Jari)");
  }

  static Scanner sc = new Scanner(System.in);

  public void CircleMethod() {
    // Condition
    boolean program = false;

    input();

    // Program
    do {

      System.out.println("\n\nMENU : ");
      System.out.println("1. Luas Lingkaran");
      System.out.println("2. Keliling Lingkaran");
      System.out.println("3. Ganti diameter atau jari jari");
      System.out.println("4. Rumus Luas Lingkaran");
      System.out.println("5. Rumus Keliling Lingkaran");

      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas dari lingkaran adalah : %.2f\n", getLuas());
          break;
        case 2:
          System.out.printf("Luas dari lingkaran adalah : %.2f\n", getKeliling());
          break;
        case 3:
          input();
          break;
        case 4:
          getRumusLuas();
          break;
        case 5:
          getRumusKeliling();
          break;
      }

      System.out.println("Ingin melihat lagi? : ");
      char getInputChar = sc.next().charAt(0);
      if (getInputChar == 'y') {
        program = true;
      } else {
        program = false;
      }

    } while (program);

  }

  private void input() {
    // Condition
    boolean input = false;

    // Data
    double diameter = 0, jariJari = 0;

    System.out.println("\n\nPilih Masukkan : ");
    System.out.println("1. Diameter");
    System.out.println("2. Jari Jari");

    // Input
    do {

      System.out.print("Masukkan Input : ");
      int getInput = sc.nextInt();

      try {

        if (getInput == 1) {
          diameter = sc.nextDouble();
          this.setDiameter(diameter);
        } else {
          jariJari = sc.nextDouble();
          this.setJariJari(jariJari);
        }

        input = false;

      } catch (InputMismatchException e) {

        System.out.println("Mohon masukkan input yang benar");
        input = true;

      }

    } while (input);
  }
}
