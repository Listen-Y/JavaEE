import model.Article;
import model.ArticleDao;

import java.util.List;

public class TestArticleDao {

    public static void main(String[] args) {

       /* Article article = new Article();
        article.setId(3);
        article.setTitle("好开心");
        article.setData("符合我UI安全阀后IE爱上佛为我去爱哦符号位OA负无穷返回为武器和服务为我为黄皮肤换武器和我穷怕hi欧派却无法hi耦合物权法切换放弃我和去问候if去武汉" +
                " 欺骗我热负荷青蛙破千万分群文件放弃凭借其违法破千万解放区附近藕切片凤凰网破你去啊颇为娶回家服务费物品我if后视镜访问复活甲傲世狂妃好几万破为交警覅我为维护" +
                "费怕我见覅进位为头发和静安里附近为i放假啊我批发价访问IP全方位群殴请问破旧房破千万飓风破");
        article.setUserId(6);*/

        //ArticleDao.articleDelete(article);
       /* Article article1 = new Article();
        article1.setId(4);
        article1.setTitle("好悲伤");
        article1.setData("符合我UI安全阀后IE爱上佛为我去爱哦符号位OA负无穷返回为武器和服务为我为黄皮肤换武器和我穷怕hi欧派却无法hi耦合物权法切换放弃我和去问候if去武汉" +
                " 欺骗我热负荷青蛙破千万分群文件放弃凭借其违法破千万解放区附近藕切片凤凰网破你去啊颇为娶回家服务费物品我if后视镜访问复活甲傲世狂妃好几万破为交警覅我为维护" +
                "费怕我见覅进位为头发和静安里附近为i放假啊我批发价访问IP全方位群殴请问破旧房破千万飓风破");
        article1.setUserId(6);
        ArticleDao.articleAdd(article1);*/
        /*List<Article> list = ArticleDao.articleSelect(6);
        for (Article a : list
             ) {
            System.out.println(a);
        }*/
     /*   System.out.println(ArticleDao.articleSelectData(3));
        System.out.println("===============");
        System.out.println(ArticleDao.articleSelectData(4));*/
        Article article = ArticleDao.articleSelectData(2);
        System.out.println(article);
    }

}
