package com.framework.system;


import java.io.Serializable;


public class BigClass {
    private int private_int;
    public String public_string;
    protected char protected_char;

    private boolean aBoolean;
    private byte aByte;
    private long aLong;
    private double aDouble;



    public BigClass(String param_1, int param_2, char param_3 ){
        public_string = param_1;
        private_int = param_2;
        protected_char = param_3;
    }

}
