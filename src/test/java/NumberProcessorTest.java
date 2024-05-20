import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NumberProcessorTest {

    @Test
    public void testMin() {
        int[] numbers = {1, 4, 2, 3};
        assertEquals(1, NumberProcessor._min(numbers));
    }

    @Test
    public void testMax() {
        int[] numbers = {1, 4, 2, 3};
        assertEquals(4, NumberProcessor._max(numbers));
    }

    @Test
    public void testSum() {
        int[] numbers = {1, 4, 2, 3};
        assertEquals(10, NumberProcessor._sum(numbers));
    }

    @Test
    public void testMult() {
        int[] numbers = {1, 4, 2, 3};
        assertEquals(24, NumberProcessor._mult(numbers));
    }

    @Test
    public void testReadNumbersFromFile() throws IOException {
        int[] expectedNumbers = {1, 2, 3, 4, 5};
        String filePath = "src/main/resources/test_numbers.txt";
        Files.write(Paths.get(filePath), "1 2 3 4 5".getBytes());

        int[] actualNumbers = NumberProcessor.readNumbersFromFile(filePath);
        assertArrayEquals(expectedNumbers, actualNumbers);
    }

    @Test
    public void testPerformance() throws IOException {
        int[] numbers = NumberProcessor.readNumbersFromFile("src/main/resources/number.txt");

        long startTime = System.nanoTime();
        NumberProcessor._min(numbers);
        long endTime = System.nanoTime();
        System.out.println("Min function took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        NumberProcessor._max(numbers);
        endTime = System.nanoTime();
        System.out.println("Max function took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        NumberProcessor._sum(numbers);
        endTime = System.nanoTime();
        System.out.println("Sum function took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        NumberProcessor._mult(numbers);
        endTime = System.nanoTime();
        System.out.println("Mult function took: " + (endTime - startTime) + " ns");
    }
}