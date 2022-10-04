package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
  public static   Properties properties;

    static {
        String dosyaYolu="configuration.properties";

        try {
            FileInputStream fis= new FileInputStream(dosyaYolu);
            //fis dosya yolunu tanimladigimiz configuration.properties dosyasini okudu
            properties= new Properties();
            properties.load(fis); // properties.load ile fis'e okuttugum bilgileri yukledim
        } catch (IOException e) {
            throw new RuntimeException(e);// fis'in okudugu bilgileri properties'e yukledi.
        }

    }
    public static String getProperty(String key){
        /*
        test methodundan yolladigimiz string key degerini alip Properties calls'indan
        getProperty() method'unu kullanarak bu key'e ait value'u bize getirdi

         */

        return properties.getProperty(key);
    }

}
