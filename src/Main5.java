import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main5 {
    public static void main(String[] args) {
        // Валідація телефонного номера
        String phoneNumber = "(+380)50-333-33-33";
        if (validatePhoneNumber(phoneNumber)) {
            System.out.println("Телефонний номер валідний.");
        } else {
            System.out.println("Телефонний номер не валідний.");
        }

        // Заміна пробілів
        String inputString = "Я хочу    бути     програмістом";
        String modifiedString = replaceMultipleSpaces(inputString);
        System.out.println("Змінений рядок: " + modifiedString);

        // Видалення HTML тегів
        String htmlText = "<div>...текст з тегами...</div>";
        String plainText = removeHtmlTags(htmlText);
        System.out.println("Текст без HTML тегів: " + plainText);
    }

    // Функція для валідації телефонного номера
    private static boolean validatePhoneNumber(String phoneNumber) {
        String regex = "^\\(\\+380\\)[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    // Функція для заміни пробілів
    private static String replaceMultipleSpaces(String input) {
        String regex = "\\s+";
        return input.replaceAll(regex, " ");
    }

    // Функція для видалення HTML тегів
    private static String removeHtmlTags(String htmlText) {
        String regex = "<[^>]*>";
        return htmlText.replaceAll(regex, "");
    }
}
