package ap.com.email;

import android.util.Log;

import org.apache.commons.mail.HtmlEmail;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class Mail1 {

    private static String hostName = "smtp.qq.com";
    private static String userName = "18383138318";
    private static String password = "xogxqtkiipuzgdbi";
    private static String fromEmail = "1322265057@qq.com";
    private static String Charset = "gbk";

    public static void sendMail(String toEmail, String title, String content) {
        try {
            //创建HtmlEmail类
            HtmlEmail email = new HtmlEmail();
            //填写邮件的主机明。我这里使用的是163
            email.setHostName(hostName);
            email.setTLS(true);
            email.setSSL(true);
            //设置字符编码格式，防止中文乱码
            email.setCharset(Charset);
            //设置收件人的邮箱
            email.addTo(toEmail);
            //设置发件人的邮箱
            email.setFrom(fromEmail);
            //填写发件人的username和password
            email.setAuthentication(userName, password);
            //填写邮件主题
            email.setSubject(title);
            //填写邮件内容
            email.setMsg(content);
            //发送邮件
            email.send();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            Log.i("TAG", "---------------->" + e.getMessage());
        }
    }
}
