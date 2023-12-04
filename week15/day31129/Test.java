import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String path = "/app/json/companies.json";

        // 파일이 없으면 생성
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        JSONObject json = new JSONObject();
        json.put("name", "Google");
        json.put("employees", 140000);
        json.put("offices", Arrays.asList("Mountain View", "Los Angeles", "New York"));

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
