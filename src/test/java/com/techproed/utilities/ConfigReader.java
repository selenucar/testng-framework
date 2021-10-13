package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader { // reusable class
    //This class is used to read configuration.properties file

    //Create Properties object
    private static Properties properties;

    // Using static block to run this code before the methods
    static{
        //path of the properties file
        String path ="configuration.properties";
        try{
            // opening the file
            FileInputStream fileInputStream = new FileInputStream(path);
            // instantiated the properties object
            properties = new Properties();
            //Loading the file
            properties.load(fileInputStream);
            //closing the file
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }// ending static block

    // Writing the method
    // it will take key
    // and return value
    // getProperty("app_url"); => http://www.carettahotel.com/

    public static String getProperty(String key){
        // key value relationship

        String value = properties.getProperty(key);
        return value;

//        return properties.getProperty(key);


    }
}
