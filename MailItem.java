public class MailItem
{
    // String para guardar información sobre el emisor del mail
    private String from;
    // String para guardar información sobre el destinatario del mail
    private String to;
    // String para guardar la información sobre el mensaje enviado
    private String message;
    
    /**
     * Crea un objeto de la clase MailItem introduciendo tres parametros para guardar la información sobre
     * quien envia el mensaje, quien lo recibe y el contenido del mismo.
     */
    public MailItem (String xFrom,String xTo,String xMessage)
    {
        from = xFrom;
        to = xTo;
        message = xMessage;
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
        System.out.println ("Message: " + message);
    }
}
