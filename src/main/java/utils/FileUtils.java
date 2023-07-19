package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

/**
 * @author Jordan
 */
public class FileUtils {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> List<T> readCSVFile(String resource, Class<T> tClass) {
        return new CsvToBeanBuilder<T>(new InputStreamReader(getInputStream(resource)))
                .withType(tClass)
                .build()
                .parse();

    }

    public static <T> T readJSONFile(String resource, Class<T> tClass) {
        try {
            return MAPPER.readValue(getInputStream(resource), tClass);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
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
