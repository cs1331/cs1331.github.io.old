/**
 * An oversimplified email message class.
 */
public class EmailMessage {

    private String from;
    private String subject;
    private String to;
    private String body;

    public EmailMessage(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getFrom() { return from; }
    public String getSubject() { return subject; }
    public String getTo() { return to; }
    public String getBody() { return body; }

}
