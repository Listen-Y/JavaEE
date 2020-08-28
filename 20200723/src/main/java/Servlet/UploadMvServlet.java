package Servlet;

import Model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 15:07
 */
@MultipartConfig
public class UploadMvServlet extends HttpServlet {

    private final String PATH = "/root/apache-tomcat-8.5.57/webapps/OnlineMusic/video/";

    //将文件上传至服务器
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = (User) req.getSession(false).getAttribute("user");
        if (user == null) {
            req.setAttribute("msg", "登录后再上传");
        } else {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> items = null;

            try {
                items = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
                return;
            }

            FileItem item = items.get(0);
            req.getSession().setAttribute("fileMvName", item.getName());
            try {
                item.write(new File(PATH, item.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            resp.sendRedirect("uploadMVSuccess.html");
        }

    }

}
