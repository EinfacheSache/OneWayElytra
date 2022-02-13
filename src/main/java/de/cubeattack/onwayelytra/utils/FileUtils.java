package de.cubeattack.onwayelytra.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import java.io.*;

import static org.apache.commons.io.IOUtils.DEFAULT_BUFFER_SIZE;

public class FileUtils {

    private static final YamlConfiguration yamlConfiguration = new YamlConfiguration();
    private static final File file = new File("plugins//Elytra//config.yml");

    public static void copyToFile(InputStream inputStream){
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
        }catch (IOException ignored){}
    }
    public static YamlConfiguration getYamlConfiguration() {
        return yamlConfiguration;
    }
    public static File getFile() {
        return file;
    }
}
