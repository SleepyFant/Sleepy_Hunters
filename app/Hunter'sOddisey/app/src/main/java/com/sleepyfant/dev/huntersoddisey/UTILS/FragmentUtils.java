package com.sleepyfant.dev.huntersoddisey.UTILS;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by usuari on 24/10/2015.
 */
public class FragmentUtils {
    public static void replaceFragment(int id, Fragment fragment, FragmentManager frgm) {
        try{
            FragmentTransaction FT = frgm.beginTransaction();
            FT.replace(id, fragment);
            FT.commit();
        }
        catch (Exception e){
            FragmentTransaction FT = frgm.beginTransaction();
            FT.add(id, fragment);
            FT.commit();
        }

    }
}
