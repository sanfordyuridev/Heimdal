package com.impalinha.heimdal.Checker;

import com.impalinha.heimdal.Pref.ModEntity;

import java.io.File;

public class CheckerMod {
    private File modsDir;
    public static Boolean modsWrong = false;

    public CheckerMod(File modsDir) {
        this.modsDir = modsDir;
    }

    public void CheckModsIntegrity() {
        if(!modsWrong) {
            CheckModsFileNameAndSize();
        }
    }

    private void CheckModsFileNameAndSize() {
        if (modsDir.exists() && modsDir.isDirectory()) {
            File[] files = modsDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        long sizeBytes = file.length();
                        String fileName = file.getName();
                        boolean iFind = false;
                        boolean sizeOk = true;

                        if (!fileName.equals(Consts.HEIMDAL)) {
                            for (ModEntity mod : Consts.CURRENT_MODS) {
                                if (mod.getName().equals(fileName)) {
                                    iFind = true;
                                    if (!mod.getSize().equals(String.valueOf(sizeBytes))) {
                                        sizeOk = false;
                                    }
                                    break;
                                }
                            }
                        } else {
                            //Bypass for Heimdall, because serve-side will verify everything...
                            iFind = true;
                            sizeOk = true;
                        }

                        if (!sizeOk || (!iFind)) {
                            modsWrong = true;
                            break;
                        }
                    }
                }
            }
        }
    }


    public static Boolean isModsWrong() {
        return modsWrong;
    }
}
