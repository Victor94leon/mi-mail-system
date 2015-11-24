public class MailClient
{
    // Representa el servidor asociado con el cliente
    private MailServer server;
    // Representa la dirección de correo del usuario que usa ese cliente
    private String user;
    
    /**
     * Construye un objeto de la clase MailClient inicializando sus atributos mediante parametros.
     */
    public MailClient (MailServer xServer,String xUser)
    {
    }
    
    /**
     * Recupera del servidor el siguiente correo que tenga el usuario y devuelve dicho objeto.
     */
    public MailItem getNextMailItem ()
    {
    }
    
    /**
     * Recupera del servidor el siguiente correo que tenga el usuario e imprime por pantalla datos
     * de dicho mensaje. Si no hay ningun mensaje muestra una mensaje informando de ello.
     */
    public void printNextMailItem ()
    {
    }
    
    /**
     * Crea un email basandose en los parametros introducidos y lo envía al servidor asociado a ese cliente.
     */
    public void sendMailItem (String xTo,String xMessage)
    {
    }
    
}
