package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Jordan
 */
public class FileUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> List<T> readCSVFile(String resource, Class<T> tClass) {
        try {
            return new CsvToBeanBuilder<T>(new InputStreamReader(getInputStream(resource)))
                    .withType(tClass)
                    .build()
                    .parse();
        } catch (Exception e) {
            throw new Error(String.format("parse csv data in %s to Class: %s error!", resource, tClass.getName()));
        }
    }

    public static <T> T readJSONFile(String resource, Class<T> tClass) {
        try {
            return MAPPER.readValue(getInputStream(resource).readAllBytes(), tClass);
        } catch (JsonProcessingException e) {
            throw new Error(String.format("parse json data in %s to Class: %s error!", resource, tClass.getName()));
        } catch (IOException e) {
            throw new Error("cannot find csv file: " + resource);
        }
    }

    private static InputStream getInputStream(String resource) {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        if (inputStream == null) {
            throw new Error("resource not found, resources=" + resource);
        }
        return inputStream;
    }
}
