import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Loader {
    public static void main(String[] args)
    {
        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        long start;

        File[] files = srcDir.listFiles();

        try
        {
            if (!Files.exists(Paths.get(dstFolder)))
            {
                Files.createDirectories(Paths.get(dstFolder));
            }

            int i = 0;
            int p = Runtime.getRuntime().availableProcessors();
            int temp = files.length/p;
            while (i < p){
                File[] files1 = new File[temp];
                System.arraycopy(files, temp*i, files1, 0, files1.length);
                start = System.currentTimeMillis();
                Thread resize = new  Thread (new ImageResize(files1, start, dstFolder));
                resize.start();
                i++;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

