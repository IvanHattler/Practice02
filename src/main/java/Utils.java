import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {
    public static int red(int rgb) {
        return (rgb & 0xff0000) >> 16;
    }

    public static int green(int rgb) {
        return (rgb & 0xff00) >> 8;
    }

    public static int blue(int rgb) {
        return rgb & 0xff;
    }

    public static int rgb(int r, int g, int b) {
        return (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff);
    }

    public static void save(BufferedImage bi, String path, String name, String format) throws IOException {
        Files.createDirectories(Paths.get(path).toAbsolutePath());
        ImageIO.write(bi, format, new File(path + "/" + name + "." + format));
    }
}
