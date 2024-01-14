package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.ITuanAccountService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/account")
public class MailController {
    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    private ITuanAccountService accountService;

    @GetMapping("/forgot1")
    public String show() {
        return "Tuan_account/forgot";
    }

    @GetMapping("/forgot")
    public String forgot(@RequestParam String email) throws MessagingException {
        List<Account> accountList = accountService.getList();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        String subject = "Đổi mật khẩu";
        String url;
        String buttonText = "Đổi mật khẩu ngay";
        String htmlButton;
        for (Account account : accountList) {
            if (account.getEmailClient().equals(email)) {
                subject = "Đổi mật khẩu";
                url = "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
                        "<head>\n" +
                        "<!--[if gte mso 9]>\n" +
                        "<xml>\n" +
                        "  <o:OfficeDocumentSettings>\n" +
                        "    <o:AllowPNG/>\n" +
                        "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
                        "  </o:OfficeDocumentSettings>\n" +
                        "</xml>\n" +
                        "<![endif]-->\n" +
                        "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
                        "  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
                        "  <title></title>\n" +
                        "  \n" +
                        "    <style type=\"text/css\">\n" +
                        "      @media only screen and (min-width: 620px) {\n" +
                        "  .u-row {\n" +
                        "    width: 600px !important;\n" +
                        "  }\n" +
                        "  .u-row .u-col {\n" +
                        "    vertical-align: top;\n" +
                        "  }\n" +
                        "\n" +
                        "  .u-row .u-col-100 {\n" +
                        "    width: 600px !important;\n" +
                        "  }\n" +
                        "\n" +
                        "}\n" +
                        "\n" +
                        "@media (max-width: 620px) {\n" +
                        "  .u-row-container {\n" +
                        "    max-width: 100% !important;\n" +
                        "    padding-left: 0px !important;\n" +
                        "    padding-right: 0px !important;\n" +
                        "  }\n" +
                        "  .u-row .u-col {\n" +
                        "    min-width: 320px !important;\n" +
                        "    max-width: 100% !important;\n" +
                        "    display: block !important;\n" +
                        "  }\n" +
                        "  .u-row {\n" +
                        "    width: 100% !important;\n" +
                        "  }\n" +
                        "  .u-col {\n" +
                        "    width: 100% !important;\n" +
                        "  }\n" +
                        "  .u-col > div {\n" +
                        "    margin: 0 auto;\n" +
                        "  }\n" +
                        "}\n" +
                        "body {\n" +
                        "  margin: 0;\n" +
                        "  padding: 0;\n" +
                        "}\n" +
                        "\n" +
                        "table,\n" +
                        "tr,\n" +
                        "td {\n" +
                        "  vertical-align: top;\n" +
                        "  border-collapse: collapse;\n" +
                        "}\n" +
                        "\n" +
                        "p {\n" +
                        "  margin: 0;\n" +
                        "}\n" +
                        "\n" +
                        ".ie-container table,\n" +
                        ".mso-container table {\n" +
                        "  table-layout: fixed;\n" +
                        "}\n" +
                        "\n" +
                        "* {\n" +
                        "  line-height: inherit;\n" +
                        "}\n" +
                        "\n" +
                        "a[x-apple-data-detectors='true'] {\n" +
                        "  color: inherit !important;\n" +
                        "  text-decoration: none !important;\n" +
                        "}\n" +
                        "\n" +
                        "table, td { color: #000000; } #u_body a { color: #0000ee; text-decoration: underline; } @media (max-width: 480px) { #u_content_image_1 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_image_1 .v-src-width { width: auto !important; } #u_content_image_1 .v-src-max-width { max-width: 50% !important; } #u_content_heading_1 .v-container-padding-padding { padding: 10px 10px 20px !important; } #u_content_heading_1 .v-font-size { font-size: 22px !important; } #u_content_heading_2 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_text_2 .v-container-padding-padding { padding: 10px !important; } #u_content_heading_3 .v-container-padding-padding { padding: 10px !important; } #u_content_button_1 .v-container-padding-padding { padding: 30px 10px 40px !important; } #u_content_button_1 .v-size-width { width: 65% !important; } #u_content_social_1 .v-container-padding-padding { padding: 40px 10px 10px !important; } #u_content_text_deprecated_1 .v-container-padding-padding { padding: 10px 10px 20px !important; } #u_content_image_2 .v-container-padding-padding { padding: 20px 10px 40px !important; } }\n" +
                        "    </style>\n" +
                        "  \n" +
                        "  \n" +
                        "\n" +
                        "<!--[if !mso]><!--><link href=\"https://fonts.googleapis.com/css?family=Raleway:400,700&display=swap\" rel=\"stylesheet\" type=\"text/css\"><!--<![endif]-->\n" +
                        "\n" +
                        "</head>\n" +
                        "\n" +
                        "<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #f9f9ff;color: #000000\">\n" +
                        "  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
                        "  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
                        "  <table id=\"u_body\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #f9f9ff;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                        "  <tbody>\n" +
                        "  <tr style=\"vertical-align: top\">\n" +
                        "    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                        "    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #f9f9ff;\"><![endif]-->\n" +
                        "    \n" +
                        "  \n" +
                        "  \n" +
                        "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                        "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                        "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                        "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                        "      \n" +
                        "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #ffffff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
                        "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                        "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;\">\n" +
                        "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
                        "  \n" +
                        "<table id=\"u_content_image_1\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:60px 10px 10px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                        "      \n" +
                        "      <img align=\"center\" border=\"0\" src=\"https://cdn.templates.unlayer.com/assets/1676547950700-Asset%201.png\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 35%;max-width: 203px;\" width=\"203\" class=\"v-src-width v-src-max-width\"/>\n" +
                        "      \n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_heading_1\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 10px 30px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                        "    <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: center; word-wrap: break-word; font-size: 28px; font-weight: 400;\"><strong>Forget password ?</strong></h1>\n" +
                        "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "  </div>\n" +
                        "  \n" +
                        "\n" +
                        "\n" +
                        "  \n" +
                        "  \n" +
                        "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                        "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                        "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                        "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                        "      \n" +
                        "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #ffffff;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                        "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                        "  <div style=\"background-color: #ffffff;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                        "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                        "  \n" +
                        "<table id=\"u_content_heading_2\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 60px 10px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                        "    <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: left; word-wrap: break-word; font-size: 16px; font-weight: 400;\">If you've lost your password or wish to reset it, use the link below to get started:</h1>\n" +
                        "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_text_2\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 60px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <div class=\"v-font-size\" style=\"font-size: 14px; color: #1386e5; line-height: 140%; text-align: left; word-wrap: break-word;\">\n" +
                        "    <p style=\"line-height: 140%;\"><span style=\"text-decoration: underline; line-height: 19.6px;\"><span style=\"line-height: 19.6px;\"><strong>Xác nhận thay đổi mật khẩu</strong></span></span></p>\n" +
                        "  </div>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_heading_3\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 60px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
                        "    <h1 class=\"v-font-size\" style=\"margin: 0px; line-height: 140%; text-align: left; word-wrap: break-word; font-size: 14px; font-weight: 400;\">Bạn đã thực hiện hành động đặt lại mật khẩu. Vui lòng nhấn vào link bên dưới để tiếp tục..</h1>\n" +
                        "  <!--[if mso]></td></tr></table><![endif]-->\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_button_1\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 40px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <!--[if mso]><style>.v-button {background: transparent !important;}</style><![endif]-->\n" +
                        "<div align=\"center\">\n" +
                        "  <!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"https://www.unlayer.com\" style=\"height:37px; v-text-anchor:middle; width:220px;\" arcsize=\"67.5%\"  stroke=\"f\" fillcolor=\"#fdb441\"><w:anchorlock/><center style=\"color:#000000;\"><![endif]-->\n" +
                        "    <a href=\"http://localhost:8080/account/formPassword/\""+account.getId()+" target=\"_blank\" class=\"v-button v-size-width v-font-size\" style=\"box-sizing: border-box;display: inline-block;text-decoration: none;-webkit-text-size-adjust: none;text-align: center;color: #000000; background-color: #fdb441; border-radius: 25px;-webkit-border-radius: 25px; -moz-border-radius: 25px; width:38%; max-width:100%; overflow-wrap: break-word; word-break: break-word; word-wrap:break-word; mso-border-alt: none;font-size: 14px;\">\n" +
                        "      <span style=\"display:block;padding:10px 20px;line-height:120%;\"><span style=\"line-height: 16.8px;\">Đặt lại mật khẩu</span></span>\n" +
                        "    </a>\n" +
                        "    <!--[if mso]></center></v:roundrect><![endif]-->\n" +
                        "</div>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "  </div>\n" +
                        "  \n" +
                        "\n" +
                        "\n" +
                        "  \n" +
                        "  \n" +
                        "<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
                        "  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
                        "    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
                        "      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
                        "      \n" +
                        "<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
                        "<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
                        "  <div style=\"height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
                        "  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
                        "  \n" +
                        "<table id=\"u_content_social_1\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:40px 10px 10px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "<div align=\"center\">\n" +
                        "  <div style=\"display: table; max-width:167px;\">\n" +
                        "  <!--[if (mso)|(IE)]><table width=\"167\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"border-collapse:collapse;\" align=\"center\"><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse; mso-table-lspace: 0pt;mso-table-rspace: 0pt; width:167px;\"><tr><![endif]-->\n" +
                        "  \n" +
                        "    \n" +
                        "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
                        "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
                        "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                        "        <a href=\"https://www.facebook.com/unlayer\" title=\"Facebook\" target=\"_blank\">\n" +
                        "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded/facebook.png\" alt=\"Facebook\" title=\"Facebook\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                        "        </a>\n" +
                        "      </td></tr>\n" +
                        "    </tbody></table>\n" +
                        "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "    \n" +
                        "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
                        "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
                        "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                        "        <a href=\"https://twitter.com/unlayerapp\" title=\"Twitter\" target=\"_blank\">\n" +
                        "          <img src=\"http://https://cdn.tools.unlayer.com/social/icons/rounded/twitter.png\" alt=\"Twitter\" title=\"Twitter\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                        "        </a>\n" +
                        "      </td></tr>\n" +
                        "    </tbody></table>\n" +
                        "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "    \n" +
                        "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 10px;\" valign=\"top\"><![endif]-->\n" +
                        "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 10px\">\n" +
                        "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                        "        <a href=\"https://www.linkedin.com/company/unlayer/mycompany/\" title=\"LinkedIn\" target=\"_blank\">\n" +
                        "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded/linkedin.png\" alt=\"LinkedIn\" title=\"LinkedIn\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                        "        </a>\n" +
                        "      </td></tr>\n" +
                        "    </tbody></table>\n" +
                        "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "    \n" +
                        "    <!--[if (mso)|(IE)]><td width=\"32\" style=\"width:32px; padding-right: 0px;\" valign=\"top\"><![endif]-->\n" +
                        "    <table align=\"left\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" width=\"32\" height=\"32\" style=\"width: 32px !important;height: 32px !important;display: inline-block;border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;margin-right: 0px\">\n" +
                        "      <tbody><tr style=\"vertical-align: top\"><td align=\"left\" valign=\"middle\" style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
                        "        <a href=\"https://www.instagram.com/unlayer_official/\" title=\"Instagram\" target=\"_blank\">\n" +
                        "          <img src=\"https://cdn.tools.unlayer.com/social/icons/rounded/instagram.png\" alt=\"Instagram\" title=\"Instagram\" width=\"32\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: block !important;border: none;height: auto;float: none;max-width: 32px !important\">\n" +
                        "        </a>\n" +
                        "      </td></tr>\n" +
                        "    </tbody></table>\n" +
                        "    <!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "    \n" +
                        "    \n" +
                        "    <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_text_deprecated_1\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px 30px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <div class=\"v-font-size\" style=\"font-size: 14px; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
                        "    <p style=\"font-size: 14px; line-height: 170%;\">UNSUBSCRIBE   |   PRIVACY POLICY   |   WEB</p>\n" +
                        "<p style=\"font-size: 14px; line-height: 170%;\"> </p>\n" +
                        "<p style=\"font-size: 14px; line-height: 170%;\">Vui lòng liên hệ với chúng tôi nếu bạn có thắc mắc.</p>\n" +
                        "  </div>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                        "    <tbody>\n" +
                        "      <tr style=\"vertical-align: top\">\n" +
                        "        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
                        "          <span>&#160;</span>\n" +
                        "        </td>\n" +
                        "      </tr>\n" +
                        "    </tbody>\n" +
                        "  </table>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "<table id=\"u_content_image_2\" style=\"font-family:'Raleway',sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
                        "  <tbody>\n" +
                        "    <tr>\n" +
                        "      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:30px 10px 40px;font-family:'Raleway',sans-serif;\" align=\"left\">\n" +
                        "        \n" +
                        "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                        "  <tr>\n" +
                        "    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
                        "      \n" +
                        "      <img align=\"center\" border=\"0\" src=\"\" alt=\"image\" title=\"image\" style=\"outline: none;text-decoration: none;-ms-interpolation-mode: bicubic;clear: both;display: inline-block !important;border: none;height: auto;float: none;width: 100%;max-width: 149px;\" width=\"149\" class=\"v-src-width v-src-max-width\"/>\n" +
                        "      \n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "</table>\n" +
                        "\n" +
                        "      </td>\n" +
                        "    </tr>\n" +
                        "  </tbody>\n" +
                        "</table>\n" +
                        "\n" +
                        "  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
                        "  </div>\n" +
                        "</div>\n" +
                        "<!--[if (mso)|(IE)]></td><![endif]-->\n" +
                        "      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "  </div>\n" +
                        "  \n" +
                        "\n" +
                        "\n" +
                        "    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
                        "    </td>\n" +
                        "  </tr>\n" +
                        "  </tbody>\n" +
                        "  </table>\n" +
                        "  <!--[if mso]></div><![endif]-->\n" +
                        "  <!--[if IE]></div><![endif]-->\n" +
                        "</body>\n" +
                        "\n" +
                        "</html>";
                helper.setTo(email);
                helper.setSubject(subject);
                helper.setText(url,true);
                javaMailSender.send(message);
                return "redirect:/account/forgot1";
            }
        }
        return "redirect:/account/forgot1";
    }

    @GetMapping("formPassword/{id}")
    private String formEditPass(@PathVariable int id, Model model) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        return "Tuan_account/formEditPass";
    }

    @PostMapping("formPassword/changePass")
    private String change(Model model, Account account) {
        Account account1 = accountService.findById(account.getId());
        account1.setPassword(account.getPassword());
        accountService.save(account1);
        return "redirect:/";
    }
}