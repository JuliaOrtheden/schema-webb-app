<%@page import="java.util.Date"%>
<%@page import="com.SchemaApp2.model.TimeslotPK"%>
<%@page import="com.SchemaApp2.model.Timeslot"%>
<%@page import="com.SchemaApp2.model.TimeslotFacade"%>
<%@page import="com.SchemaApp2.view.TimeslotController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        TimeslotFacade timeslotFacade = new TimeslotFacade();
        timeslotFacade.bookTimeslot(new Timeslot(new Date(), new Date(), "Grupprum1"));
        
        
        //TimeslotController timeslotController = new TimeslotController();
        //timeslotController.bookTimeslot();
        %>

<%%>
    </body>
</html>
