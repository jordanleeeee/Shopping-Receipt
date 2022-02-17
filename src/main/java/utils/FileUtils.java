package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @author Jordan
 */
public class FileUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> List<T> readCSVFile(String filePath, Class<T> tClass) {
        try {
            return new CsvToBeanBuilder<T>(new FileReader(filePath))
                    .withType(tClass)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            throw new Error("cannot find csv file: " + filePath);
        } catch (Exception e) {
            throw new Error(String.format("parse csv data in %s to Class: %s error!\n", filePath, tClass.getName()));
        }
    }

    public static <T> T readJSONFile(String filePath, Class<T> tClass) {
        try {
            return MAPPER.readValue(Files.readString(Path.of(filePath)), tClass);
        } catch (JsonProcessingException e) {
            throw new Error(String.format("parse json data in %s to Class: %s error!\n", filePath, tClass.getName()));
        } catch (IOException e) {
            throw new Error("cannot find csv file: " + filePath);
        }
    }
}
