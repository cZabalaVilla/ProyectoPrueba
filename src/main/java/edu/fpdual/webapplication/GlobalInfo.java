package edu.fpdual.webapplication;

public class GlobalInfo {
    /*
     * URL de la aplicacion
     */
    public static final String URL_PROYECTO = "/ProyectoPrueba";
    /*
     * URL de los .jsp
     */
    public static final String URL_INDEX = URL_PROYECTO + "/";
    public static final String URL_JSP = URL_PROYECTO + "/jsp";
    public static final String URL_JSP_HOME = URL_JSP + "/common/home.jsp";
    public static final String URL_JSP_LOGIN = URL_JSP + "/login/login.jsp";
    public static final String URL_JSP_FORMNEWUSER = URL_JSP + "/login/newUser.jsp";
    public static final String URL_JSP_NOTIFICATION = URL_JSP + "/notificationTest.jsp";
    public static final String URL_JSP_CONTROLPANEL = URL_JSP + "/admin/controlPanel.jsp";
    public static final String URL_JSP_DENEGATEACCES = URL_JSP + "/redir/denegateAccess.jsp";
    public static final String URL_JSP_NEWADMIN = URL_JSP + "/admin/adminManager.jsp";


    /*
     * URL de los servlets
     */
    public static final String URL_SERVLET_ = URL_PROYECTO;
    public static final String URL_SERVLET_LOGIN = URL_SERVLET_ + "/login-servlet";
    public static final String URL_SERVLET_NEWUSER = URL_SERVLET_ + "/new-user-servlet";
    public static final String URL_SERVLET_TEST = URL_SERVLET_ + "/notification-servlet";
    public static final String URL_SERVLET_LOGOUT = URL_SERVLET_ + "/logout-servlet";

    /*
     * Variables globales
     */
    public static final String URL_WEBTARGET = "http://localhost:8081/webService/webapi/";

    public static final String session = "session";
    public static final String webPath = "http://localhost:8081/webService/webapi/";


    /*
    * import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class URLHashExample {
    public static void main(String[] args) {
        String url = "https://www.example.com/page?id=123";
        String hash = calcularHash(url);

        System.out.println("URL original: " + url);
        System.out.println("Hash: " + hash);
    }

    public static String calcularHash(String url) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(url.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}*/
}
