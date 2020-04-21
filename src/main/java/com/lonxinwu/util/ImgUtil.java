package com.lonxinwu.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgUtil {


    public static void main(String[] args) throws Exception{
        //createImage("Wangwangbo", new Font("宋体",Font.BOLD,60), new File("E:/b.png"), 300, 80);
        combineImage("E:/c.png");
    }

    /**
     * 将文字转换成图片
     * @return
     * @throws Exception
     */
    public static BufferedImage createImage(String str, Font font, File outFile,Integer width,Integer height) throws Exception{
        // 创建图片
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setClip(0,0,width,height);
        graphics.setColor(Color.white);
        // 先用黑色填充整张图片,也就是背景
        graphics.fillRect(0,0,width, height);
        // 在换成红色
        graphics.setColor(Color.red);
        // 设置画笔字体
        graphics.setFont(font);
        /** 用于获得垂直居中y */
        Rectangle clip = graphics.getClipBounds();
        FontMetrics fm = graphics.getFontMetrics(font);
        int ascent = fm.getAscent();
        int descent = fm.getDescent();
        System.out.println(ascent+"-----"+descent);
        int y = (clip.height - (ascent + descent))/2 + ascent;
        System.out.println("Y的起点:"+y);
        double fontLength = ((double)str.length()/2)*font.getSize();
        double left = (width-fontLength)/2;
        System.out.println("left"+left);
        int x = (int) (width-fontLength)/2;
        System.out.println(fontLength);
        System.out.println("宽："+width);
        System.out.println("x的起点:"+x);
        graphics.drawString(str,0,y);
        graphics.dispose();
        image.flush();
        System.out.println(image.getWidth()+"-----"+image.getHeight());
        ImageIO.write(image, "png",outFile);
        return image;
    }

    /**
     * 合并图片
     * @param imgPath
     */
    public static void combineImage(String imgPath){
        try{
            BufferedImage back = new BufferedImage(400, 100,BufferedImage.TYPE_INT_RGB);
            Graphics2D gd = back.createGraphics();
            //gd.setBackground(Color.red);
            //gd.setColor(Color.red);
            //gd.dispose();

            //BufferedImage small = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
            BufferedImage small = createImage("Wangwangbo", new Font("宋体",Font.BOLD,60), new File("E:/b.png"), 300, 80);
            //gd = back.createGraphics();
            gd.drawImage(small, 50, 10, 300, 80, null);
            gd.dispose();
            ImageIO.write(back, "png", new File(imgPath));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 导入本地图片到缓冲区
     */
    public BufferedImage loadImageLocal(String imgName) {
        try {
            return ImageIO.read(new File(imgName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 生成新图片到本地
     */
    public void writeImageLocal(String imgPath, BufferedImage img) {
        if (imgPath != null && img != null) {
            try {
                File outputfile = new File(imgPath);
                ImageIO.write(img, "jpg", outputfile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 拉伸图片，将图片拉伸成 newWidth newHeight的图片
     * @param oldImg
     * @param newWidth
     * @param newHeight
     * @return
     */
    public BufferedImage scaleImage(BufferedImage oldImg, int newWidth, int newHeight){
        Image image = oldImg.getScaledInstance(newWidth, newHeight, Image.SCALE_REPLICATE);
        BufferedImage newImg = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics grap = newImg.getGraphics();
        grap.drawImage(image, 0 ,0, null);
        grap.dispose();
        return newImg;
    }
}
