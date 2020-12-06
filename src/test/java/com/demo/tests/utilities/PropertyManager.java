package com.demo.tests.utilities;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


//This class allows us to manage the .properties file configurations
public class PropertyManager {

    static Properties prop = new Properties();

    private static String propertyFilePath =
            "src/test/java/com/lwtears/tests/utilities/configuration.properties";

    //This method is for reading the file
    public static String readPropertiesFile(String value) {
        try {
            InputStream input = new FileInputStream(propertyFilePath);
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop.getProperty(value);
    }



    private String adminEmail = readPropertiesFile("adminEmail");
    private String adminPassword = readPropertiesFile("adminPassword");


    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminPassword() {return adminPassword;}

//We can also write to the properties file using this method

    public static void writePropertiesFile(String key, String value, String comment) {
        try {
            OutputStream output = new FileOutputStream(
                    propertyFilePath);
            prop.setProperty(key, value);
            prop.store(output, comment);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


