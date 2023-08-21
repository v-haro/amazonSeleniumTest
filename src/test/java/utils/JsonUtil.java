package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonUtil {

    public static List<String> getArticlesFromJson(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String[] articles = objectMapper.readValue(new File(path), String[].class);
        return Arrays.asList(articles);
    }
}
