package com.driver;

public class F1 extends Car {

    //----------------- constructor --------------------
    public F1(String name, boolean isManual) {
        //Use arbitrary values for parameters which are not mentioned
        super(name, isManual);
    }


    //--------------------- other methods -----------------------
    public void accelerate(int rate){
        int newSpeed = super.getCurrentSpeed()+rate; //set the value of new speed by using currentSpeed and rate
        /**
         * speed 0: gear 1
         * speed 1-50: gear 1
         * speed 51-100: gear 2
         * speed 101-150: gear 3
         * speed 151-200: gear 4
         * speed 201-250: gear 5
         * speed more than 250: gear 6
         */
        if(newSpeed<0){
            newSpeed = 0;
        }
        if(newSpeed<=50){
            super.setGears(1);
        }else if(newSpeed<=100){
            super.setGears(2);
        }else if(newSpeed<=150){
            super.setGears(3);
        }else if(newSpeed<=200){
            setGears(4);
        }else if(newSpeed<=250){
            setGears(5);
        }else{
            setGears(6);
        }

        if(newSpeed == 0) {
            //Stop the car, set gear as 1
            super.stop();
            super.setGears(1);
        }
        //for all other cases, change the gear accordingly

        if(newSpeed > 0) {
            super.changeSpeed(newSpeed, super.getCurrentDirection());
        }
    }
}
