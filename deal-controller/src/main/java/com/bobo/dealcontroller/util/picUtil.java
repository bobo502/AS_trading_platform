package com.bobo.dealcontroller.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

//import的内容，直接ALt+Enter吧
@CrossOrigin
@Service
public class picUtil {
    //这是本地存入的格式，上传到服务器的话，格式类似于，"/root/images/pc/"
    private static String UPLOAD_FOLDER = "F:/Desktop/photo/";

    // private Logger logger = LoggerFactory.getLogger(picUtil.class);打日志用的
    //Thread.currentThread().getContextClassLoader().getResource("").getPath();(获取当前的绝对路径的方法，这里不用，得到的是这样的东西:file:/D:/java/eclipse32/workspace/jbpmtest3/bin/)
    public String singleFileUpload(String prefix,MultipartFile pc1) throws IOException {
        // logger.debug("传入的文件参数：{}", JSON.toJSONString(file, true));
        if (Objects.isNull(pc1) || pc1.isEmpty()) {//判断非空
            // logger.error("文件为空");
            return "文件为空，请重新上传";
        }
        try {
            byte[] bytes = pc1.getBytes();
            //要存入本地的地址放到path里面
            Path path = Paths.get(UPLOAD_FOLDER + prefix + "/");
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(path);
            }
            String extension = getFileExtension(pc1);  //获取文件后缀

            UUID uuid = UUID.randomUUID();  //这里调用了UUID，得到全宇宙唯一的命名
            String str = uuid.toString(); // 真正的UUID打印出来是这样的：xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx (8-4-4-4-12)
            //所以我们可以去掉去掉"-"符号
            String picname = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
            String relativeAddr = picname + extension;  //唯一的名字接上后缀
            Thumbnails.of(pc1.getInputStream()).size(200, 200)    //写入
                    .outputQuality(0.8f).toFile(path + "/" + relativeAddr);
            //logger.debug("文件写入成功...");
            return relativeAddr;
        } catch (IOException e) {
            e.printStackTrace();
            return "后端异常...";
        }
    }

    //写一个删除方法，你们可以看情况修改
    public static String deFile(String path) {
        String resultInfo = null;
        Map<String, Object> modelMap = new HashMap<String, Object>();

        // String sb =area.getAreaName();;
        // sb.replace("/","\\");
        //String sb1 = "F:\\photos\\蛇皮玩意儿\\123\\瞎把.jpg";
        File file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                resultInfo = "1-删除成功";
            } else {
                resultInfo = "0-删除失败";
            }
        } else {
            resultInfo = "文件不存在！";
        }

        return resultInfo;

    }

    public static boolean deleteDirectory(String dirPath) {// 删除目录（文件夹）以及目录下的文件
        // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
        boolean flag = false;
        String a = null;
        if (!dirPath.endsWith(File.separator)) {
            dirPath = dirPath + File.separator;
            System.out.println("没有后缀符号'/'");

        }
        File dirFile = new File(dirPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            System.out.println("不是目录");
            return false;
        }
        flag = true;
        File[] files = dirFile.listFiles();// 获得传入路径下的所有文件
        for (int i = 0; i < files.length; i++) {// 循环遍历删除文件夹下的所有文件(包括子目录)
            if (files[i].isFile()) {// 删除子文件
                a = deFile(files[i].getAbsolutePath());
                System.out.println(files[i].getAbsolutePath() + " 目录文件删除成功");
                if (!flag)
                    break;// 如果删除失败，则跳出
            } else {// 运用递归，删除子目录
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag)
                    break;// 如果删除失败，则跳出
            }
        }
        if (!flag)
            return false;
        if (dirFile.delete()) {// 删除当前目录
            return true;
        } else {
            return false;
        }
    }

    private static String getFileExtension(MultipartFile File) {
        String originalFileName = File.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));

    }
}

