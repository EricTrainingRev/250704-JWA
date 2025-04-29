package com.revature;

public class EntryPoint {

    private IsEven isEven;

    public EntryPoint(IsEven isEven){
        this.isEven = isEven;
    }

    public String checkIfNumberIsEven(int num){
        if(isEven.calculate(num) == 0){
            return "Even";
        } else {
            return "Odd";
        }
    }

    public int callIsEvenMethodForException(){
        return isEven.forExceptionTesting();
    }

}
