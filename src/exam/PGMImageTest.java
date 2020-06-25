package exam;
import java.io.IOException;
import java.util.Random;

public class PGMImageTest {
    public static void main(String[] args) throws IOException {

        PGMImage randomPix = new PGMImage(80, 60);
        Random random = new Random();
        for (int x = 0; x < randomPix.width; x++)
            for (int y = 0; y < randomPix.height; y++)
                randomPix.setPixel(x, y, random.nextInt(255));

        randomPix.saveTo("D:\\Lesya\\Desktop\\progsredy\\osnovy_programmirovanya\\4sem\\src\\exam\\random.pgm");

        PGMImage gradientPix = new PGMImage(80, 60);
        for (int x = 0; x < gradientPix.width; x++)
            for (int y = 0; y < gradientPix.height; y++)
                gradientPix.setPixel(x, y, (x + y) % 256);

        gradientPix.saveTo("D:\\Lesya\\Desktop\\progsredy\\osnovy_programmirovanya\\4sem\\src\\exam\\gradient.pgm");
    }
}
