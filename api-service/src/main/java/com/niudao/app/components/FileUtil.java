package com.niudao.app.components;

import com.niudao.app.entity.Resource;
import com.niudao.app.service.ResourceService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件上传工具类
 * 小明哥
 */
public class FileUtil {

    //文件存放地址，暂时放本地
    //合理的做法是：搭建一个资源服务器。
    public static final  String IMG_PATH = "/usr/local/nginx/html/resource/images/";
    //public static final  String IMG_PATH = "http://localhost:81/images/";

    /**
     * 删除文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static boolean deleteFile(List<Long> idList, String fileName,ResourceService resourceService){
        String pathname = FileUtil.IMG_PATH + fileName;
        boolean result = false;
        File file = new File(pathname);
        if (file.exists()) {
            file.delete();
            //在删除数据库
            result = resourceService.removeByIds(idList);
            System.out.println("文件已经被成功删除");
        }
        return result;
    }


    /**
     * 上传文件
     * @param file 文件
     * @param resourceService 对应的数据库存储服务
     * @return
     * @throws IOException
     */
    public static Resource upFile(MultipartFile file, ResourceService resourceService) throws IOException {


        String fileName = "";

        Resource resource = null;

        if (!file.isEmpty ()) {

            fileName = file.getOriginalFilename ();

            String type = fileName.indexOf (".") != -1 ? fileName.substring (fileName.lastIndexOf (".") + 1, fileName.length ()) : null;

            if (type != null) {
                if ("JPEG".equals (type.toUpperCase ())
                        || "JPG".equals (type.toUpperCase ())
                        || "PNG".equals (type.toUpperCase ())) {


                    // 设置存放图片文件的路径
                    String path = IMG_PATH + fileName;

                    File dest = new File (path);
                    //判断文件父目录是否存在
                    if (!dest.getParentFile ().exists ()) {
                        dest.getParentFile ().mkdir ();
                    }
                    if (dest.exists()) {
                        System.out.println("文件已存在");
                    } else {

                        file.transferTo (dest);


                        //========================================和数据库有关系
                        //上传成功后保存数据库
                        resource = new Resource ();
                        resource.setResourceName (fileName);
                        resource.setResourceSize (new Double (file.getSize ()));
                        resource.setResourceState (1);
                        resourceService.save (resource);

                    }

                }
            }
        }

        return resource;
    }
}
