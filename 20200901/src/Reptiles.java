import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-02
 * Time: 21:19
 */

public class Reptiles {

    private final String AbsolutePath = "D:\\reptiles\\";

    //图片爬取 count为爬取的照片多少
    public void pictureReptiles(String keyWords) {
        System.out.println("默认保存路径为:" + AbsolutePath);
        String targetPath = AbsolutePath + keyWords + System.currentTimeMillis();
        File file = new File(targetPath);
        if (!file.exists()) {
            if (file.mkdirs()) {
                //图片保存文件夹以创建完毕
                //资源获取
                resourceGet(file, keyWords);
            }
        } else {
            resourceGet(file, keyWords);
        }

    }

    private void resourceGet(File file, String keyWords) {
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //创建url连接
            URL url = new URL("https://image.baidu.com/search/index" +
                    "?tn=baiduimage&ps=1&ct=201326592&lm=-1&cl=2&nc=1&ie=utf-8&word=" + keyWords);
            //打开资源
            inputStream = url.openStream();
            //字节数组用于临时存储资源
            byte[] buffer = new byte[1024];
            //使用StringBuilder保存获取的所有资源
            StringBuilder allResource = new StringBuilder();
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1) {
                //获取到了资源
                allResource.append(new String(buffer, 0, len, StandardCharsets.UTF_8));
            }

            //使用图片资源的正则表达式获取我们想要的资源
            String allPictureResource = allResource.toString();
            Pattern compile = Pattern.compile("https://.*?0\\.jpg");
            //使用匹配器匹配我们想要的资源
            Matcher matcher = compile.matcher(allPictureResource);

            //查看是否有匹配到的东西 如果有就获取该资源
            List<String> haveDown = new ArrayList<>();
            int count = 1;
            System.out.println("开始爬取...");
            while (matcher.find() ) {
                //System.out.println("正在爬取第" + count++ + "张...");
                System.out.println("正在爬取ing...");
                //获取匹配到的一条结果
                String pictureResource = matcher.group();
                //如果这个资源的照片已经下载过就不进行再次下载
                if (haveDown.contains(pictureResource)) {
                    continue;
                }
                //与这个图片资源获得连接
                URL pictureURL = new URL(pictureResource);
                inputStream = pictureURL.openStream();
                //创建文件输出流
                fileOutputStream = new FileOutputStream(file.getPath() + "/" + System.currentTimeMillis() + ".jpg");
                //输入到文件中
                while ((len = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, len);
                }
                //关闭资源
                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
                haveDown.add(pictureResource);
                //System.out.println("爬取第" + count++ + "张完毕...");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("爬取失败...");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("爬取成功...");
        }

    }


}
