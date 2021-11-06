package br.com.cadastro.cliente.controller;

import br.com.cadastro.cliente.domain.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/email")
@CrossOrigin("*")
@Controller
public class EmailSender {

    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/fale-conosco-professor")
    public @ResponseBody
    Details sendMailProfessor(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", details.getName());
        model.put("age", details.getAge());
        model.put("country", details.getCountry());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("professor", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html, true);
            helper.setSubject("Fale Conosco - Udeyou");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/fale-conosco-usuario")
    public @ResponseBody
    Details sendMailUser(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name", details.getName());
        model.put("age", details.getAge());
        model.put("country", details.getCountry());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("usuario", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html, true);
            helper.setSubject("Fale Conosco - Udeyou");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

    @RequestMapping("/cadastro")
    public @ResponseBody
    Details confirm(@RequestBody Details details) throws Exception {

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("msgUm", details.getName());
        model.put("msgDois", details.getAge());
        model.put("msgTres", details.getCountry());

        Context context = new Context();
        context.setVariables(model);
        String html = templateEngine.process("confirm", context);

        try {
            helper.setTo(details.getEmail());
            helper.setText(html, true);
            helper.setSubject("Bem vindo(a) à Udeyou");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }
}
