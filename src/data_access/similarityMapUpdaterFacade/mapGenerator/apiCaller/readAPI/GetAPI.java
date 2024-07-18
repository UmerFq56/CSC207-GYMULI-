package data_access.similarityMapUpdaterFacade.mapGenerator.apiCaller.readAPI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GetAPI {

    private static final String API_URL;
    private static final String API_TOKEN;
    private static final String API_BODY;

    static {
        API_URL = readTokenFromFile("src/data_access/similarityMapUpdaterFacade/mapGenerator/apiCaller/readAPI/API_files/api_url.txt");
        API_TOKEN = readTokenFromFile("src/data_access/similarityMapUpdaterFacade/mapGenerator/apiCaller/readAPI/API_files/api_key.txt");
        API_BODY = readTokenFromFile("src/data_access/similarityMapUpdaterFacade/mapGenerator/apiCaller/readAPI/API_files/api_body.txt");
    }

    public static String readTokenFromFile(String fileName) {
        StringBuilder token = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                token.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token.toString();
    }

    public static String getAPI(String text1, String text2) {
        return String.format(API_URL + API_BODY,text1, text2, API_TOKEN);
    }

    public static void main(String[] args) {
        System.out.println(getAPI("It was a good day", "Today was a rainy day"));
    }
}
