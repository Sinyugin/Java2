import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TelephoneDirectory {
    public static void main(String[] args) {

        HashMap<String, Object> list = new HashMap<>();
        Set<Map.Entry<String, Object>> entrySet = list.entrySet();
        String result = "Ivanov";

        list.put("89998887766", "Ivanov"); // искомый результат
        list.put("89998886655", "Petrov");
        list.put("89998885544", "Sidorov");
        list.put("89998884433", "Ivanov"); // искомый результат
        list.put("89998883322", "Kuznecov");
        list.put("89998882211", "Vasin");

        for (Map.Entry<String, Object> integerObjectEntry : entrySet) {
            if (result.equals(integerObjectEntry.getValue())) {
                System.out.println(integerObjectEntry.getValue() + " => " + integerObjectEntry.getKey());
            }
        }
    }
}
