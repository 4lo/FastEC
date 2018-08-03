package com.diabin.latte_core.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.diabin.latte_core.app.Latte;

public class DimenUtil {
    public static int getScreemWidth() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreemHeight() {
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
