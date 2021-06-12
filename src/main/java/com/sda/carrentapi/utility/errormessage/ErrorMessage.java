package com.sda.carrentapi.utility.errormessage;

public class ErrorMessage {

    public static String carNotFound(long id) {
        return "Car id:" + id + " was not found!";
    }

    public static String carAlreadyRented(long id) {
        return "Car id:" + id + " is already rented!";
    }

    public static String carNotRented(long id) {
        return "Car id:" + id + " is not rented!";
    }


}
