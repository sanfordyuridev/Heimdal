package com.impalinha.heimdal.RestoreMod;

import com.impalinha.heimdal.Checker.Consts;
import com.impalinha.heimdal.Pref.Pref;
import net.minecraft.client.Minecraft;
import org.apache.commons.io.FileUtils;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public abstract class RestoreMod {
    public static void getHealthyFiles() throws IOException {
        String mcDir = Pref.modsDir.getParent();

        File file = new File(mcDir, "HealthyFiles.zip");
        FileUtils.copyURLToFile(new URL(Consts.LINK), file);

        extractZip(file.getPath(), mcDir);

        File fileBat = new File(mcDir, "CheckIntegrity.bat");
        FileUtils.copyURLToFile(new URL(Consts.LINK_BAT), fileBat);

        try {
            Desktop.getDesktop().open(fileBat);
            Thread.sleep(3000);
            Minecraft.getMinecraft().shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void extractZip(String caminhoArquivoZip, String diretorioDestino) throws IOException {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(caminhoArquivoZip))) {
            ZipEntry entrada;
            while ((entrada = zipInputStream.getNextEntry()) != null) {
                if(entrada.getName().startsWith(Consts.MODS_DIR)) {
                    Path modsCopyDir = Paths.get(diretorioDestino, Consts.MODS_DIR + "_copy");
                    Path entryPathInModsCopy = modsCopyDir.resolve(entrada.getName().replace(Consts.MODS_DIR + "/", ""));

                    if (entrada.isDirectory()) {
                        Files.createDirectories(entryPathInModsCopy);
                    } else {
                        Files.createDirectories(entryPathInModsCopy.getParent());
                        Files.copy(zipInputStream, entryPathInModsCopy, StandardCopyOption.REPLACE_EXISTING);
                    }

                    zipInputStream.closeEntry();
                }
            }
        }
    }

}
