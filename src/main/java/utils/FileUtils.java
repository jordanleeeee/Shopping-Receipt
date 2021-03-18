package utils;

import com.opencsv.bean.CsvToBeanBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readCSVFile(String filePath, int skipLine, Class<T> type) {
        try {
            return new CsvToBeanBuilder(new FileReader(filePath))
                    .withType(type)
                    .withSkipLines(skipLine)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            System.err.println("cannot find csv file: " + filePath);
            System.exit(-1);
        } catch (Exception e){
            System.err.printf("parse data in %s to Class: %s error!\n", filePath, type.getName());
            System.exit(-1);
        }
        return null;
    }

    public static JSONObject readJSONFile(String filePath){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)){
            return (JSONObject)jsonParser.parse(reader);
        } catch (IOException e) {
            System.err.println("no such json file: " + filePath);
            System.exit(-1);
        } catch (ParseException e) {
            System.err.println("invalid json file format");
            System.exit(-1);
        }
        return null;
    }
}
