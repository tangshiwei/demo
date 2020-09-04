package com.email;

import com.email.config.MailConfig;
import com.email.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEmailApplicationTests {
    @Autowired
    private MailConfig mailConfig;
    @Autowired
    private MailService mailService;
    String to="736922538@qq.com";
    @Test
    public void testMail() {
        String subject="springboot测试邮件发送";
        String text="收到邮件请回复";
        mailService.sendSimpleMail(mailConfig.getFrom(),to,subject,text);

    }
    @Test
    public void testHtmlMail(){
        String subject="springboot测试html邮件";
        String content="<html>\n" +
                "<body>\n" +
                "    <h3><a>hello world ! 这是一封Html邮件!</a></h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail(mailConfig.getFrom(),to,subject,content);
    }

    @Test
    public void sendAttachmentsMail() {
        String subject="有附件，请查收！";
        String content="主题：带附件的邮件, 有附件，请查收！";
        String filePath="C:\\Users\\Administrator\\Desktop\\服务器信息.txt";
        mailService.sendAttachmentsMail(mailConfig.getFrom(), to, subject,content, filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Administrator\\Desktop\\pic.jpg";

        mailService.sendResourceMail(mailConfig.getFrom(),to, "主题：这是有图片的邮件", content, imgPath, rscId);
    }


}
