/*
 * Copyright (c) 2012-2016 Arne Schwabe
 * Distributed under the GNU GPL v2 with additional terms. For full terms see the file doc/LICENSE.txt
 */

package de.blinkt.openvpn.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.time.Duration;

/**
 * Created by arne on 08.01.17.
 */

// Until I find a good solution

public class Preferences {

    static SharedPreferences getSharedPreferencesMulti(String name, Context c) {
        return c.getSharedPreferences(name, Context.MODE_MULTI_PROCESS | Context.MODE_PRIVATE);

    }


    public static SharedPreferences getDefaultSharedPreferences(Context c) {
        return c.getSharedPreferences(/*c.getPackageName() + "_preferences"*/ "FlutterSharedPreferences", Context.MODE_MULTI_PROCESS | Context.MODE_PRIVATE);

    }

    public static boolean isTimeLessThan(String time1, String time2) {
        // Split the strings
        String[] time1Parts = time1.split(":");
        String[] time2Parts = time2.split(":");

        // Convert to integers
        int time1Hours = Integer.parseInt(time1Parts[0]);
        int time1Minutes = Integer.parseInt(time1Parts[1]);
        int time1Seconds = Integer.parseInt(time1Parts[2]);

        int time2Hours = Integer.parseInt(time2Parts[0]);
        int time2Minutes = Integer.parseInt(time2Parts[1]);
        int time2Seconds = Integer.parseInt(time2Parts[2]);

        // Compare the time strings
        if (time1Hours < time2Hours) {
            return true;
        } else if (time1Hours == time2Hours && time1Minutes < time2Minutes) {
            return true;
        } else if (time1Hours == time2Hours && time1Minutes == time2Minutes && time1Seconds < time2Seconds) {
            return true;
        } else {
            return false;
        }
    }


//    public static Duration parseDuration(String duration) {
//        String[] parts = duration.split(":");
//        int hours = Integer.parseInt(parts[0]);
//        int minutes = Integer.parseInt(parts[1]);
//        int seconds = Integer.parseInt(parts[2]);
//        return Duration.ofHours(hours).plusMinutes(minutes).plusSeconds(seconds);
//    }
//
//    public static String formatDurationInString(Duration duration) {
//        long hours = duration.toHours();
//        long minutes = duration.toMinutes() % 60;
//        long seconds = duration.getSeconds() % 60;
//        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
//    }


}
