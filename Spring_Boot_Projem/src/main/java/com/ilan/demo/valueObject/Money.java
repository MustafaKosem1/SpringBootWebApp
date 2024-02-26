package com.ilan.demo.valueObject;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.Embeddable;

@Embeddable
public class Money {
    private float value;

    @PostConstruct
    public void validateValue(){
        if(value<0){
            throw new IllegalArgumentException("Price cannot be negative.");
        }
    }

    public Money(){
    }

    public Money(float value) {
        this.value = value;
        validateValue();
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                '}';
    }
}
