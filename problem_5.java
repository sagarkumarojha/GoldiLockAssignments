import java.util.HashMap;
import java.util.Map;

public class problem_5 {
    /**Write a program to store the value in Hashmap (key, store) and 
     * then search those given value from the hashmap and print it. 
     * a. Name is key and age is value so store some sample values 
     * like i. (Ram, 36), (shyam,60)*/
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Ram", 36);
        hashMap.put("Shyam", 60);


        searchAndPrint(hashMap, "Ram");
        searchAndPrint(hashMap, "Shyam");
        searchAndPrint(hashMap, "John"); // This is not in the HashMap
    }

    public static void searchAndPrint(Map<String, Integer> map, String key) {

        Integer age = map.get(key);
        if (age != null) {
            System.out.println("Age of " + key + ": " + age);
        } else {
            System.out.println(key + " not found in the HashMap.");
        }
    }
}
// Time-Taken ---> about 8-10 minutes
