<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <f:view>
            <h:form id="loginForm">
                <table id="mainTable" border="0" cellpadding="0" cellspacing="0" style="width:800px;">
                    <tr>
                        <td height="600px;" valign="top" background="./img/bg_.jpg" style="background-repeat:no-repeat;">
                            <table id="subTable" width="100%">
                                <tr>
                                    <td style="text-align: center;">
                                        <div style="font-size: 24pt; font-family:  'Droid Sans', sans-serif; ;font-weight: 900; color:#ad051c; margin-bottom: 15px; vertical-align: top; padding-top:30px;">
                                            Ghost Game by Jesús Ramírez Guerrero
                                        </div>
                                    </td> 
                                </tr>

                                <tr>
                                    <td style="text-align: center;">
                                        <h:outputText value="Please input your name: " style="color:white;"/>
                                        <h:inputText value="#{user.name}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <h:commandButton action="login"
                                                         value="Start" />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <input type="button" value="Back" onclick="window.history.back();"/>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </table>  
            </h:form>
        </f:view>
    </body>
</html>