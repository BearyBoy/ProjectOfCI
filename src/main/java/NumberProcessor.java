import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class NumberProcessor {

    public static int _min(int[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow();
    }

    public static int _max(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    public static int _sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static long _mult(int[] numbers) {
        long result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    public static int[] readNumbersFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        return Arrays.stream(content.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/number.txt";
        int[] numbers = readNumbersFromFile(filePath);

        System.out.println("Минимальное: " + _min(numbers));
        System.out.println("Максимальное: " + _max(numbers));
        System.out.println("Сумма: " + _sum(numbers));
        System.out.println("Произведение: " + _mult(numbers));
    }
}