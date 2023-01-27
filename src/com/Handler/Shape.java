package com.Handler;

public class Shape {
  protected String name;
  protected double luas;
  protected double keliling;

  public Shape(String name) {
    this.name = name;
  }

  public double getLuas() {
    if (this.luas == 0) {
      System.out.println("Anda masih belum memiliki nilai luas");
      return 0;
    }
    return this.luas;
  }

  public double getKeliling() {
    if (this.keliling == 0) {
      System.out.println("Anda masih belum memiliki nilai keliling");
      return 0;
    }
    return this.keliling;
  }

  public String showShape() {
    return this.name;
  }
}
