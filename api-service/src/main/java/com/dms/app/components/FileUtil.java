package com.dms.app.components;

import com.baomidou.mybatisplus.extension.api.R;
import com.dms.app.entity.Resource;
import com.dms.app.service.ResourceService;
import com.dms.app.vo.ResourceVo;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件上传、下载工具类
 */
@Component
public class FileUtil {

    @Value("${file.path}")
    public String filePath ; 


    @Autowired
    ResourceService resourceService;

    //允许上传的文件类型
    String fileSuffixs[] = {"doc","docx","xls","xlsx","pdf"};

    /**
     * 资料上传
     * @param file 文件
     * @param resourceVo 对应的数据库存储服务
     * @return
     * @throws IOException
     */
    @Transactional
    public  R upFileDoc(HttpServletResponse response,MultipartFile file, ResourceVo resourceVo) throws IOException {
        //确保文件对象不为空
        if (!file.isEmpty ()) {
            //得到文件名称
            String fileName = file.getOriginalFilename ();
            //得到文件后缀
            String fileSuffix = fileName.indexOf (".") != -1 ? fileName.substring (fileName.lastIndexOf (".") + 1, fileName.length ()) : null;
            //文件后缀不能为空
            if (fileSuffix != null) {
                //统一转小写
                final String suffix = fileSuffix.toLowerCase();
                //只允许上传word、pdf、和excel三类文件
                //这三类文件，匹配任意类型即可
                if(Arrays.stream(this.fileSuffixs).anyMatch(item-> item.equals(suffix))){
                    // 设置存放图片文件的路径
                    // 物理文件重新命名
                    // 存储在物理磁盘名称
                    String pathResourceName = "/"+resourceVo.getTypeId()+"/"+ randomUUID()+ "." +fileSuffix;

                    // 存储规则：基本路径+ 院系+文件类型ID+具体文件名称
                    String path = this.filePath + pathResourceName;

                    //如果ID大于1，先删除磁盘上的旧文件。
                    try {
                        File dest = new File (path);
                        //判断文件父目录是否存在
                        if (!dest.getParentFile ().exists ()) {
                            dest.getParentFile ().mkdir ();
                        }
                        if(resourceVo.getId()>0){
                            Resource delResource = resourceService.getById(resourceVo.getId());
                            //删除文件
                            if(delResource != null){
                                this.deleteFileByName(delResource.getPathResourceName());
                            }
                        }
                        //存储物理磁盘文件
                        file.transferTo (dest);
                        //========================================和数据库有关系
                        //磁盘上的文件名称
                        resourceVo.setPathResourceName(pathResourceName);
                        //文件大小
                        resourceVo.setResourceSize(new Double (file.getSize ()));
                        //文件后缀
                        resourceVo.setFileSuffix(suffix);
 
                        //上传成功后保存数据库
                        Resource resource = resourceService.saveResource(resourceVo);
                        
                        return R.ok(resource);

                    } catch (Exception e) {
                        return R.failed("错误："+e.getMessage());
                    }
                    
                }else{
                    return R.failed("只允许上传word、pdf、和excel三类文件");
                }
            }else{
                return R.failed("不能上传没有后缀的文件类型。");
            }
        }else{
            return R.failed("文件对象为空！");
        }

    }

