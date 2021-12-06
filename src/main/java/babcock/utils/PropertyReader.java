package babcock.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    static Properties properties;

    public PropertyReader(){
        loadAllProperties();
    }

    public void loadAllProperties(){
        properties = new Properties();

        try{
            String fileName = System.getProperty("user.dir")+ "/src/main/resources/local_cofig.properties";

            properties.load(new FileInputStream(fileName));
        }
        catch (IOException e) {
            throw new RuntimeException("Not able to find the file");
        }
    }

    public static String readItem(String propertyName){
        return  properties.getProperty((propertyName));
    }
}
