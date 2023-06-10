package pl.camp.it.tomwodz.businesscard.services;

import org.springframework.stereotype.Service;
import pl.camp.it.tomwodz.businesscard.model.Email;

@Service
public interface ISendEmail {
    void sendEmail(Email email);
}
