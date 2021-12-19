package com.fundamentosplatzi.springboot.fundamentos.bean;

public class CubeResultImplement implements CubeResult{

    private NumberCube numberCube;

    public CubeResultImplement(NumberCube numberCube) {
        this.numberCube = numberCube;
    }

    @Override
    public void printCubeResult() {
        int number = 5;
        System.out.println("El cubo del numero " + number + " es: " + numberCube.cube(number) );
    }
}
