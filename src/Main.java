// Імпортуємо утіліти перед початком основного коду
import java.util.Formatter;
import java.util.Scanner;

// Головний клас програми
public class Main {

    // public  — метод доступний ззовні класу
    // static  — метод належить самому класу
    // void    — метод нічого не повертає
    // main    — спеціальна назва методу, з якого Java починає виконання
    // String[] args — масив аргументів командного рядка
    public static void main(String[] args) {

        // Створюємо об'єкт Scanner для введення даних з клавіатури
        Scanner scanner = new Scanner(System.in);

        int wholeNumber; // ціле число
        double decimalNumber; // число з плаваючою точкою
        String text; // для зберігання тексту
        boolean logicalValue; // логічне значення (true або false)

        // Введення цілого числа
        while (true) {
            System.out.print("Введіть ціле число: ");

            // Якщо введено ціле число, виходимо. Якщо щось інше, видаємо помилку
            if (scanner.hasNextInt()) {
                wholeNumber = scanner.nextInt();
                break;
            } else {
                System.out.println("Ви мали ввести ціле число...");
                scanner.next(); // видалення неправильного вводу
            }
        }

        // Введення числа з плаваючою точкою
        while (true) {
            System.out.print("Введіть число з плаваючою точкою: ");

            String input = scanner.next();

            try {
                decimalNumber = Double.parseDouble(input);

                // Якщо введено дробове число, виходимо. Якщо ні, - помилка
                if (input.contains(".")) {
                    break;
                } else {
                    System.out.println("Вам треба було ввести саме дробове число, наприклад 36.6");
                }

            // Якщо parseDouble() не зміг перетворити текст у число, виникає NumberFormatException
            // catch дозволяє перехопити цю помилку і не завершувати програму аварійно
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть число за таким прикладом: 36.6");
            }
        }

        // Очищення переходу на нову строку
        scanner.nextLine();

        // Введення строки
        System.out.print("Введіть строку: ");
        text = scanner.nextLine();

        // Введення логічного значення
        while (true) {
            System.out.print("Введіть логічне значення (true/false): ");

            if (scanner.hasNextBoolean()) {
                logicalValue = scanner.nextBoolean();
                break;
            } else {
                System.out.println("Будь ласка, перечитайте умову та спробуйте ще раз...");
                scanner.next();
            }
        }

        // Виводимо результат
        System.out.println();
        System.out.println("========== РЕЗУЛЬТАТ ==========");

        // 1. Стандартне виведення
        System.out.println("1. Ціле число: " + wholeNumber);

        // 2. printf - десятковий формат
        System.out.printf("2. Ціле число: %d%n", wholeNumber);

        // 3. printf - шістнадцятковий формат
        System.out.printf("3. Ціле число в HEX: %x%n", wholeNumber);

        // 4. printf - вісімковий формат
        System.out.printf("4. Ціле число в OCT: %o%n", wholeNumber);

        // 5. printf - двійковий формат
        System.out.printf("5. Ціле число в BIN: %s%n",
                Integer.toBinaryString(wholeNumber));

        // 6. Число з плаваючою крапкою з двома знаками після крапки
        System.out.printf("6. Ціле число з плаваючою крапкою: %.2f%n",
                decimalNumber);

        // 7. Число з шириною поля
        System.out.printf("7. Число в поле шириною 12: %12.3f%n",
                decimalNumber);

        // 8. String.format()
        String formattedText = String.format(
                "8. Строка: |%15s|", text
        );
        System.out.println(formattedText);

        // 9. Formatter
        Formatter formatter = new Formatter();

        formatter.format(
                "9. Логічне значення: %b, число: %d%n",
                logicalValue,
                wholeNumber
        );

        System.out.print(formatter);

        formatter.close();

        // 10. декілька значень в одній строці
        System.out.printf(
                "10. Усі дані: число=%d | дробове=%.2f | строка=%s | boolean=%b%n",
                wholeNumber,
                decimalNumber,
                text,
                logicalValue
        );

        scanner.close();
    }
}
