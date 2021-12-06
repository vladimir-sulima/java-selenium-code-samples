package babcock.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    static {
        String log4jPath = System.getProperty("user.dir") + "/src/main/resources/log4j.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir"));
        System.setProperty("log4j.configurationFile", log4jPath);
    }

    public  static Logger Log = LogManager.getLogger(Log.class.getName());

    public static void startTestCase(String testCaseName){

        Log.info("----------------------------------------------------------");
        Log.info("*****************"+testCaseName+"******************");
        Log.info("----------------------------------------------------------");
    }

    public static void endTestCase(String testCaseName){

        Log.info("--------------------"+"E N D"+"---------------------------");
        Log.info("----------------------------------------------------------");
    }
}
