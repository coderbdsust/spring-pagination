package com.learn.pageang.constant;

public class Enums {

    enum AddressType{

        PRESENT(1), PERMANENT(2), OFFICIAL(3);

        final int value;

        AddressType(int type){
            this.value=type;
        }

        public int getValue(){
            return value;
        }
    }
}
