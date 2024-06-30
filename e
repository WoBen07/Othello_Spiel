[33mcommit 101bb2ba856c2bc3f314da573238dc3da927e93b[m[33m ([m[1;36mHEAD[m[33m -> [m[1;32mbranch[m[33m, [m[1;31morigin/branch[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 16:32:51 2024 +0200

    SIZE_X und SIZE_Y umbenannt in ROWS und COLS

[33mcommit caccfbce102332c0649311e8452f9988bed35088[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 16:31:48 2024 +0200

    Klassenkonstanten SIZE_X und SIZE_Y zur Beschreibung der Boardgröße (also der Felderanzahl in x- bzw. y-Richtung) deklariert

[33mcommit 7f92a30ac79707e4a396c902b9b64374bf035d8b[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 16:18:22 2024 +0200

    running-Attriut in BoardModel hinzugefügt

[33mcommit 996d07e11e8b125bba7973328fb8493f536479ce[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 15:59:37 2024 +0200

    GUI wird jetzt geupdated, indem es sich als PropertyChangeListener beim Model angemeldet hat

[33mcommit 7d7154be34097bcb4b071c8bbcac380de45b650f[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 15:42:37 2024 +0200

    fill-Methode in Piece (ursprünglich Occupation) nutzt jetzt die fill Methode von Arrays

[33mcommit 72e498564ee70f5860d023d95840c922d5b294d2[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 15:40:51 2024 +0200

    In BoardModel geben die getter nur noch Kopien zurück und Änderungen werden über die Setter gemacht (bzw. in den Settern direkt über das Attribut)

[33mcommit 62c9445630088fe4f5f106812e869c05f9ceb151[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Sun Jun 30 15:11:03 2024 +0200

    PropertyChangeSupport (java.beans) angefangen einzurichten, getPieceFormation von boardModel returned jetzt eine Kopie und nicht mehr das Original

[33mcommit fba23c6b3cf5c0ad0b160d45749f3e264be57891[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 26 17:37:09 2024 +0200

    Occupation umbenannt in Piece (und Attribut- und Methodennamen entsprechend angepasst)

[33mcommit 74e5c0869b4e03d7ef73851bda1482d427fe420e[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 26 16:18:03 2024 +0200

    Wenn ein Zug ausgeführt wird, wird passPlayed false gesetzt

[33mcommit 9718f6cfbf374042b2d820f265f62d2b90180e36[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 26 16:16:42 2024 +0200

    legalMovesExists gefixed und in hasLegalMove umbenannt / Beim ersten Passen wird jetzt auch schon abgefragt, ob der nächste Spieler einen legalen Move hat und dann ggf. das Spiel beendet

[33mcommit 057427a9a2bf300c4bd395c73d8e1ef566360cda[m[33m ([m[1;31morigin/master[m[33m, [m[1;31morigin/HEAD[m[33m, [m[1;32mmaster[m[33m)[m
Merge: bd93c14 a67fdbd
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Wed Jun 26 15:47:19 2024 +0200

    Merge pull request #23 from WoBen07/branch
    
    Branch

[33mcommit a67fdbd9e68b7e90a1a397ea40321157ca678d68[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 26 15:43:58 2024 +0200

    Zweite Überarbeitung von letztem Commit

[33mcommit afe86a203bf27ccfcea1e369946715a8cc18ec88[m[33m ([m[1;31morigin/flipOccupation_Implementierung_und_etc[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 26 15:14:27 2024 +0200

    Erste Überarbeitungen von letztem Commit

[33mcommit e85cef94623ae377d211fb7be24f88313e195a4d[m
Author: Michael58432 <Huber.Michael584@gmail.com>
Date:   Wed Jun 26 08:28:25 2024 +0200

    onField methode vereinfacht (wiederholender code bei if else vereinfacht zu isDarksturn ? true : false) / flipOccupations integriert / updateLegalMove integriert und implementierungen vereinfacht, updatet jetzt eine Klassenvariable boolean[][] 'legalMoves' da sonst die flipOccupation methode unnoetig oft aufgerufen werden muesste und diese sehr aufwendig ('viel' rechenleistung benoetigt) / color zu noOccupationColor geeandert / in othelloController statt abfage jedes einzelnen feldes ob irgendein feld mit einem legalem move exestiert, implementierung eines legalMoveExists: Boolean in BoardModel / zeigt jetzt in der farbe blau die moeglichen validen zuege an

[33mcommit bd93c14e2a32da328f79868d6cc6d6c29eed3ac4[m
Merge: 6092f7d dcc72e7
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Fri Jun 21 14:56:16 2024 +0200

    Merge pull request #20 from WoBen07/branch
    
    Branch

[33mcommit dcc72e7418801abaabb439c494f9f5deed44cae3[m
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Fri Jun 21 14:53:06 2024 +0200

    alle Moves wieder legal gemacht

[33mcommit 0eb818ed01e6763097e89e1525ae07f75e88a7ab[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 14:49:04 2024 +0200

    Aufräumarbeiten vom letzten Commit

[33mcommit e59ddc9322323635a0558648a9996855ef673594[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 13:19:44 2024 +0200

    Aktualisierung von Model und View nach Anklicken eines Felder angepasst, Passen grob implementiert

[33mcommit c02237a44f6955a494a733f7b6eacf6ff6b987d1[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 11:56:58 2024 +0200

    Formänderung im Code

[33mcommit af6eb47fd56913faa9474e7e7c9bb12b6fa8a70c[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 11:55:09 2024 +0200

    Occupations in DARK und LIGHT statt BLACK und WHITE umbenannt

[33mcommit 70baa9618a7af915929678917c4ae5cd0e3cc2a4[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 11:51:53 2024 +0200

    getValidMoves-Methode in getLegalMoves umbenannt

[33mcommit 30a285a710cfe39b236ac25a199db785a9929571[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 11:45:25 2024 +0200

    BoardModel-Methode flipOccupations leer integriert, muss noch konkret implementiert werden

[33mcommit 85751aa93ed4f2a13e6c9d4c27ed8d35c8eea8fb[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 11:22:57 2024 +0200

    Methodenkopf getValidMoves-Methode von BoardView integriert, muss noch implementiert werden, im Moment sind alle Moves valid

[33mcommit 5a54eadb55e86e4f39b6f3c1336a8467c118d180[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 10:48:53 2024 +0200

    Initialisierung von View und Model korrigiert

[33mcommit 632fc2b88d9d6b18e65091ae98fd0d7a324d43d9[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 10:43:20 2024 +0200

    fill- und startOccupations-Methode für Occupation hinzugefügt, Erstellen eines OthelloControllers initialisiert jetzt das GUI und das Board

[33mcommit 3af8ef0c07efbab429b00dcc35e1eada860d8b51[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 10:24:40 2024 +0200

    BoardModel-Konstruktor hat jetzt Occupations als Eingabeparameter und erzeugt FieldModels entsprechend

[33mcommit 0c158f309abbdcf3bf6974ba7434642f16d97ac7[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 21 10:14:37 2024 +0200

    controller-Attribut in OthelloGUI ausgelagert, GUI übergibt sich selbst jetzt an seinen BoardView

[33mcommit 6092f7dd061505870617788cb1411ac7da23f5f4[m
Merge: 33dba85 ceeea90
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Thu Jun 20 23:42:45 2024 +0200

    Merge pull request #17 from WoBen07/branch
    
    Branch

[33mcommit ceeea90daf0484e6ab124e1e4510cf21f36f1626[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Thu Jun 20 23:40:50 2024 +0200

    Kleinere Anpassungen nach letztem Commit

[33mcommit b9cb38ba85595d5e2fd6bcbfe32c3735a5b48d06[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Thu Jun 20 23:34:07 2024 +0200

    setOccupation-Methode in FieldView ändert jetzt auch die Farbe des FieldViews

[33mcommit 71b33ee95d701d5abee31fe32d8a0ea6b2168de0[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Thu Jun 20 23:32:37 2024 +0200

    FieldViews kriegen jetzt statt eines Controllers ihren zugehörigen BoardView übergeben

[33mcommit 744f257f8f8419ec783cfdbd03bf14aecfb2f541[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Thu Jun 20 23:22:47 2024 +0200

    Hinzufügen FieldViews im BoardView-Konstruktor optimiert, checkFieldViewOccupations-Methode korrigiert, Occupation-Enum Klassenmethode zum Erstellen eines 2D-Arrays implementiert

[33mcommit c4ecb2d2846aa0df6b81d42e3ab263e29ad79528[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Thu Jun 20 22:26:38 2024 +0200

    BoardView-Attribute fieldViewOccupations und controller mit Checkern, Gettern und Settern integriert

[33mcommit 33dba850b873a01dd7092550c6471483c4ec420a[m
Merge: 074f4dd 52f2316
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Wed Jun 19 16:43:24 2024 +0200

    Merge pull request #16 from WoBen07/UML
    
    Uml

[33mcommit 52f2316f5732c6412dbf7df63b75be4b97e79ce2[m[33m ([m[1;31morigin/UML[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 16:41:33 2024 +0200

    altes UML gelöscht

[33mcommit 8f65da33df765aca8f6bf5670b6740f1a17ece57[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 16:40:27 2024 +0200

    UML erstellt

[33mcommit b313d3671a166e470578bc5ffecfa0fe76cc04ee[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 15:48:42 2024 +0200

    Neue Dateien erstellt

[33mcommit 074f4dd6aa4f35278d574f8964d977e004f98938[m
Merge: 42a5f58 e6bdc78
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Wed Jun 19 15:28:14 2024 +0200

    Merge pull request #14 from WoBen07/branch
    
    Branch

[33mcommit e6bdc781fd7ccd4d9df0521f8ffa9f6a385db096[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 15:09:20 2024 +0200

    Controller-Methode onField überarbeitet

[33mcommit f72871cb21b15c65251f04b820f29b64b5f7d3e0[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 15:02:56 2024 +0200

    FieldViews jetzt mit richtiger Farbe für übergebene Occupation konstruiert

[33mcommit 2f1274b78a2f03fcecd7905d84c5177c373aaa4a[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 15:01:28 2024 +0200

    UML Othello MVC aktualisiert

[33mcommit 2c6ee9ab67e7889a63b62051e73ab3a7d3d80190[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 19 14:22:22 2024 +0200

    Methoden im Controller aufgeteilt, Turns werden nach Feldauswahl geswitched

[33mcommit cde8740135f20342094d9a135bac1065878109e9[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Mon Jun 17 20:21:32 2024 +0200

    Controller updated jetzt direkt den View, dadurch flüssiger

[33mcommit 2c03cdf80b2c9d64781478f6c16a1f7b4188e442[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Mon Jun 17 20:04:51 2024 +0200

    Felder wählbar, aber noch buggy

[33mcommit ee56e6ee937460da4d8712a448ef97be4ea09773[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Mon Jun 17 19:03:15 2024 +0200

    Controller nun alleine für Model-Aktualisierung zuständig, OthelloModel zusammengefasst in BoardModel

[33mcommit 3887ce566088a2d8f8716fa308523fb9b556e2b3[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Mon Jun 17 15:42:43 2024 +0200

    neuen Ansatz für MVC begonnen zu implementieren

[33mcommit c35e8fd531ab4d356e60f43e30c4393de1ae19b4[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Mon Jun 17 14:59:55 2024 +0200

    GUI-Aktualisierung vorläufig implementiert

[33mcommit 4e227436b0c229bb37166c7f8fcfaa75584e0210[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 22:20:41 2024 +0200

    UML zum ersten (unvollständigen) Entwurf für das MVC-Schema erstellt, Beziehungen müssen sowohl in UML als auch in der Implementierung noch überarbeitet werden

[33mcommit d2be3965286eb74d806621251a3920cafd6f0d0c[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 21:54:21 2024 +0200

    Model grundlegend implementiert

[33mcommit 97ac4f20621b65a1d54b73e6ef53da2fe3b8658f[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 21:27:31 2024 +0200

    pngs von weißen und schwarzen Kreisen gelöscht, da nur vorübergehend

[33mcommit 6530ce32484bad27239358413690a82f3a06e3a0[m[33m ([m[1;31morigin/main[m[33m, [m[1;31morigin/View[m[33m, [m[1;31morigin/Main-Implementierung[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 21:20:39 2024 +0200

    Controller grob implementiert

[33mcommit d39afe153b225dbd6a4ea5410203026837656593[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 21:01:36 2024 +0200

    Visualisierung der Occupation vorläufig mit Hintergrundfarbe implementiert

[33mcommit 77e69f20445a7b9ae63fda6a293aee10c91f5bf6[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 20:50:30 2024 +0200

    Occupation-Enum implementiert

[33mcommit ac2214c34c84d09c0f7a27205bb3e102ec066461[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 20:36:05 2024 +0200

    Änderungen am UML

[33mcommit 0be6e78a5ef0dcaa4601efec4e82389d64d8904c[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 20:35:09 2024 +0200

    init

[33mcommit 42a5f58e212ba4146570e8b0ea320e5be1c07cb6[m[33m ([m[1;31morigin/Model[m[33m, [m[1;31morigin/Controller[m[33m)[m
Merge: ed8eca0 4b020cf
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Fri Jun 14 20:24:23 2024 +0200

    Merge pull request #10 from WoBen07/modelMVC
    
    Model mvc

[33mcommit 4b020cfa6301d68b9681e700424e5efff4880f5b[m[33m ([m[1;31morigin/modelMVC[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 20:01:08 2024 +0200

    vorübergehend Implementierung der Felder ohne Icons

[33mcommit c17a09508ea356682ce57b9c96ca0190ea7bbcb7[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 19:53:36 2024 +0200

    Spielsteine versucht durch Image-File zu implementieren

[33mcommit 7c8f143dc91f92c73d7092ca45f10a9efdc3a6e0[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 19:03:40 2024 +0200

    View grundlegend implementiert

[33mcommit a9b2ddaf372d2c2954f15bae859eabb261319451[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 18:38:44 2024 +0200

    grundsätzlicher Neustart

[33mcommit bd219eb40208a2695e8f0958c6605b4837eae5a9[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Fri Jun 14 18:26:54 2024 +0200

    MVC in UML modelliert

[33mcommit ed8eca09bde8db40a86ae377746ffce8e41ef5de[m
Merge: 96c5a05 6f5d763
Author: Paul Schweizer <pschweizer0711@gmail.com>
Date:   Wed Jun 12 23:29:45 2024 +0200

    Merge pull request #8 from WoBen07/Grundgerüst
    
    Paul hat Grundgerüst implementiert und UML entsprechend aktualisiert

[33mcommit 6f5d763a7c1964dd574af641b830cc15a2d41a62[m[33m ([m[1;31morigin/Grundgerüst[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 23:18:52 2024 +0200

    Paul hat Grundgerüst implementiert und UML entsprechend aktualisiert

[33mcommit 96c5a054256ec582e7233ce271ad61918d3f2c5c[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 21:49:04 2024 +0200

    Paul hat die Test-Dateien aufgeräumt

[33mcommit 19d403956a578db872e324dd7300d66218f34ad8[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:42:38 2024 +0200

    Paul hat UML angepasst

[33mcommit 5f178d34865b657d168267274d07949f952a1692[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:33:53 2024 +0200

    Paul hat setOccupation-Methode zu Field hinzugefügt

[33mcommit 75c5fe3717e0019234160ff27e2f2bf8dc7322f7[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:29:08 2024 +0200

    Paul hat actionPerformed-Methode von Board entfernt

[33mcommit f8e63c24150a2aeaec4daa919905767e5ce8f29e[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:23:21 2024 +0200

    Paul hat isSelected-Attribut zu Field hinzugefügt

[33mcommit 23d2915d9ed0e0e77609aabae3f39cc39c39e954[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:16:43 2024 +0200

    Paul hat begin-Konstante angepasst

[33mcommit feb5d15ec62b93ab0201b5de9b66a5bf39378ef5[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:14:15 2024 +0200

    Paul hat begin-Konstante angepasst

[33mcommit 810763554e8791ba7f2767cc70c773f2f2a1c5de[m[33m ([m[1;31morigin/Planung[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 20:09:30 2024 +0200

    Paul hat UML wiederhergestellt

[33mcommit 506fcf437e5d6b20005eaa70f074483afc92a1e5[m[33m ([m[1;31morigin/newNewBranch[m[33m)[m
Author: Michael58432 <Huber.Michael584@gmail.com>
Date:   Wed Jun 12 17:28:02 2024 +0200

    test4

[33mcommit cda8f59e5b6d22be1b28c0fa6d4a9d94ab03cc7a[m
Author: Michael58432 <Huber.Michael584@gmail.com>
Date:   Wed Jun 12 17:20:38 2024 +0200

    test1

[33mcommit f54ee72eb4e06107bf69cba7278a3dfd1c075e4f[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 16:56:27 2024 +0200

    Paul hat Planungsordner mit UML, Systembeschreibung inklusive Regelzusammenfassung und Angabe aus dem Digicampus hinzugefügt

[33mcommit 860e205614a2d63c0802b448d8fda903c20c241c[m
Merge: 74b2c29 41b2ef5
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 16:37:09 2024 +0200

    Merge pull request #1 from WoBen07/gui
    
    Paul hat das 'othello'-package mitsamt Inhalt im Branch 'gui' gelösch…

[33mcommit 41b2ef55cd7f28e2e52dcb7808ea830eae12065e[m[33m ([m[1;31morigin/gui[m[33m)[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 16:34:18 2024 +0200

    Paul hat das 'othello'-package mitsamt Inhalt im Branch 'gui' gelöscht (vermutlich - ist als Frage zu verstehen)

[33mcommit 74b2c299353f1f21db8cb6f0f698e6cf2f478ae6[m
Author: highestPACE <pschweizer0711@gmail.com>
Date:   Wed Jun 12 16:05:58 2024 +0200

    Paul hat Zeugf gemacht

[33mcommit 367162cf0940f130a94caa39cf5a4f1b5deb8e57[m
Author: WoBen07 <benedict.wohlgemuth@uni-a.de>
Date:   Tue Jun 11 15:47:07 2024 +0200

    inital commit
