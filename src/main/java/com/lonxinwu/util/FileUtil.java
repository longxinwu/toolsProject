package com.lonxinwu.util;

import java.io.File;

public class FileUtil {
    public static void main(String[] args){
        String filename = "{0}.jks";
        File testfile = new File("D:"+File.separator+"filepath"+File.separator+filename);
        if(!testfile.exists()){
            testfile.mkdirs();
        }
        System.out.println("testFile:"+testfile);
    }

    /**
     * 检查文件是否存在
     * @param filePath
     * @return
     */
    public static File checkExists(String filePath){
        File file = new File(filePath);
        if(!file.exists()){
            file.mkdirs();
        }
        return file;
    }
}
