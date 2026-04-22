package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {
    Properties get;
    public String getKeyValue(String key) throws IOException, IOException {
        FileInputStream fileAdd=new FileInputStream("./Property.properties");
        get=new Properties();
        get.load(fileAdd);
        return get.getProperty(key);
    }
}
