                                           PROGETTO ESAME "METODOLOGIE DI PROGRAMMAZIONE"

DESCRIZIONE

Il progetto previsto per l’esame consiste nello sviluppo di Formula 1, un gioco di carta e matita in cui viene simulata una gara tra veicoli. Il tracciato e i giocatori bot vengono inseriti tramite file, quest’ultimi leggendo il nome mentre per la codifica della mappa è stato seguito uno schema. La matrice della pista può essere interpretata nel seguente modo : il carattere “ - ” indica le zone fuori dalla pista, la lettera “t” indica le zone dentro la pista, la lettera “s” indica la partenza, la lettera “f” indica l’arrivo ed infine la lettera “a” indica un check point di metà gara.
Il codice del progetto è diviso in due moduli : nel primo nominato “api” è presente tutto ciò che riguarda l’implementazione del gioco, all’interno è stato suddiviso in quattro package in base al contenuto. Nel secondo modulo, chiamato “app”, è presente ciò che permette all’applicazione di essere avviata.

FUNZIONAMENTO

Nel gioco, oltre ai giocatori bot, è stato inserito un altro giocatore che permette di interagire con Formula 1 da console e quindi di poter giocare una partita. Nel tracciato di gara viene inserita, in maiuscolo, la lettera iniziale di ogni giocatore che individua il punto in cui esso si trova.
All’avvio dell’app viene richiesto alla persona che gioca, di inserire il proprio nome così da potersi riconoscere nel tracciato tramite la propria iniziale. Successivamente parte la gara e si richiede al giocatore umano, ogni volta che è il suo turno, di inserire il numero corrispondente alla mossa che vuole fare, scegliendo tra l’elenco proposto. Un giocatore può vincere la gara soltanto dopo essere passato per il check point posto a metà tracciato. La gara termina quando è presente un vincitore oppure quando tutti i giocatori sono usciti dalla pista, perciò nessuno ha vinto.

RESPONSABILITÀ

Nel progetto vengono gestite diverse responsabilità :

➢ la prima riguarda la lettura del file di testo : essa viene implementata dall’interfaccia “iFileR” e dal record “FileR” il quale si occupa puramente di leggere le righe di un file passato.

➢ La seconda responsabilità è quella di creare il tracciato: essa è implementata dall’interfaccia “iTrack” e dalla classe “Track” che crea il tracciato tramite il file ricevuto.

➢ La terza responsabilità è quella di gestire il concetto di posizione nel gioco ed è implementata dal record “Position” il quale si occupa di tenere le coordinate.

➢ La quarta responsabilità riguarda la scelta delle mossa da eseguire nel gioco effettuata dai giocatori, conoscendo la lista delle mosse disponibili. Ciò viene implementato
  dall’interfaccia “iPlayer” e dalle classi “Player” e “Bot”.
  La prima permette di scegliere la mossa mentre la seconda la genera random tra quelle disponibili.

➢ La quinta responsabilità riguarda la gestione del concetto di direzione utile per il calcolo delle mosse. In questo caso viene rappresentato dall’enumerazione “Direction”.

➢ La sesta responsabilità riguarda la gestione del movimento nel gioco. Questo viene implementato dalla classe “Car” che implementa l’interfaccia “iCar”. La classe contiene ciò che consente di effettuare il movimento.

➢ La settima responsabilità riguarda l’inizializzazione del gioco. Questo è stato implementato tramite la classe “SetUpGame” che, implementa l’interfaccia “iSetUpGame”, ed ha lo scopo di inizializzare il tracciato e i giocatori.

➢ L’ ottava responsabilità riguarda i check che devono essere svolti durante il gioco. Questo è implementato dalla classe “GameController” che implementa l’interfaccia “iGameController” ed ha l’obiettivo fare i check necessari al gioco per svolgersi correttamente.

➢ La nona responsabilità riguarda la gestione di una partita ed è implementata dalla classe “GameEngine” che implementa l’interfaccia “iGameEngine” ed ha lo scopo occuparsi di una partita del gioco Formula 1.

➢ La decima responsabilità riguarda l’input ed è gestita dalla classe “Input” che implementa l’interfaccia “iInput”.

➢ L’ undicesima responsabilità riguarda la gestione dell’output ed se ne occupa la classe “PrinterGame” che implementa l’interfaccia “iPrinter”.
