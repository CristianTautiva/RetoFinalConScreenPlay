package com.demoqa.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Properties;

public class SpecialMethods {
    private static int consecutivo = 0;
    public static Properties properties;

    public static void configProperties(){
        properties = new Properties();
        try {
            properties.load(new FileReader("conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void waitFor(int segundos) throws InterruptedException {
        Thread.sleep(segundos*1000);
    }

    public static void takeScreenShotFullPage(WebDriver driver){
        try {
            //de aqui
            String directoryName = System.getProperty("user.dir");
            java.util.Date fecha = new Date();
            DateFormat formateadorFecha = DateFormat.getDateInstance(DateFormat.LONG);
            String ruta = directoryName+"\\configEvidenciaSQA\\screenshot_"+consecutivo+"_"+formateadorFecha.format(fecha)+".jpg";
            System.out.println("La ruta de la imagen es : "+ruta);
            //hasta aqui no tocar
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "jpg", new File(ruta));
            consecutivo++;
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void takeScreenShotShortPage(WebDriver driver){
        try {
            //DE AQUI
            String directoryName = System.getProperty("user.dir");
            java.util.Date fecha = new Date();
            DateFormat formateadorFecha = DateFormat.getDateInstance(DateFormat.LONG);
            String ruta = directoryName+"\\configEvidenciaSQA\\screenshot_"+consecutivo+"_"+formateadorFecha.format(fecha)+".jpg";
            System.out.println("La ruta de la imagen es : "+ruta);
            // HASTA AQUI NO TOCAR!!
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(ruta));
            consecutivo++;
        }catch (IOException errorsito){
            errorsito.printStackTrace();
        }
    }

}
