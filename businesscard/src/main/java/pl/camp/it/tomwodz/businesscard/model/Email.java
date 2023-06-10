package pl.camp.it.tomwodz.businesscard.model;

import org.springframework.stereotype.Component;

@Component
public class Email {

    private String emailRecipient;
    private String emailSubject;
    private String emailContent;
    private String emailAuthor;

    private String emailAuthorAddressEmail;

    public Email(String emailRecipient, String emailSubject, String emailContent, String emailAuthor, String emailAuthorAddressEmail) {
        this.emailRecipient = emailRecipient;
        this.emailSubject = emailSubject;
        this.emailContent = emailContent;
        this.emailAuthor = emailAuthor;
        this.emailAuthorAddressEmail = emailAuthorAddressEmail;
    }

    public Email() {
    }

    public String getEmailRecipient() {
        return emailRecipient;
    }

    public void setEmailRecipient(String emailRecipient) {
        this.emailRecipient = emailRecipient;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getEmailAuthor() {
        return emailAuthor;
    }

    public void setEmailAuthor(String emailAuthor) {
        this.emailAuthor = emailAuthor;
    }

    public String getEmailAuthorAddressEmail() {
        return emailAuthorAddressEmail;
    }

    public void setEmailAuthorAddressEmail(String emailAuthorAddressEmail) {
        this.emailAuthorAddressEmail = emailAuthorAddressEmail;
    }
}
