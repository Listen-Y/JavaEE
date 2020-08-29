package listen.service;

import listen.exception.ClientException;
import listen.exception.SystemException;
import listen.mapper.UserMapper;
import listen.model.Setting;
import listen.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UserService {

    @Value("${user.head.local-path}")
    private String localPath;
    @Value("${user.head.remote-path}")
    private String remotePath;
    @Value("${user.head.filename}")
    private String fileName;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SettingService settingService;

    public User login(User user) {

        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);//只根据用户名查询用户信息
        if (exist == null)
            throw new ClientException("USR001", "用户不存在");
        if (!exist.getPassword().equals(user.getPassword()))
            throw new ClientException("USR002", "用户名密码错误");
        return exist;
    }

    public void logout(HttpServletRequest request) {
        //因为没有拦截这个路径所以session有可能为空 也就是没有进行过登录
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            //说明进行了登录
            session.removeAttribute("user");
        }
    }

    @Transactional
    public void register(User user, MultipartFile headFile) {
        //如果这个账号已经存在返回失败
        User query = new User();
        query.setUsername(user.getUsername());
        User exist = userMapper.selectOne(query);
        if (exist != null) {
            throw new ClientException("USR003", "用户已存在");
        }
        //进行数据库操作
        //保存user信息
        String path = "/" + user.getUsername() + "/" + fileName;
        user.setHead(remotePath + path);
        userMapper.insertSelective(user);

        //用户创建完成还要
        Setting setting = new Setting();
        setting.setUserId(user.getId());
        setting.setBatchNumber(8);
        settingService.add(setting);

        //保存头像文件到服务器文件夹
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            File file = new File(localPath + "/" + user.getUsername());
            file.mkdirs();
            fileOutputStream = new FileOutputStream(localPath + path);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(headFile.getBytes());
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
            throw new SystemException("Sys001", "照片上传失败");
        } finally {
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new SystemException("SYS004", "照片上传失败", e);
            }
        }
    }
}
