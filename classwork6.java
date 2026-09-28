import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class classwork6 {

    final static int RGB_BANDS_COUNT = 3;
    final static int RGB_CHANEL_MIN_VALUE = 0;
    final static int RGB_CHANEL_MAX_VALUE = 255;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter image height: ");
        int height = scanner.nextInt();

        System.out.print("Enter image width: ");
        int width = scanner.nextInt();

        int[][][] rgbBuffer = initRGBBands(height, width);

        saveAsPNG(rgbBuffer, "original.png");

        int[][][] filteredRGB = applyCustomFilter(cloneRGB(rgbBuffer));

        saveAsPNG(filteredRGB, "filtered.png");

        System.out.println("Images saved successfully.");
        System.out.println(new File("original.png").getAbsolutePath());
        System.out.println(new File("filtered.png").getAbsolutePath());

        scanner.close();
    }

    public static int[][][] cloneRGB(int[][][] rgb) {

        int[][][] result = rgb.clone();

        for (int y = 0; y < rgb.length; y++) {
            result[y] = rgb[y].clone();

            for (int x = 0; x < rgb[y].length; x++) {
                result[y][x] = rgb[y][x].clone();
            }
        }

        return result;
    }

    public static int[][][] applyCustomFilter(int[][][] rgb) {

        for (int y = 0; y < rgb.length; y++) {

            for (int x = 0; x < rgb[y].length; x++) {

                int red = rgb[y][x][0];
                int green = rgb[y][x][1];
                int blue = rgb[y][x][2];

                int gray = (int) (red * 0.3
                        + green * 0.6
                        + blue * 0.1);

                gray = Math.max(
                        RGB_CHANEL_MIN_VALUE,
                        Math.min(RGB_CHANEL_MAX_VALUE, gray)
                );

                rgb[y][x][0] = gray;
                rgb[y][x][1] = gray;
                rgb[y][x][2] = gray;
            }
        }

        return rgb;
    }

    public static void saveAsPNG(int[][][] rgb, String filename) {

        int height = rgb.length;
        int width = rgb[0].length;

        BufferedImage image = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_RGB
        );

        for (int y = 0; y < rgb.length; y++) {

            for (int x = 0; x < rgb[y].length; x++) {

                image.setRGB(
                        x,
                        y,
                        new Color(
                                rgb[y][x][0],
                                rgb[y][x][1],
                                rgb[y][x][2]
                        ).getRGB()
                );
            }
        }

        try {
            ImageIO.write(
                    image,
                    "png",
                    new File(filename)
            );

        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }

    public static int[][][] initRGBBands(
            int height,
            int width) {

        int[][][] bands =
                new int[height][width][RGB_BANDS_COUNT];

        for (int y = 0; y < bands.length; y++) {

            for (int x = 0; x < bands[y].length; x++) {

                bands[y][x] = initRGBPixel();
            }
        }

        return bands;
    }

    public static int[] initRGBPixel() {

        return new int[]{
                getRandomChanelValue(),
                getRandomChanelValue(),
                getRandomChanelValue()
        };
    }

    public static int getRandomChanelValue() {

        return getRandomChanelValue(
                RGB_CHANEL_MIN_VALUE,
                RGB_CHANEL_MAX_VALUE
        );
    }

    public static int getRandomChanelValue(
            int min,
            int max) {

        Random random = new Random();

        return random.nextInt(max - min + 1) + min;
    }
}