    /**
     * 资料下载
     * @param response HttpServletResponse对象
     * @param filename 文件名称（实际的名称，不是数据库存的名称）
     * @return 
     * @throws UnsupportedEncodingException
     */
    public String downLoad(HttpServletResponse response,String filename) throws UnsupportedEncodingException {
        
        File file = new File(this.filePath + "/" + filename);

        //判断文件父目录是否存在
        if(file.exists()){ 
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            //文件输入流
            FileInputStream fis = null; 
            BufferedInputStream bis = null;
            //输出流
            OutputStream os = null; 
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            //必须关闭文件对象
            finally {
                try {
                    bis.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            } 
        }
        return "下载成功";
    }


       /**
     * 删除文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public  boolean deleteFileByName(String fileName) {
        String pathname = this.filePath + fileName;
        boolean result = false;
        File file = new File(pathname);
        if (file.exists()) {
            file.delete();
            System.out.println("文件已经被成功删除");
        }
        return result;
    }

       /**
     * 删除文件
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    @Transactional
    public  boolean deleteFileAndData(List<Long> idList, String fileName){
        //删除文件
        this.deleteFileByName(fileName);

        //在删除数据库
        return resourceService.removeByIds(idList);
    }


    /**
     * 文档在线预览
     *
     * @param response
     * @param response  文件存储路径 (前段获取文件存储路径返给后台)
     * @param filename 文件名(必须带文件后缀名,这里指的就是文件全名称)
     * @throws Exception
     */
    public void conversionFile(HttpServletResponse response, String filename) throws Exception {
        //文件存储路径
        String fileNamePath = this.filePath + "/" + filename;
        File file = new File(fileNamePath);
        if (!file.exists()) {
            System.err.println("没有文件。。。。");
            return;
        }
        //获取到文件名
        String interceptFileName = filename.substring(0, filename.lastIndexOf("."));
        //截取文件后缀名
        String fileNameSuffix = filename.substring(filename.lastIndexOf(".") + 1);
        String command = null;
        if("pdf".equals(fileNameSuffix)){
            //在线预览方法 
            //openPdf(response, interceptFileName + ".pdf");
        }else if("doc".equals(fileNameSuffix)) {
            //文件格式转换命令 unoconv插件实现
            command = "/usr/bin/unoconv -f pdf " + fileNamePath;
            //格式转换+在线预览
            formatConverAndPreview(command,response,interceptFileName);
        }else if("docx".equals(fileNameSuffix)) {
            command = "/usr/bin/unoconv -f pdf " + fileNamePath;
            formatConverAndPreview(command,response,interceptFileName);
        }else if("xls".equals(fileNameSuffix)) {
            command = "/usr/bin/unoconv -f pdf " + fileNamePath;
            formatConverAndPreview(command,response,interceptFileName);
        }else if("xlsx".equals(fileNameSuffix)) {
            command = "/usr/bin/unoconv -f pdf " + fileNamePath;
            formatConverAndPreview(command,response,interceptFileName);
        }else if("pptx".equals(fileNameSuffix)) {
            command = "/usr/bin/unoconv -f pdf " + fileNamePath;
            formatConverAndPreview(command,response,interceptFileName);
        }else{
            System.err.println("暂不支持该类型文件在线预览！！！");
            return;
        }
    }

    /**
     * 格式转换+在线预览 方法
     *
     * @param command            文件格式转换命令         例：/usr/bin/unoconv -f pdf  /app/1.pptx
     * @param response           http响应网页,实现在线预览
     * @param interceptFileName  文件名                  例: 1.pptx
     * @throws Exception
     */
    public void formatConverAndPreview(String command,
                                       HttpServletResponse response,
                                       String interceptFileName)throws Exception {
        /**
         * 格式转换方法
         */
        //String temp ="/usr/bin/unoconv -f pdf " + command;
        executeCommand(command);
        /**
         * 在线预览方法
         */
        //openPdf(response, this.filePath + interceptFileName + ".pdf");
    }

    /**
     * 在线预览方法
     * 把转换后的pdf文件在网页上进行预览
     *
     * @param response  http响应
     * @param previewFile  文件的決定路径  例：/app/20191009133209_chgrpt.pdf
     * @throws Exception  格式转换过程中的异常
     */
    private static void openPdf(HttpServletResponse response, String previewFile) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        
        inputStream = new FileInputStream(previewFile);
        //响应文件的类型
        response.setContentType("application/pdf");
        outputStream = response.getOutputStream();
        int a = 0;
        byte[] b = new byte[1024];
        while ((a = inputStream.read(b)) != -1) {
            outputStream.write(b, 0, a);
        }
        if (outputStream != null) {
            outputStream.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    /**
     * 格式转换方法
     * <p>
     * 統一把文件转换成pdf文件
     *
     * @param command 文件格式转换命令   例：/usr/bin/unoconv -f pdf  /app/1.pptx
     * @throws Exception   格式转换过程中的异常
     */
    private static void executeCommand(String command) throws Exception {

        StringBuffer output = new StringBuffer();
        Process process;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        try {
            process = Runtime.getRuntime().exec(command);
            process.waitFor();
            inputStreamReader = new InputStreamReader(process.getInputStream(), "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(inputStreamReader);
        }
    }


    /**
     * 生成随机号
     * @return
     */
    public  String randomUUID() {  
        return UUID.randomUUID().toString().replace("-", "");  
    }  
}
