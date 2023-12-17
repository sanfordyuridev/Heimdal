package com.impalinha.heimdal.Pref;

import com.impalinha.heimdal.Checker.Consts;
import org.apache.logging.log4j.Logger;

import java.io.File;

public abstract class Pref {
    public static boolean screenConnection;
    public static boolean shouldTryReplace;
    public static Logger log;
    public static File modsDir;
    public static File getModsDir(File modConfigurationDirectory) {
        File minecraftDir = modConfigurationDirectory.getParentFile();
        File modsDir = new File(minecraftDir, Consts.MODS_DIR);

        return modsDir;
    }

}
