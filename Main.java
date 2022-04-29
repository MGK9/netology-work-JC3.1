package StreamAPIprod.Instalation.Installing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final StringBuilder LOG = new StringBuilder();
    private static final String PATH = "E:/Games/Portal";

    private static final List<String> DIR_PATHS = Arrays.asList(
            PATH + "/src", PATH + "/res", PATH + "/savegames", PATH + "/temp",
            PATH + "/src/main", PATH + "/src/test",
            PATH + "/res/drawables", PATH + "/res/vectors", PATH + "/res/icons"
    );

    private static final List<String> FILE_PATHS = Arrays.asList(
            PATH + "/src/main/Main.java", PATH + "/src/main/Utils.java",
            PATH + "/temp/temp.txt"
    );

    public static void main(String[] args) {
        for (String dirPath : DIR_PATHS) {
            File dir = new File(dirPath);
            writeLog(dir, dir.mkdir());
        }

        for (String filePath : FILE_PATHS) {
            File file = new File(filePath);
            try {
                writeLog(file, file.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        writeFile(new File(PATH + "/temp/temp.txt"));
    }

    private static void writeLog(File file, boolean result) {
        LOG.append(file.isDirectory() ? "Каталог '" : "Файл '")
                .append(file.getName())
                .append(result ? "' успешно создан" : "' не создан")
                .append((!result && file.exists()) ? ", так как уже существует" : "")
                .append((!result && !file.exists()) ? ", так как неверно указан путь" : "")
                .append("\n");
    }

    private static void writeFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(LOG.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}