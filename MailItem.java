public class MailItem
{
    //
    private String from;
    //
    private String to;
    //
    private String message;
    
    public MailItem (String xFrom,String xTo,String xMessage)
    {
        from = xFrom;
        to = xTo;
        message = xMessage;
    }
    
    public String getFrom ()
    {
        return from;
    }
    
    public String getTo ()
    {
        return to;
    }
    
    public String getMessage ()
    {
        return message;
    }
    
    public void print ()
    {
        System.out.println ("From: " + from);
        System.out.println ("To: " + to);
        System.out.println ("Message: " + message);
    }
}
