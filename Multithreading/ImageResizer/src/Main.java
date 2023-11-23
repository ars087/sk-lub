import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\ars08\\OneDrive\\Desktop\\src\\";
        String dstFolder = "C:\\Users\\ars08\\OneDrive\\Desktop\\dst\\";
        long startOfcounting = System.currentTimeMillis();
        copyPhoto(srcFolder, dstFolder, startOfcounting);
    }

    public static void copyPhoto(String strFolder, String dstFolder, long startOfcounting) {

        File srcDir = new File(strFolder);
        File[] files = srcDir.listFiles();
        int proc = Runtime.getRuntime().availableProcessors();

        if (files.length < proc) {
            proc = files.length;
        }
        int devCount = (files.length + 1) / proc;

        for (int i = 0; i < files.length; i++) {

            if (0 == i % devCount && proc >= 1) {

                if (proc == 1) {
                    devCount = files.length - i;

                }

                File[] partArray = new File[devCount];
                System.arraycopy(files, i, partArray, 0, partArray.length);
                var e = new CreateThread(partArray, dstFolder, startOfcounting);
                new Thread(e, "new thread").start();
                proc--;
            }
        }
    }
}
