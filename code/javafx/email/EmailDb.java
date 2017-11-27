import java.util.ArrayList;
import java.util.List;

public class EmailDb {

    private List<EmailMessage> emails;

    public EmailDb() {
        emails = new ArrayList<>();
        emails.add(new EmailMessage("alice@aol.com", "bob@aol.com", "Coolness",
                                    "We're on the coolest email domain!"));
        emails.add(new EmailMessage("chen@gmail.com", "druhv@gmail.com","NSA",
                                    "Google noes all are bidness."));
        emails.add(new EmailMessage("ellie@hotmail.com", "faruq@hotmail.com",
                                    "Cold",
                                    "Definitely not hot after MS bought it."));
        emails.add(new EmailMessage("gerd@msn.com", "harsitha@msn.com","Default",
                                    "Srsly?"));
    }

    public List<EmailMessage> getEmails() {
        return emails;
    }
}
