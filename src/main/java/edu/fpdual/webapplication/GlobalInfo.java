package edu.fpdual.webapplication;

public class GlobalInfo {
    /*
     * URL de la aplicacion
     */
    public static final String URL_PROYECTO = "/ProyectoPrueba";
    /*
     * URL de los .jsp
     */
    public static final String URL_JSP = URL_PROYECTO + "/jsp";
    public static final String URL_JSP_HOME = URL_JSP + "/common/home.jsp";
    public static final String URL_JSP_LOGIN = URL_JSP + "/login/login.jsp";
    public static final String URL_JSP_FORMNEWUSER = URL_JSP + "/form/formNewUser.jsp";
    public static final String URL_JSP_NOTIFICATION = URL_JSP + "/notificationTest.jsp";
    public static final String URL_JSP_CONTROLPANEL = URL_JSP + "/admin/controlPanel.jsp";

    /*
     * URL de los servlets
     */
    public static final String URL_SERVLET_ = URL_PROYECTO;
    public static final String URL_SERVLET_LOGIN = URL_SERVLET_ + "/login-servlet";
    public static final String URL_SERVLET_NEWUSER = URL_PROYECTO + "/new-user-servlet";
    public static final String URL_SERVLET_TEST = URL_PROYECTO + "/notification-servlet";

    /*
     * Variables globales
     */
    public static final String URL_WEBTARGET = "http://localhost:8081/webService/webapi/";
    public static final String session = "session";
}
