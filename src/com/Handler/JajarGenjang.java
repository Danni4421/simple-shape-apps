package com.Handler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JajarGenjang extends Shape {
  private double alas;
  private double tinggi;
  private double sisiMiring;

  public JajarGenjang(String name) {
    super(name);
  }

  public void setJajarGenjang(double alas, double tinggi, double sisiMiring) {
    this.alas = alas;
    this.tinggi = tinggi;
    this.sisiMiring = sisiMiring;

    double selisihAlas = 0;
    if (sisiMiring == 0) {
      this.sisiMiring = Math.sqrt((Math.pow(alas - tinggi, 2)) + (Math.pow(tinggi, 2)));
      selisihAlas = alas - tinggi;
    } else {
      this.sisiMiring = sisiMiring;
    }

    if (tinggi == 0) {
      this.tinggi = Math.sqrt((Math.pow(selisihAlas, 2)) + (Math.pow(this.sisiMiring, 2)));
    } else {
      this.tinggi = tinggi;
    }
  }

  public double getLuas() {
    this.luas = this.alas * this.tinggi;
    return this.luas;
  }

  public double getKeliling() {
    this.keliling = (this.alas * 2) + (this.sisiMiring * 2);
    return this.keliling;
  }

  public void getRumusLuas() {
    System.out.println("(Alas * Tinggi)");
  }

  public void getRumusKeliling() {
    System.out.println("(Sisi Miring + Alas) * 2");
  } 

  static Scanner sc = new Scanner(System.in);

  public void setInput() {
    // boolean
    boolean input = false;

    // program
    do {
      try {

        System.out.print("Masukkan Nilai Alas : ");
        double alas = sc.nextDouble();
        System.out.print("Masukkan Tinggi : ");
        double tinggi = sc.nextDouble();
        System.out.print("Masukkan Sisi Miring : ");
        double sisiMiring = sc.nextDouble();

        setJajarGenjang(alas, tinggi, sisiMiring);

        input = false;

      } catch (InputMismatchException err) {
        System.out.println("Mohon masukkan input yang sesuai");

        input = true;
      }

    } while (input);
  }

  public void JajarGenjangMethod() {
    boolean program = false;

    do {

      System.out.println("MENU : ");
      System.out.println("1. Luas Jajar genjang");
      System.out.println("2. Keliling Jajar genjang");
      System.out.println("3. Ganti nilai Jajar genjang");
      System.out.println("4. Rumus luas Jajar genjang");
      System.out.println("5. Rumus keliling Jajar genjang");

      int getInputValue = sc.nextInt();

      switch (getInputValue) {
        case 1:
          System.out.printf("Luas dari Jajar genjang adalah %.2f", getLuas());
          break;
        case 2:
          System.out.printf("Keliling dari Jajar gennjang adalah %.2f", getKeliling());
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
      char getInput = sc.next().charAt(0);
      if (getInput == 'y') {
        program = true;
      } else {
        program = false;
      }

    } while (program);
  }
}
