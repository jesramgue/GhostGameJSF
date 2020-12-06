<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<html>
    <head>
        <title>Ghost Game</title>
    </head>
    <body>
        <table id="mainTable" border="0" cellpadding="0" cellspacing="0" style="width:800px;">
            <tr>
                <td height="600px;" valign="top" background="./img/bg_.jpg" style="background-repeat:no-repeat;">
                    <table id="subTable" width="100%">
                        <tr>
                            <td style="text-align: center;">
                                <div style="font-size: 24pt; color: white; font-family:  'Droid Sans', sans-serif; ;font-weight: 900; color:#ad051c; margin-bottom: 15px; vertical-align: top; padding-top:30px;">
                                    Ghost Game by Jesús Ramírez Guerrero
                                </div>
                            </td> 
                        </tr>
                        <tr>
                            <td style="text-align: center;">
                                <h1 style="display: inline; color: white;">Instructions:</h1> <h2 style="color: white; display: inline">Optimal Ghost</h2>
                            </td>
                        </tr>
                        <tr>
                            <td style="text-align: center;">
                                <p style="color: white;"> 
                                    In the game of Ghost, two players take turns building up an English word from left to right. Each player adds one letter per turn. The goal is to not complete the spelling of a word: if you add a letter that completes a word (of 4+ letters), or if you add a letter that produces a string that cannot be extended into a word, you lose. (Bluffing plays and "challenges" may be ignored for the purpose of this puzzle.)
                                </p>
                                <p style="color: white;">
                                    The computer should play optimally given the attached dictionary. Allow the human to play first. If the computer thinks it will win, it should play randomly among all its winning moves; if the computer thinks it will lose, it should play so as to extend the game as long as possible (choosing randomly among choices that force the maximal game length).
                                </p>
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
    </body>
</html>
