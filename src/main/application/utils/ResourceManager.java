package utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by edik2 on 09.01.2018.
 */
public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private static final String resourceName = "text";

    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(
                resourceName, new Locale("ukr", "UA"));
    }

    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(
                resourceName, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
