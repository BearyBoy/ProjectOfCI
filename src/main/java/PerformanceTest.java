import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.IOException;
import java.util.Random;

public class PerformanceTest {

    public static void main(String[] args) throws IOException {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        XYSeries series = new XYSeries("Execution Time");

        for (int size : sizes) {
            int[] numbers = generateRandomNumbers(size);
            long startTime = System.nanoTime();
            NumberProcessor._sum(numbers);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            series.add(size, duration);
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Execution Time vs Number of Elements",
                "Number of Elements",
                "Execution Time (ns)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);
        plot.setRenderer(renderer);

        JFrame frame = new JFrame("Performance Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }

    private static int[] generateRandomNumbers(int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = random.nextInt(1000);
        }
        return numbers;
    }
}

//Hello