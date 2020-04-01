package Helper;

import java.io.File;

public class Resource {
    public static final String RESOURCE_LOCATION = "res/layout";
    public static File getResourceFileStream(String name) {
        return new File(RESOURCE_LOCATION + "/" + name + ".xml");
    }
}
