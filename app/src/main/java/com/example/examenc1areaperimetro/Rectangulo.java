package com.example.examenc1areaperimetro;

public class Rectangulo {

    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public Rectangulo() {
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public float calcularArea(){
        float area;
        area = base*altura;
        return  area;
    }

    public float calcularPerimetro(){
        float perimetro;
        perimetro = base + base + altura + altura;
        return perimetro;
    }


}
