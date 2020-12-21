通过源码分析自动配置原理
当我们在SpringBoot项目中的application.properties/yml文件中进行属性配置后, 为什么他能识别并且加载我们配置好的属性, 他是在如何获取的

我再之前的文章说到所有的自动配置都是在项目启动阶段, 通过扫描反射加载得到META-INF/spring.factories文件中的配置文件, 实现自动配置, 那我们再好好研究他是如何获取我们自定义的属性配置的

比如我在application.properties文件中配置spring.webservices.path=

我们进入这个类中


@ConfigurationProperties(
    prefix = "spring.webservices"
)
public class WebServicesProperties {
    private String path = "/services";
    private final WebServicesProperties.Servlet servlet = new WebServicesProperties.Servlet();

    public WebServicesProperties() {
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        Assert.notNull(path, "Path must not be null");
        Assert.isTrue(path.length() > 1, "Path must have length greater than 1");
        Assert.isTrue(path.startsWith("/"), "Path must start with '/'");
        this.path = path;
    }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
21
@ConfigurationPropertise这个注解就表示告诉SpringBoot这个类中的属性的可以由配置文件来实现赋值, 并且使用prefix表示指定在配置文件中这个字符串下的数据名对应的值将和这个类中字段名进行一一映射实现赋值
这下我们就知道我们配置文件中的数据都会被加载对应的prefix类中
然后我们再在META-INF/spring.factories中找到WebServicesAutoConfiguration这个自动配置类
//表示这是一个配置类
@Configuration(
    proxyBeanMethods = false
)
//判断是不是web应用 ,如果是就进行下面的配置操作
@ConditionalOnWebApplication(
    type = Type.SERVLET
)

//ConditionalOn都是一些判断操作
@ConditionalOnClass({MessageDispatcherServlet.class})
@ConditionalOnMissingBean({WsConfigurationSupport.class})
//特别注意这里开启了自动配置, 并且导入了我们上面说到的获取配置文件数据的类
@EnableConfigurationProperties({WebServicesProperties.class})
@AutoConfigureAfter({ServletWebServerFactoryAutoConfiguration.class})
public class WebServicesAutoConfiguration {
    public WebServicesAutoConfiguration() {
    }
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
这下我们就清楚了, 当一个自动配置类生效前, 会进行数个判断, 而且还会开启自己对应的获取属性的类(WebServicesProperties.class), 在这个类中通过@ConfigurationProperties和prefix来获取我们配置文件中的配置数据
总结
在一个自动配置的文件中, 会根据当前不同的条件判断，决定这个配置类是否生效！

一但这个配置类生效；这个配置类就会给容器中添加各种组件；

这些组件的属性是从对应的properties类中获取的，这些类里面的每一个属性又是使用@ConfigurationProperties和prefix和配置文件绑定的；

所有在配置文件中能配置的属性都是在xxxxProperties类中封装着；

配置文件能配置什么就参照某个功能对应的xxxxProperties类有什么即可

精华所在

1、SpringBoot启动会加载大量的自动配置类

2、我们看我们需要的功能有没有在SpringBoot默认写好的自动配置类当中；（只要我们要用的组件存在在其中，我们就不需要再手动配置了）

3、在一个自动配置类生效前, 会进行几个@Conditional判断, 只有都符合了才会生效(导入了具体的启动器)

4、生效给容器中自动配置类添加组件的前，会从对应的XXXproperties类中获取某些属性。我们只需要在配置文件中指定这些属性的值即可；

5、最后这个自动配置类就会生效

xxxxProperties:封装配置文件中相关属性；

xxxxAutoConfigurartion：自动配置类；给容器中添加组件

我们在配置文件中配置debug=true就可以看到那些配置文件启动了