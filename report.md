## Лабораторная работа 2.

Исходное изображение - [img.jpg](https://github.com/IvanHattler/Practice02/blob/master/src/main/resources/img.jpg)

Результаты обработки - [result](https://github.com/IvanHattler/Practice02/tree/master/result)

### 1) Отображение изображения по каналам RGB

Ниже приведен фрагмент кода, осуществляющий отображение изображения по каналам RGB:
```
public void channels(BufferedImage img) throws IOException {
        int h = img.getHeight();
        int w = img.getWidth();
        BufferedImage chR = new BufferedImage(w, h, TYPE_INT_RGB);
        BufferedImage chG = new BufferedImage(w, h, TYPE_INT_RGB);
        BufferedImage chB = new BufferedImage(w, h, TYPE_INT_RGB);
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int rgb = img.getRGB(x, y);
                int red = Utils.red(rgb);
                int green = Utils.green(rgb);
                int blue = Utils.blue(rgb);
                chR.setRGB(x, y, Utils.rgb(red, red, red));
                chG.setRGB(x, y, Utils.rgb(green, green, green));
                chB.setRGB(x, y, Utils.rgb(blue, blue, blue));
            }
        }
        Utils.save(chR, "result/channels", "r", "jpg");
        Utils.save(chG, "result/channels", "g", "jpg");
        Utils.save(chB, "result/channels", "b", "jpg");
    }
   ```
Результаты работы: 

[/result/channels/r.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/channels/r.jpg)

[/result/channels/g.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/channels/g.jpg)

[/result/channels/b.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/channels/b.jpg)

### 2) Лианеризация изображения обратным гамма преобразованием.

Ниже приведен фрагмент кода, осуществляющий лианеризацию изображения обратным гамма преобразованием:
```
public BufferedImage gammaCorrection(BufferedImage img, double gamma) throws IOException {
    int h = img.getHeight();
    int w = img.getWidth();
    BufferedImage result = new BufferedImage(w, h, TYPE_INT_RGB);
    int[] gammaLUT = new int[256];
    for (int i = 0; i < gammaLUT.length; i++) {
        gammaLUT[i] = (int) (255 * (Math.pow(i / 255f, 1 / gamma)));
    }
    for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
            int rgb = img.getRGB(x, y);
            int red = gammaLUT[Utils.red(rgb)];
            int green = gammaLUT[Utils.green(rgb)];
            int blue = gammaLUT[Utils.blue(rgb)];
            result.setRGB(x, y, Utils.rgb(red, green, blue));
        }
    }
    Utils.save(result, "result/gammaCor", "result", "jpg");
    return result;
}
```
Результат работы: 

[/result/gammaCor/result.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/gammaCor/result.jpg)

### 3) Отображение по каналам RGB.

Ниже приведен фрагмент кода, осуществляющий отображение по каналам RGB:
```
public void rgbChannels(BufferedImage img) throws IOException {
    int h = img.getHeight();
    int w = img.getWidth();
    BufferedImage chR = new BufferedImage(w, h, TYPE_INT_RGB);
    BufferedImage chG = new BufferedImage(w, h, TYPE_INT_RGB);
    BufferedImage chB = new BufferedImage(w, h, TYPE_INT_RGB);
    for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
            int rgb = img.getRGB(x, y);
            int red = Utils.red(rgb);
            int green = Utils.green(rgb);
            int blue = Utils.blue(rgb);
            chR.setRGB(x, y, Utils.rgb(red, 0, 0));
            chG.setRGB(x, y, Utils.rgb(0, green, 0));
            chB.setRGB(x, y, Utils.rgb(0, 0, blue));
        }
    }
    Utils.save(chR, "result/rgbChannels", "r", "jpg");
    Utils.save(chG, "result/rgbChannels", "g", "jpg");
    Utils.save(chB, "result/rgbChannels", "b", "jpg");
}
```
Результаты работы: 

[/result/rgbChannels/r.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/rgbChannels/r.jpg)

[/result/rgbChannels/g.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/rgbChannels/g.jpg)

[/result/rgbChannels/b.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/rgbChannels/b.jpg)

### 4) Отображение поканальной разницы между исходным изображением и линеаризованным

Ниже приведен фрагмент кода, осуществляющий отображение поканальной разницы между исходным изображением и линеаризованным:
```
public void difference(BufferedImage img, BufferedImage gCor) throws IOException {
    int h = img.getHeight();
    int w = img.getWidth();
    BufferedImage chR = new BufferedImage(w, h, TYPE_INT_RGB);
    BufferedImage chG = new BufferedImage(w, h, TYPE_INT_RGB);
    BufferedImage chB = new BufferedImage(w, h, TYPE_INT_RGB);
    for (int y = 0; y < h; y++) {
        for (int x = 0; x < w; x++) {
            int orig = img.getRGB(x, y);
            int corr = gCor.getRGB(x, y);
            int red = Utils.red(orig) - Utils.red(corr);
            int green = Utils.green(orig) - Utils.green(corr);
            int blue = Utils.blue(orig) - Utils.blue(corr);
            chR.setRGB(x, y, Utils.rgb(red, 0, 0));
            chG.setRGB(x, y, Utils.rgb(0, green, 0));
            chB.setRGB(x, y, Utils.rgb(0, 0, blue));
        }
    }
    Utils.save(chR, "result/difference", "r", "jpg");
    Utils.save(chG, "result/difference", "g", "jpg");
    Utils.save(chB, "result/difference", "b", "jpg");
}
```
Результаты работы: 

[/result/difference/r.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/difference/r.jpg)

[/result/difference/g.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/difference/g.jpg)

[/result/difference/b.jpg](https://github.com/IvanHattler/Practice02/tree/master/result/difference/b.jpg)
