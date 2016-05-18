package main.hav.pagenames;

import java.util.ResourceBundle;

public class PageNameManager {

    private static PageNameManager instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "main.hav.pagenames.names";

    private PageNameManager() {
    }

    public static PageNameManager getInstance() {
        if (instance == null) {
            instance = new PageNameManager();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }


}
