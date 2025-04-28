package com.revature;

import java.io.File;

public class TestObject {

    public double calculate(int numerator, int denominator){
        return  numerator / denominator;
    }

    public File getSomeFile(String path){
        return new File(path);
    }

}
