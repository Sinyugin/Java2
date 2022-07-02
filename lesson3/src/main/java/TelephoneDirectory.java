import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    String telephone;
    String surname;
    String result;
    HashMap<String, String> list = new HashMap<>();
    Set<Map.Entry<String, String>> entrySet = list.entrySet();

    public void add(String telephone, String surname) {
        list.put(telephone, surname);
    }
    public void get(String result) {
        for (Map.Entry<String, String> integerObjectEntry :entrySet){
            if (result.equals(integerObjectEntry.getValue())) {
                System.out.println(integerObjectEntry.getValue() + " => " + integerObjectEntry.getKey());
            }
        }
    }
}

