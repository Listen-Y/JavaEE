package com.file.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-08
 * Time: 14:34
 */
@Controller
public class FileController {

    @RequestMapping("f1")
    public String f1(Model model) {
        model.addAttribute("msg", "hello");
        return "file";
    }


    //@RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
    //批量上传CommonsMultipartFile则为数组即可
    //方式一
    @RequestMapping("f2")
    public String upload(Model model, @RequestParam("file")CommonsMultipartFile file,
                         HttpServletRequest request) throws IOException {


        //获取文件名
        String fileName = file.getOriginalFilename();
        if (fileName == null || "".equals(fileName)) {
            //说明没有文件
            return "redirect:/index.jsp";
        }
        System.out.println("[DEBUG]" + fileName);

        //设置上传文件的保存路径
        String filePath = request.getServletContext().getRealPath("/upload");
        File uploadFile = new File(filePath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }

        InputStream inputStream = file.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath + "/" + fileName));
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer,0, len);
            fileOutputStream.flush();
        }

        //关闭流对象
        fileOutputStream.close();
        inputStream.close();
        model.addAttribute("msg", "上传成功: " + fileName);
        return "file";
    }


    //实现文件上传方式二
    @RequestMapping("/f3")
    public String upload2(Model model, @RequestParam("file") CommonsMultipartFile file,
                          HttpServletRequest request) throws IOException {

        String uploadFileName = file.getOriginalFilename();
        if (uploadFileName == null || "".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println("[DEBUG]" + uploadFileName);

        //下载文件
        String uploadPath = request.getServletContext().getRealPath("/upload");
        File uploadFile = new File(uploadPath);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }

        file.transferTo(new File(uploadPath + "/" + uploadFileName));
        model.addAttribute("msg", "上传成功: " + uploadFileName);
        return "file";
    }

    //判断文件是否已经上传
    @RequestMapping("/f4")
    @ResponseBody
    public List<String> getNames(HttpServletRequest request) {
        List<String> list = new ArrayList<>();
        String path = request.getServletContext().getRealPath("/upload");
        File file = new File(path);
        if (!file.exists()) {
            list.add("没有文件!!");
            return list;
        }
        File[] files = file.listFiles();
        if (files == null ||files.length == 0) {
            list.add("没有文件!!");
            return list;
        }
        for (File f : files
                ) {
            list.add(f.getName());
        }
        return list;
    }

    //实现文件下载
    @RequestMapping("/f5")
    public String down(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        //获得需要下载的文件名
        String fileName = request.getParameter("filename").trim();
        System.out.println("[DEBUG]" + fileName);
        List<String> list = getNames(request);
        //判断有没有这个文件
        String target = "";
        for (String s : list) {
            int index = s.lastIndexOf('.');
            if (index == -1) {
                model.addAttribute("msg", "还没有文件");
                return "file";
            }
            if (fileName.equalsIgnoreCase(s)) {
                target = s;
                break;
            }
            String s1 = s.substring(0, index);
            if (fileName.equalsIgnoreCase(s1)) {
                target = s;
                break;
            }
        }
        if (target.equals("")) {
            //说明没有文件
            model.addAttribute("msg", "请输入正确文件名");
            return "file";
        }

        //设置response响应头
        response.reset();  //清空缓存
        response.setCharacterEncoding("UTF-8");  //设置字符编码
        response.setContentType("multipart/form-data");  //设置二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        //获得所需的文件
        String path = request.getServletContext().getRealPath("/upload") + "/" + target;
        File file = new File(path);

        //下载文件
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        //关闭流对象
        outputStream.close();
        inputStream.close();

        model.addAttribute("msg", "下载成功");
        return "file";
    }


}
