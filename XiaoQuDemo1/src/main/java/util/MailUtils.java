package util;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    //邮件发送协议
    private final static String PROTOCOL = "smtp";
    //SMTP邮件服务器
    private final static String HOST = "smtp.qq.com";
    //是否要求身份验证
    private final static String IS_AUTH = "true";
    // 是否启用调试模式（启用调试模式可打印客户 端与服务器交互过程时一问一答的响应消息）
    private final static String IS_ENABLED_DEBUG_MOD = "true";
    /**
     *
     * @param mailAddress 收件人地址
     * @param mailMsg     邮件正文
     * @throws MessagingException
     * @throws AddressException
     */
    public static void sendMail(String mailAddress, String mailMsg) throws MessagingException {
        // -- 1.创建一个Properties对象.里面 封装基本协议和数据
        Properties props = new Properties();
        // -- 设置邮件的发送协议
        props.setProperty("mail.transport.protocol", PROTOCOL);
        // -- 设置发送邮件的服务器地址
        props.setProperty("mail.smtp.host", HOST);
        // -- 设置发送邮件需要验证
        props.setProperty("mail.smtp.auth", IS_AUTH);
        props.setProperty("mail.debug", IS_ENABLED_DEBUG_MOD);
        //-- 提供验证器
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // TODO Auto-generated method stub
                return new PasswordAuthentication("1345851965@qq.com", "tmibooffcuvcjcha");
            }
        };
        //-- 开启和服务器的会话
        Session session = Session.getDefaultInstance(props, auth);
        //-- 创建消息对象.一个Message对象就 是一封邮件的内容
        Message msg = new MimeMessage(session);
        //-- 设置邮件的发送者
        msg.setFrom(new InternetAddress("1345851965@qq.com"));
        //-- 设置邮件的发送方式和接受者
        msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mailAddress));
        //设置邮件的主题
        msg.setSubject("发送邮件测试");
        //设置邮件的正文
        String url =  mailMsg;
        String content = "<h1>傻逼何伯康!</h1>";
        msg.setContent(content, "text/html;charset=utf-8");
        //-- 创建Transport用于发送邮件
        Transport.send(msg);
        System.out.println("发送成功！");
    }

    public static void main(String[] args) throws MessagingException {
        for (int i =0;i<10;i++){
            sendMail("599172441@qq.com","123213132");
        }



    }
}