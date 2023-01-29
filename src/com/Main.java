package com;

import java.util.Scanner;

import com.Handler.*;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    boolean loopProgram = false;
    String shapes[] = {
        "Persegi", "Persegi Panjang", "Lingkaran", "Segitiga", "Trapesium", "Jajar Genjang",
        "Belah Ketupat", "Layang Layang"
    };

    System.out.println("PROGRAM MENGHITUNG BANGUN DATAR");
    System.out.println("=================================||\n");

    do {
      // program start
      for (int i = 0; i < shapes.length; i++) {
        System.out.printf("%d. %s\n", (i + 1), shapes[i]);
      }

      pickedShapes();

      // confirmation
      System.out.print("Ingin check lagi? [y/n] ");
      loopProgram = confirmation();
    } while (loopProgram);

  }

  // picked shapes
  static void pickedShapes() {
    System.out.print("Pilih Bangun Datar : ");
    int getShapes = sc.nextInt();

    switch (getShapes) {
      case 1:
        Square persegi = new Square("Persegi");
        persegi.SquareMethod();
        break;
      case 2:
        Rectangle persegiPanjang = new Rectangle("Persegi Panjang");
        persegiPanjang.RectangleMethod();
        break;
      case 3:
        Circle lingkaran = new Circle("Lingkaran");
        lingkaran.CircleMethod();
        break;
      case 4:
        Triangle segitiga = new Triangle("Segitiga");
        segitiga.TriangleMethod();
        break;
      case 5:
        Trapezium trapesium = new Trapezium("Trapesium");
        trapesium.TrapeziumMethod();
        break;
      case 6:
        JajarGenjang jajargenjang = new JajarGenjang("Jajar Genjang");
        jajargenjang.JajarGenjangMethod();
        break;
      case 7:
        BelahKetupat belahKetupat = new BelahKetupat("Belah Ketupat");
        belahKetupat.belahKetupatMethod();
        break;
      case 8:
        LayangLayang layanglayang = new LayangLayang("Layang Layang");
        layanglayang.LayangLayangMethod();
        break;
      default:
        System.out.println("Tidak Jadi");
        break;
    }
  }

  // confirmation loop program
  static boolean confirmation() {
    boolean resultConfirmation = false;

    char getConfirmationChar = sc.next().charAt(0);

    if (getConfirmationChar == 'y') {
      resultConfirmation = true;
    } else {
      resultConfirmation = false;
    }

    return resultConfirmation;
  }
}
