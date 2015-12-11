public class MailClient
{
    // Representa el servidor asociado con el cliente
    private MailServer server;
    // Representa la dirección de correo del usuario que usa ese servidor
    private String user;
    // Guarda la información del último mensaje recibido
    private MailItem lastMail;
    // Guarda el número de spam recibido
    private int spam;
    // Guarda el nº de mensajes enviados
    private int mensajesEnviados;
    // Guarda el nº de mensajes recibidos
    private int mensajesRecibidos;
    // Guarda el nº de caracteres del mail mas largo
    private int longMailCaracteres;
    // guarda información sobre lapersona que envia el mail más largo
    private String longMailUsuario;
    // guarda el porcentaje del spam recibido
    private float porcentaje;
    /**
     * Construye un objeto de la clase MailClient inicializando sus atributos mediante parametros.
     */
    public MailClient (MailServer server,String user)
    {
        this.server = server;
        this.user = user;
        lastMail = null;
        spam = 0;
        mensajesEnviados = 0;
        mensajesRecibidos = 0;
    }

    /**
     * Recupera del servidor el siguiente correo que tenga el usuario y devuelve dicho objeto.
     */
    public MailItem getNextMailItem ()
    {
        MailItem mail = server.getNextMailItem(user);
        if (mail != null) {
            String mensaje = mail.getMessage();
            if (mensaje.contains("trabajo")) {
            }
            else if (mensaje.contains("regalo") || mensaje.contains("promocion")) {
                spam = spam + 1;
                mail = null;
            }
            if (mail != null) {
                lastMail = mail;
            }
            int caracteres = mensaje.length();
            if (caracteres > longMailCaracteres) {
                longMailCaracteres = caracteres;
                longMailUsuario = mail.getFrom();
            } 
        }
        mensajesRecibidos = mensajesRecibidos + 1;
        return mail;
    }

    /**
     * Recupera del servidor el siguiente correo que tenga el usuario e imprime por pantalla datos
     * de dicho mensaje. Si no hay ningun mensaje muestra una mensaje informando de ello.
     */
    public void printNextMailItem ()
    {
        MailItem mail = getNextMailItem();
        if (mail != null) {     
            mail.print();
        }
        else {   
            if (spam > 0) {
                System.out.println("Se ha recibido spam");
                mensajesRecibidos = mensajesRecibidos + 1;
            }
            else {
                System.out.println("No hay mensajes nuevos"); 
            }
        }
    }

    /**
     * Crea un email basandose en los parametros introducidos y lo envía al servidor asociado a ese cliente.
     */
    public void sendMailItem (String to,String subject,String message)
    {
        MailItem mail = new MailItem(user, to, subject, message);
        mensajesEnviados = mensajesEnviados + 1;
        server.post(mail);
    }

    /**
     * Muestra por pantalla cuantos emails tiene el usuario en el servidor
     */
    public void howManyMailItems()
    {
        System.out.println("Hay " + server.howManyMailItems(user) + " mensajes disponibles");
    }

    /**
     * Obtiene del servidor el siguiente mensaje del usuario y responde automáticamente al emisor de este
     */
    public void getNextMailItemAndSendAutomaticRespond ()
    {
        MailItem mail = getNextMailItem();
        if (mail != null)
        {
            sendMailItem
            (
                mail.getFrom(), 
                "RE: " + mail.getSubject(),
                "Estoy fuera de la oficina \n" + mail.getMessage()
            );
            lastMail = mail;
        }
    }

    /**
     * Muestra por pantalla las veces que queramos el último email enviado a la cuenta de usuario, 
     * informando por pantalla en el caso de no tener ninguno
     */
    public void getLastMail ()
    {
        if (lastMail != null) {
            lastMail.print();
        }
        else {
            System.out.println ("No hay último mensaje");
        }
    }

    /**
     * Muestra las estadisticas de los mensajes relacionados con el usuario
     */
    public void showStats()
    {
        if (mensajesRecibidos == 0) {
            porcentaje = 0f;
        }
        else {
            porcentaje = spam / mensajesRecibidos;
        }
        System.out.println("Mensajes enviados: " + mensajesEnviados);
        System.out.println("Mensajes recibidos: " + mensajesRecibidos);
        System.out.println("Spam recibido: " + spam);
        System.out.println("Porcentaje de spam: " + porcentaje + "%");
        System.out.println("Nº de caracteres del mail más largo recibido: " + longMailCaracteres);
        System.out.println("Persona que te envio el mail más largo: " + longMailUsuario);
    }
}
