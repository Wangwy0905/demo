package com.example.util;

import com.example.entity.UserEntity;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class ReadCsvUtil {
    private static final String CUSTOMER_NAME = "姓名";
    private static final String CUSTOMER_PASSWORD = "密码";
    private static final String FIX = "\uFEFF";

    /**
     * 获取csv文件内容
     *
     * @param </> 文件
     * @return 对象信息
     */
    public static List<UserEntity> getResource(String contentPath) throws IOException {
        List<UserEntity> allString = new ArrayList<>();
        UserEntity userEntity;
        List<String> list = new ArrayList<>();
        File file = base64StringToCsv(contentPath);
        // 获取文件内容
        list = csvParsing(file);
        // 获取文件表头
        List<String> title = Arrays.asList(list.get(0).split(","));
        String name = title.get(0).trim();
        String password = title.get(1).trim();
        // 头部会带有"\uFEFF"值，暂时这么处理
        if (name.startsWith(FIX)) {
            name = name.replace(FIX, "");
        }
        if (name.startsWith(FIX)) {
            name = name.replace(FIX, "");
        }
        if (CUSTOMER_NAME.equals(name) && CUSTOMER_PASSWORD.equals(password)) {
            list.remove(0);
            // 循环内容
            for (int i = 0; i < list.size(); i++) {
                List<String> content = Arrays.asList(list.get(i).split(","));
                // UUID用于多表关联的外键
                String uuid = UUID.randomUUID().toString();
                // 当没有添加额外参数时
                if (content.size() <= 2) {
                    userEntity = new UserEntity();
                    userEntity.setName(content.get(0));
                    userEntity.setPassword(content.get(1));
                    allString.add(userEntity);
                } else {
                    for (int k = 2; k < content.size(); k++) {
                        userEntity = new UserEntity();
                        userEntity.setName(content.get(0));
                        userEntity.setPassword(content.get(1));
                        //userEntity.setParamName(title.get(k));
                        //userEntity.setParamValue(content.get(k));
                        allString.add(userEntity);
                    }
                }
            }
        } else {
            return allString;
        }
        return allString;
    }

//    /**
//     * 读文件数据
//     *
//     * @param base64Content
//     * @return
//     * @throws
//     */
//
//
//    public static void base64ToFile(String base64) {
//        BufferedOutputStream bos = null;
//        java.io.FileOutputStream fos = null;
//        try {
//            byte[] bytes = Base64.getDecoder().decode(base64);
//            fos = new java.io.FileOutputStream(file);
//            bos = new BufferedOutputStream(fos);
//            bos.write(bytes);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (bos != null) {
//                try {
//                    bos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (fos != null) {
//                try {
//                    fos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    private static File base64StringToCsv(String base64Content) {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        File tempFile = null;

        try {
            //String deqdata = new String(Base64.decodeBase64(base64Content), "utf-8");
            byte[] bytes = Base64.decode(base64Content);
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            tempFile = File.createTempFile("test", ".csv");

            fos = new FileOutputStream(tempFile);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            bos.flush();
            return tempFile;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (fos != null) {
                    fos.close();
                }
                if (bos != null) {
                    bos.close();
                }
                // tempFile.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

//    public static List<String> read(File tempFile) throws IOException {
//        BufferedReader br = null;
//        FileInputStream fis = null;
//        InputStreamReader isr = null;
//        try {
//            fis = new FileInputStream(tempFile);
//            //指定以UTF-8编码读入
//            String charset = EncodeUtils.get_charset(tempFile);
//            if ("GBK" == charset) reader = new BufferedReader(new InputStreamReader(in, "GBK"));
//            if ("UTF-8" == charset) reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
//
//            isr = new InputStreamReader(fis, "utf-8");
//            br = new BufferedReader(isr);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        String line;
//        String everyLine;
//        List<String> allString = new ArrayList<>();
//        try {
//            //读取到的内容给line变量
//            while ((line = br.readLine()) != null) {
//                everyLine = line;
//                allString.add(everyLine);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fis != null) {
//                fis.close();
//            }
//            if (isr != null) {
//                isr.close();
//            }
//        }
//        return allString;
//    }

    public static List<String> csvParsing(File file) {
        try {
            //增加 FileInputStream类 以防止出現 'gbk' 乱码，方便读取
            FileInputStream in = new FileInputStream(file);
            String charset = EncodeUtils.get_charset(file);
            BufferedReader reader = null;
            if ("GBK" == charset) reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            if ("UTF-8" == charset) reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            List<String> fileString = new ArrayList<>();
            String line;
            String everyLine;
            while ((line = reader.readLine()) != null) {
                //sb.append(line);
                everyLine = line;
                fileString.add(everyLine);
            }
            return fileString;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}