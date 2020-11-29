package com.longshu.petsfairy.common.utils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
/**
 * @author :龙叔
 * @description: 图片格式装换
 * @date :2020/5/16 11:09
 */
public class FormatConversion {

//    String src = "E:/2.";
//        new FormatConversion().Conversion(JPG,PNG,src);//JPG转成PNG
    //inputFormat表示原格式，outputFormat表示转化后的格式
    public static void Conversion(String inputFormat,String outputFormat,String src){
//        src =  src.substring(0,src.lastIndexOf("."));
        try {
            File input = new File(src+inputFormat);
            BufferedImage bim = ImageIO.read(input);
            File output = new File(src+outputFormat);
            ImageIO.write(bim, outputFormat, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
