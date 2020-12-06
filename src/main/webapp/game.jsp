<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="https://ajax4jsf.dev.java.net/ajax" prefix="a4j"%>
<html>
    <head>
        <script language="javascript" type="text/javascript" src="./js/UI.js"/></script>
    <title>Ghost Game</title>
</head>
<body> 
    <f:view>
        <h:form id="loginForm">
            <table id="mainTable" border="0" cellpadding="0" cellspacing="0" style="width:800px;">
                <tr>
                    <td height="600px;" valign="top" background="./img/bg.jpg" style="background-repeat:no-repeat;">
                        <table id="subTable" width="100%">
                            <tr>
                                <td style="text-align: center;">
                                    <div style="font-size: 24pt; font-family:  'Droid Sans', sans-serif; ;font-weight: 900; color:#ad051c; margin-bottom: 15px; vertical-align: top; padding-top:30px;">
                                        Ghost Game by Jesús Ramírez Guerrero
                                    </div>
                                </td> 
                            </tr>

                            <tr>
                                <td style="text-align: center; padding: 10px;">
                                    <h:outputText value="Wellcome: #{user.name}, please type a letter and press change turn." />
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <h:inputText style="width:20px;" id="humanWord"  value="#{game.lsHumanWord}" disabled="#{game.disabledInput eq 'true'}" onkeyup="limitText(this, 1);"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <h:commandButton  id="change" value="#{game.commandButtonName}"  actionListener="#{game.changeTurn}">
                                        <a4j:support event="onclick" reRender="subTable" />
                                    </h:commandButton>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    Word in play:
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center; font-size: 20pt; font-family:  'Droid Sans', sans-serif; ;font-weight: 600; color:#05ad1c; margin-bottom: 15px; vertical-align: top;">
                                    <h:outputText  id="word" value="#{game.wordInPlay}"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <h:outputText id="computerSays" value="#{game.computerWord}"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <h:outputText id="winner" value="#{game.isWinner}"/>
                                </td>
                            </tr>
                            <tr>
                                <td style="text-align: center;">
                                    <h:commandButton id="btnReset" value="Reset game" actionListener="#{game.resetGame}"/> 
                                    <h:commandButton id="btnMenu" value="Main menu" action="index"/>
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
