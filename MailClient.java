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
        server = xServer;
        user = xUser;
    }
    
    /**
     * Recupera del servidor el siguiente correo que tenga el usuario y devuelve dicho objeto.
     */
    public MailItem getNextMailItem ()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Recupera del servidor el siguiente correo que tenga el usuario e imprime por pantalla datos
     * de dicho mensaje. Si no hay ningun mensaje muestra una mensaje informando de ello.
     */
    public void printNextMailItem ()
    {
        if (server.howManyMailItems(user) > 0) {
            MailItem mail = server.getNextMailItem(user);
            mail.print();
        }
        else {
            System.out.println("No hay mensajes nuevos");
        }
    }
    
    /**
     * Crea un email basandose en los parametros introducidos y lo envía al servidor asociado a ese cliente.
     */
    public void sendMailItem (String xTo,String xMessage)
    {
        MailItem mail = new MailItem(user, xTo, xMessage);
        server.post(mail);
    }
    
}
