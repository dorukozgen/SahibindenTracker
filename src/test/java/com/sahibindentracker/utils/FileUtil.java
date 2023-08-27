package com.sahibindentracker.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class FileUtil {

    public static void writeLine(String str) throws IOException {
        FileWriter fileWriter = new FileWriter(
                Paths.get("").resolve("./out/out.txt").toFile(),
                true
        );

        fileWriter.write(str + System.lineSeparator());
        fileWriter.close();
    }
}
