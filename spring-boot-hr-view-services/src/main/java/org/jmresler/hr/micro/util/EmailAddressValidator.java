package org.jmresler.hr.micro.util;

import java.util.regex.Pattern;

public class EmailAddressValidator {

    private static final String EMAIL_REGEX = "^(([^<>()[\\]\\\\.,;:\\s@\"]+(\\.[^<>()[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";


    public boolean isValid(final String emailAddress) {
        var pattern = Pattern.compile(EMAIL_REGEX);
        return pattern.matcher(emailAddress).matches();
    }
}
