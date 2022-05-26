import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        URL url = getImageUrl();
        if (url == null) return;

        Model model = new Model();
        BufferedImage orig = ImageIO.read(url);
        model.channels(orig);
        BufferedImage corrected = model.gammaCorrection(orig, 2.5);
        model.rgbChannels(corrected);
        model.difference(orig, corrected);
    }

    private static URL getImageUrl() {
        return Main.class.getResource("img.jpg");
    }
}
