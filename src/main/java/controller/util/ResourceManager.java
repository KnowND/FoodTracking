package controller.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Language manager
 */
public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private static final String resourceName = "text";

    ResourceManager(){
        resourceBundle = ResourceBundle.getBundle(
                resourceName, new Locale("ukr", "UA"));
    }

    /**
     * Change language
     * @param locale
     */
    public void changeResource(Locale locale){
        resourceBundle = ResourceBundle.getBundle(
                resourceName, locale);
    }

    /**
     *
     * @param key
     * @return label from text.properties
     */
    public String getString(String key) {
        return resourceBundle.getString(key);
    }

}
