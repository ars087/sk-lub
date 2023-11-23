import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class CreateThread implements  Runnable{
File[] partArray;
String dstFolder;
long startOfcouting;
 public  static final    int newWidth = 300;
       CreateThread(File [] partArray, String dstFolder, long starsOfcouting ){
           this.partArray = partArray;
           this.dstFolder = dstFolder;
           this.startOfcouting = starsOfcouting;

       }

    @Override
    public void run() {
        try {
            for (File file : partArray) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }


                BufferedImage newImage = Scalr.resize( image, Scalr.Method.QUALITY, Scalr.Mode.FIT_TO_WIDTH,
                      newWidth, Scalr.OP_ANTIALIAS );

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

       long finish =  System.currentTimeMillis();
        System.out.println( finish - startOfcouting );

    }
}
