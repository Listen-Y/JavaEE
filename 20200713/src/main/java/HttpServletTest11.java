import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

//必须要有这个字段表示文件上传
@MultipartConfig
public class HttpServletTest11 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String loadPath = "D:\\java\\test";
        File file = new File(loadPath);
        //获取文件，文件在html中的name是“file”
        Part imag = req.getPart("file");
        //制作文件全路径
        String path = file.getPath() + File.separator + imag.getSubmittedFileName();
        System.out.println(path);
        imag.write(path);
        //如果上传成功就制作响应报文
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<h1>写入成功</h1>");
        writer.write("<h1>路径为: " + path + "</h1>");
    }
}
