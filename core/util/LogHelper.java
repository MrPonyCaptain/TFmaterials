package mod_TFmaterials.core.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {

    private static Logger TFLogger = Logger.getLogger("TFmaterials");

    public static void init() {

        TFLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        TFLogger.log(logLevel, message);
    }

}