<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
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
                                        <h:commandButton id="btn1" value="Play / Continue" action="login"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <h:commandButton id="btn2" value="Reset game" actionListener="#{game.resetGame}"/> 
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <h:commandButton id="btn3" value="How To Play" action="howto" />
                                    </td>
                                </tr>
                                <tr>
                                    <td style="text-align: center;">
                                        <input id="btn4" type="button" value="About me" onclick="javascript:location.href = 'http://jesusramirezguerrero.wordpress.com';"/>
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