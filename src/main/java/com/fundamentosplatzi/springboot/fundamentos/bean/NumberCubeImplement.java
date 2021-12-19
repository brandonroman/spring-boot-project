package com.fundamentosplatzi.springboot.fundamentos.bean;

public class NumberCubeImplement implements NumberCube{
    @Override
    public int cube(int number) {
        int resultado = number * number * number;
        return resultado;
    }
}
