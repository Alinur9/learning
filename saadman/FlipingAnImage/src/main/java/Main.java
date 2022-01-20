import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Java Codes Intellij\\FlipAnImage\\src\\main\\resources\\simpson.png");
        FileInputStream is = new FileInputStream(file);
        BufferedImage bufferedImage = ImageIO.read(is);
//        AffineTransform at = AffineTransform.getScaleInstance(-1,-1);
//        at.translate(-bufferedImage.getWidth(null),-bufferedImage.getHeight(null));
//        AffineTransformOp op = new AffineTransformOp(at,AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
//        bufferedImage = op.filter(bufferedImage,null);
//        ImageIO.write(bufferedImage,"jpeg",new File("D:\\Java Codes Intellij\\FlipAnImage\\src\\main\\resources\\simpson_flipped.jpeg"));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        BufferedImage flipped = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        for(int y=0;y<height;y++)
        {
            for(int x=0;x<width;x++)
            {
                flipped.setRGB((width-1)-x,y,bufferedImage.getRGB(x,y));
            }
        }
        File outputFile = new File("D:\\Java Codes Intellij\\FlipAnImage\\src\\main\\resources\\flipped.jpg");
        ImageIO.write(flipped,"jpg",outputFile);
        System.out.println("Flipped");
    }
}
