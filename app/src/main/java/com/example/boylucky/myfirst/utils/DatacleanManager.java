package com.example.boylucky.myfirst.utils;

import android.content.Context;

import java.io.File;
import java.math.BigDecimal;

/**
 * 清除应用缓存
 * Created by BoyLucky on 2018/7/6.
 */

public class DatacleanManager {

    public static void cleanApplicationData(Context context,String...filepath){
        cleanInternalCache(context);
    }

    /*
       清除本应用的内部缓存（data/data/包名/cache）
    */
    public static void cleanInternalCache(Context context){
        deleteFilesByDirectory(context.getCacheDir());
    }

    public static void deleteFilesByDirectory(File file){
        if (file!=null&&file.exists()&&file.isDirectory()){
            for (File file1 : file.listFiles()) {
                file1.delete();
            }
        }
    }
    //内存单位转换
    public static String getFromatSize(double size){
        double kiloByte = size / 1024;
        double megaByte = kiloByte / 1024;
        if (megaByte < 1){
            BigDecimal result1 = new BigDecimal(Double.toString(kiloByte));
            return result1.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString()+"kB";
        }
        double gigaByte = megaByte / 1024;
        if (gigaByte < 1){
            BigDecimal result2 = new BigDecimal(Double.toString(megaByte));
            return result2.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString()+"MB";
        }
        double teraByte = gigaByte / 1024;
        if (teraByte < 1){
            BigDecimal result3 = new BigDecimal(Double.toString(gigaByte));
            return result3.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString()+"GB";
        }
        BigDecimal result4 = new BigDecimal(Double.toString(teraByte));
        return result4.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString()+"TB";

    }
    public static String getCacheSize(File file){
        return getFromatSize(getFolderSize(file));
    }
    //计算文件大小
    private static double getFolderSize(File file) {
        long size = 0 ;
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            //下一层是文件
            if (files[i].isDirectory()){
                size+= size+getFolderSize(files[i]);
            }else{
                size = size+ files[i].length();
            }
        }
        return size;
    }
}
