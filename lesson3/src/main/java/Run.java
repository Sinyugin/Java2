
public class Run {

    public static void main(String[] args) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("89998887766", "Ivanov");
        telephoneDirectory.add("89998886655", "Petrov");
        telephoneDirectory.add("89998885544", "Sidorov");
        telephoneDirectory.add("89998884433", "Ivanov");
        telephoneDirectory.add("89998883322", "Kuznecov");
        telephoneDirectory.add("89998882211", "Ivanov");

        telephoneDirectory.get("Ivanov");

    }
}
