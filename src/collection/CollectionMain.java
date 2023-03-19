package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 第3回課題 Collection Map・Listの使用
 *
 * @author sato
 * @version 1.0.0
 */
public class CollectionMain {
    public static void main(String[] args) {

        Map<String, String> cloudByVendor = new HashMap<>();
        cloudByVendor.put("Amazon", "AWS");
        cloudByVendor.put("MicroSoft", "Azure");
        cloudByVendor.put("Google", "GCP");

        System.out.println("MapのKeyとvalueを表示");
        for (Map.Entry<String, String> entry : cloudByVendor.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        System.out.println("------------------------------------");

        List<String> osList = new ArrayList<>();
        osList.add("Windows");
        osList.add("macOS");
        osList.add("Unix");
        osList.add("Linux");

        System.out.println("Listの中身を表示");
        for (String os : osList) {
            System.out.println(os);
        }
    }
}
