package ac.id.polinema.delaundry;

import android.app.Application;
import android.content.SharedPreferences;

public class App extends Application {

    private static SharedPreferences sharedPreferences;

    public static String IS_FIRST_TIME_LAUNCH = "IS_FIRST_TIME_LAUNCH";
    public static String NO_HANDPHONE = "NO_HANDPHONE";

    public static Boolean isLogIn() {
        return sharedPreferences.getBoolean(NO_HANDPHONE, false);
    }

    public static Boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    private static void setSharedPreferences(String key, Object obj) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (obj instanceof Boolean) {
            editor.putBoolean(key, (Boolean) obj).apply();
        } else if (obj instanceof String) {
            editor.putString(key, (String) obj).apply();
        } else if (obj instanceof Integer) {
            editor.putInt(key, (Integer) obj).apply();
        }
    }
}
