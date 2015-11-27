public class MailItem
{
    // String para guardar información sobre el emisor del mail
    private String from;
    // String para guardar información sobre el destinatario del mail
    private String to;
    // String para guardar la información del asunto del mail
    private String subject;
    // String para guardar la información sobre el mensaje enviado
    private String message;
    
    
    /**
     * Crea un objeto de la clase MailItem introduciendo tres parametros para guardar la información sobre
     * quien envia el mensaje, quien lo recibe y el contenido del mismo.
     */
    public MailItem (String from,String to,String subject,String message)
    {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }
    
    /**
     * Devuelve el string introducido en la variable from
     */
    public String getFrom ()
    {
        return from;
    }
    
    /**
     * Devuelve el string introducido en la variable to
     */
    public String getTo ()
    {
        return to;
    }
    
    /**
     * Devuelve el string introducido en la variable subject
     */
    public String getSubject ()
    {
        return subject;
    }
    
    /**
     * Devuelve el string introducido 
     */
    public String getMessage ()
    {
        return message;
    }
    
    /**
     * Imprime por pantalla  tres lineas que muestran las variables de la clase MailItem
     */
    public void print ()
    {
        System.out.println ("From: " + from);
        System.out.println ("To: " + to);
        System.out.println ("Subject: " + subject);
        System.out.println ("Message: " + message);
    }
}
