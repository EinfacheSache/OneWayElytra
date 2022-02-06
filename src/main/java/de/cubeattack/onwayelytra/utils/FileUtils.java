package de.cubeattack.onwayelytra.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.DEFAULT_BUFFER_SIZE;

public class FileUtils {
    public static File file = new File("plugins//Elytra//config.yml");
    public static YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);

    public static void copyToFile(InputStream inputStream) {
        try {
            if (!file.exists()) {
                yamlConfiguration.save(file);
                try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
                    int read;
                    byte[] bytes = new byte[DEFAULT_BUFFER_SIZE];
                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                }
            }
        }catch (IOException exception){
            exception.printStackTrace();
        }
    }
}
