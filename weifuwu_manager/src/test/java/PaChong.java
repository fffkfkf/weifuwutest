import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * 爬虫 spider
 * @author gmq
 * @date 2019/12/19
 * 版权：Copyright 2000-2001 si-tech.com.cn  All Rights Reserved.
 */
public class PaChong implements PageProcessor {

    @Override
    public void process(Page page) {
        System.out.println(page.getHtml().toString());
    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(100).setRetryTimes(3);
    }

    //https://cn.bing.com/
    public static void main(String[] args) {
        //成功： Spider.create(new MyProcessor()).addUrl("https://blog.csdn.net").run();
        Spider.create(new PaChong()).addUrl("https://www.runoob.com/")
                .run();

        System.out.println(1212);

    }

}

