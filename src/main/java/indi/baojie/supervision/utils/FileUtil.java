package indi.baojie.supervision.utils;

import indi.baojie.common.data.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Gong on 2016/5/25.
 */
public class FileUtil {
    Logger logger = LoggerFactory.getLogger(FileUtil.class);

    private String[] imageType = { ".png", ".jpg", "jpeg", ".gif"};
    private String[] videoType = { ".mp4", ".avi", ".3gp", ".rmvb","wav","mpg","vob","mov","flv","swf"};

    public String SAVEURL_ACTIVITY_IMG = "/file/img/activity/";
    public String SAVEURL_AVATAR = "/file/img/avatar/";

    /**
     *
     * @param request 文件路径
     * @param file 文件
     * @param saveUrl url路径   保存路径 应用名下一级开始
     * @return
     */
    public JsonResult saveFile(HttpServletRequest request, MultipartFile file, String saveUrl){

        String savePath = getPhysicalPath(request);

        JsonResult res = new JsonResult();
        if (!file.isEmpty()) {
            String originalName = file.getOriginalFilename();  //获取文件名

            String fileType = originalName.substring(originalName.lastIndexOf("."));  //获取文件类型
            String fileName = UUID.randomUUID().toString().replace("-", "")+originalName.lastIndexOf(".")+fileType;  //新文件名的文件
            String dateDir = new SimpleDateFormat("yyMMdd").format(new Date());
            File fileDir = new File( savePath + File.separator +saveUrl+ File.separator + dateDir);
            if(!fileDir.exists()){
                fileDir.mkdirs();
            }
            String relativePath = saveUrl+ File.separator + dateDir + File.separator + fileName;  //相对路径地址
            String absolutePath = savePath+ File.separator + relativePath;  //绝对路径
            /*String filePath = savePath+ File.separator + saveUrl+ File.separator + dateDir + File.separator + fileName; //保存路径  绝对路径*/
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(absolutePath)));
                stream.write(bytes);
                stream.close();
                res.markSuccess("保存成功", relativePath); //保存路径返回  相对路径
            } catch (Exception e) {
                logger.error("保存过程出现异常", e);
                res.markError("保存过程出现异常");
            }
        } else {
            res.markError("文件内容为空");
        }
        return res;
    }

    public boolean isImage(String fileName){
        if(fileName!=null){
            String fileAffix = fileName.substring(fileName.lastIndexOf("."));
            if(Arrays.asList(imageType).contains(fileAffix)){
                return true;
            }

        }
        return false;
    }

    public boolean isVideo(String fileName){
        if(fileName!=null){
            String fileAffix = fileName.substring(fileName.lastIndexOf("."));
            if(Arrays.asList(videoType).contains(fileAffix)){
                return true;
            }

        }
        return false;
    }

    private String getPhysicalPath(HttpServletRequest request) {
        return request.getSession().getServletContext().getRealPath("");
    }

    /**
     * 下载
     * @param response
     * @param request
     * @param path  路径  不含应用名
     * @param contentType
     * @param realName  下载显示名称  包含文件类型
     * @throws Exception
     */
    public void download(HttpServletResponse response,HttpServletRequest request,String path, String contentType,
                         String realName) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String ctxPath = request.getSession().getServletContext().getRealPath("/");
        String downLoadPath = ctxPath + "/"+path;
        String fileType = path.substring(path.lastIndexOf("."));  //获取文件类型
        //realName = realName + fileType;

        long fileLength = new File(downLoadPath).length();

        //response.setContentType(contentType);
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(realName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));

        bis = new BufferedInputStream(new FileInputStream(downLoadPath));
        bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[2048];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        bis.close();
        bos.close();
    }


    /**
     * 校验文件是否为空
     * @param file
     * @return
     */
    public JsonResult checkFileNullAndSize(MultipartFile file){
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess(true);
        boolean fileIsNull = true;
        if (file != null && !file.isEmpty()) {
            fileIsNull = false;
            if(file.getSize()>5242880){
                jsonResult.markError("文件太大,请重新上传");
            }

            jsonResult.setData(fileIsNull);

        }else{

            jsonResult.setData(fileIsNull);
        }
        return  jsonResult;
    }

}
