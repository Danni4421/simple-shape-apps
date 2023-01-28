package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * InnerTrapezium extends Shape
 */
public class Trapezium extends Shape {
  // Attribute
  private double a;
  private double b;
  private double c;
  private double d;
  private double height;
  private String jenis;

  public Trapezium(String name) {
    super(name);
  }

  public void setTrapesiumValue(
      double alasAtas,
      double alasBawah,
      double tinggi,
      double sisiMiring1,
      double sisiMiring2) {

    // initialization
    this.a = alasAtas;
    this.b = alasBawah;
    this.height = tinggi;
    this.c = sisiMiring1;
    this.d = sisiMiring2;

    double e = Math.sqrt((c * c) - (height * height));
    double f = Math.sqrt((d * d) - (height * height));

    if (e == f) {
      this.jenis = "Sama Kaki";
    } else if ((c == 0 || d == 0)) {
      this.jenis = "Siku Siku";
    } else {
      this.jenis = "Sembarang";
    }
  }

  public double getLuas() {
    // ((a + b) * t ) / 2
    this.luas = ((this.a + this.b) * this.height) / 2;
    return this.luas;
  }

  public double getKeliling() {
    if (this.c == 0 || this.d == 0) {
      this.keliling = (a + b + c + d + height);
    } else {
      this.keliling = (a + b + c + d);
    }

    return this.keliling;
  }

  public String getJenisTrapesium() {
    return this.jenis;
  }

  private void getRumusLuas() {
    System.out.println("1 / 2 (a + b) * t");
  }

  private void getRumusKeliling() {
    System.out.println(" (a + b + c + d) ");
  }

  static Scanner sc = new Scanner(System.in);

  public void setInput() {
    double alasAtas = 0,
        alasBawah = 0,
        sisiMiring1 = 0,
        sisiMiring2 = 0,
        tinggi = 0;

    boolean input = false;

    do {

      try {

        System.out.print("\n\nMasukkan nilai alas atas : ");
        alasAtas = sc.nextDouble();
        System.out.print("Masukkan nilai alas bawah : ");
        alasBawah = sc.nextDouble();
        System.out.print("Masukkan nilai sisi miring kiri : ");
        sisiMiring1 = sc.nextDouble();
        System.out.print("Masukkan nilai sisi miring kanan : ");
        sisiMiring2 = sc.nextDouble();
        System.out.print("Masukkan nilai tinggi : ");
        tinggi = sc.nextDouble();

        setTrapesiumValue(alasAtas, alasBawah, tinggi, sisiMiring1, sisiMiring2);

        input = false;

      } catch (InputMismatchException err) {
        System.out.println("Mohon masukkan input yang sesuai");

        input = true;
      }

    } while (input);
  }

  public void TrapeziumMethod() {
    // condition
    boolean program = false;

    setInput();

    // program
    do {

      System.out.println("\nMENU : ");
      System.out.println("1. Luas Trapesium");
      System.out.println("2. Keliling Trapesium");
      System.out.println("3. Ganti Nilai");
      System.out.println("4. Lihat Rumus Luas");
      System.out.println("5. Lihat Rumus Keliling");
      System.out.println("6. Jenis Trapesium");

      int getInput = sc.nextInt();

      switch (getInput) {
        case 1:
          System.out.printf("Luas Trapesium adalah : %.2f\n", getLuas());
          break;
        case 2:
          System.out.printf("Luas Trapesium adalah : %.2f\n", getKeliling());
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
          System.out.println(this.jenis);
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