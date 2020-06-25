package exam;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PGMImage {

    int[][] pixColor;
    int width;
    int height;

    PGMImage(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixColor = new int[width][height];
    }

    void setPixel(int x, int y, int color) {
        pixColor[x][y] = color ;
    }

    public void saveTo(String filename) throws IOException {
        try (PrintStream out = new PrintStream(filename, StandardCharsets.UTF_8)) {
            out.println("P2");
            out.println(width + " " + height);
            out.println("255");

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    out.print(pixColor[x][y]);
                    out.print(" ");
                }
                out.print("\n");
            }

        }


    }


}
