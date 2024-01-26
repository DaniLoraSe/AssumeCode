package pruebasUnitarias;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CodigoPruebasUnitarias {

    public static void main(String[] args) {
        try {
            BufferedImage image = loadImageFromFile();
            if (image != null) {
                manipulateImage(image);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage loadImageFromFile() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            return ImageIO.read(new File(filePath));
        }
        return null;
    }

    static void manipulateImage(BufferedImage image) {

        int width = image.getWidth();
        int height = image.getHeight();

        try {
            if (width > 0 && height > 0) {
                String orientation = (width > height) ? "Horizontal" : "Vertical";
                int widthA4 = 1123; // Ancho HOJA A4
                int heightA4 = 798; // Altura HOJA A4
                int newWidth;
                int newHeight;
                if (width > height) {
                    newWidth = widthA4;
                    newHeight = (int) ((double) widthA4 / width * height);
                } else {
                    newHeight = heightA4;
                    newWidth = (int) ((double) heightA4 / height * width);
                }

                System.out.println("Orientación: " + orientation);
                System.out.println("Ancho de la imagen original: " + width);
                System.out.println("Alto de la imagen original: " + height);
                System.out.println("Nuevo ancho de la imagen: " + newWidth);
                System.out.println("Nuevo alto de la imagen: " + newHeight);
            }
        } catch (Exception e) {
            System.out.println("Inserte un archivo que no sea nulo");
        }

    }
}
