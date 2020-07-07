package com.rohankadkol.favoritedogsappfinal.utils;

import android.content.res.Resources;
import android.text.TextUtils;

import com.rohankadkol.favoritedogsappfinal.R;
import com.rohankadkol.favoritedogsappfinal.pojos.Dog;

public final class StringUtils {
    private StringUtils() {}

    public static String getBreedString(Resources res, String breed) {
        if (TextUtils.isEmpty(breed)) {
            return res.getString(R.string.unknown_breed);
        } else {
            return breed;
        }
    }

    public static String getAgeDisplayString(Resources res, double age) {
        if (age == Dog.EMPTY_AGE) {
            return null;
        }
        String yearsOld = res.getString(R.string.years_old);
        return String.format("%.1f %s", age, yearsOld);
    }

    public static String getAgeFormString(double age) {
        if (age == Dog.EMPTY_AGE) {
            return "";
        }
        return String.valueOf(age);
    }
}
