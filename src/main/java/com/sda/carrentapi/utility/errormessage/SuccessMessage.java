package com.sda.carrentapi.utility.errormessage;

public class SuccessMessage {

    public static String rentSuccessful(long id) {
        return "Car id:" + id + " rented succesfully!";
    }

    public static String returnSuccessful(long id) {
        return "Car id:" + id + " returned succesfully!";
    }
}
