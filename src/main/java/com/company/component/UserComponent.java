package com.company.component;

import com.company.exp.AppBadRequestException;

public class UserComponent {
    public static void checkPhoneNum(String phoneNum) {

        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        if (!phoneNum.matches(regex)) throw new AppBadRequestException("Phone number is invalid");

    }
}
