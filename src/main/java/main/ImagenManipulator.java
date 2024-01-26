package main;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagenManipulator {

    public static void main(String[] args) {
        try {
            // Seleccionar archivo
            JFileChooser fileChooser = new JFileChooser();

            // Filtro para aceptar solo imágenes tipo jpg
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(null);

            // Obtener la ruta del archivo seleccionado
            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                // Leer el tamaño de la imagen
                File inputFile = new File(filePath);
                BufferedImage image = ImageIO.read(inputFile);
                // Obtener las dimensiones de la imagen
                int width = image.getWidth();
                int height = image.getHeight();

                // Comparación de tamaños para determinar si es horizontal o vertical
                String orientation = (width > height) ? "Horizontal" : "Vertical";
                int WidthA4 = 1123; // Ancho HOJA A4
                int HeightA4 = 798; // Altura HOJA A4
                
                int newWidth;
                int newHeigh;

                    if (width > height) {
                        // Imagen horizontal a4
                        newWidth = WidthA4;
                        //nueva altura para  mantener la proporción original.
                        newHeigh = (int) ((double) WidthA4 / width * height);  
                    } else {
                        // Imagen vertical o cuadrada a4
                        newHeigh = HeightA4;
                        newWidth = (int) ((double) HeightA4 / height * width);
                    }

                    
                    // Obtener las respuestas de la imagen
                    System.out.println("Orientación: " + orientation);
                    System.out.println("Ancho de la imagen original: " + width);
                    System.out.println("Alto de la imagen original: " + height);
                    System.out.println("Nuevo ancho de la imagen: " + newWidth);
                    System.out.println("Nuevo alto de la imagen: " + newHeigh);

                
           
            }

        } catch (IOException e) {
            // Enviar flujo del error (donde se ha iniciado la excepción)
            e.printStackTrace();
        }
        
        
    }
}
