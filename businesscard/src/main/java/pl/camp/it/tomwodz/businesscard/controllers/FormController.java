package pl.camp.it.tomwodz.businesscard.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.tomwodz.businesscard.model.Email;
import pl.camp.it.tomwodz.businesscard.services.ISendEmail;

@Controller
public class FormController {

    @Autowired
    ISendEmail sendEmail;

    @Autowired
    Email email;

    @RequestMapping(path = "/formSend", method = RequestMethod.GET)
    public String formSend(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("emailRecipient", email.getEmailRecipient());
        model.addAttribute("emailSubject", email.getEmailSubject());
        model.addAttribute("emailContent", email.getEmailContent());
        model.addAttribute("emailAuthor", email.getEmailAuthor());
        model.addAttribute("emailAuthorAddressEmail", email.getEmailAuthorAddressEmail());
        if (!email.getEmailRecipient().equals("") &&
                !email.getEmailSubject().equals("") &&
                !email.getEmailContent().equals("")
        ) {
            sendEmail.sendEmail(email);
        }
        return "redirect:form";
    }

}
