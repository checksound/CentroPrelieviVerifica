# Centro Prelievi

L'esercizio simula un centro prelievi con un medico che esegue le analisi.

I pazienti sono 4 e inviano di continuo i loro esami al medico mettendoli in un 
contenitore che **può contenere al massimo 6 esami contemporaneamente**. L'unico 
medico che può soddisfare le richieste di esame le preleva dal medesimo contenitore.

Ogni paziente fa una nuova richiesta di esame aspettando come minimo 5 secondi e come massimo
9 secondi (un numero random tra 5 e 9 secondi), ma, se il contenitore in quel momento è
pieno, il paziente deve aspettare a inserire la richiesta nel contenitore finché il medico 
non preleva la prima richiesta ancora in giacenza.

L'esame, messo da paziente nel contenitore, avrà due attributi: deve contenere il 
**nome del paziente** e un intero progressivo che rappresenta il **numero dell'esame**
richiesto dal paziente.  
(Il paziente A avrà come numero di esame iniziale, numero esame = 1, poi 2, poi 3... 
così come il paziente B avrà come numero esame iniziale, numero esame = 1, poi 2, 
poi 3 .....).

La coppia **nome paziente** e **numero esame** identificherà univocamente l'esame che 
il medico deve analizzare.

Il medico preleva gli esami da eseguire dal contenitore in ordino FIFO 
(First-In-First-Out) e li analizza, per analizzare ci mette almeno 1 secondo
e come tempo massimo 2 secondi (un tempo random tra 1
e 2 secondi) e scrive in output **analizzato esame, stampando in output per ogni esame, 
il nome paziente e numero esame** che è stato analizzato.

Il medico se non trova lavori di svolgere in quel momento (ha sbrigato tutti
i lavori precedenti), comincia a giocare a carte per un tempo minimo di 1 secondo e 
massimo di 5 secondi (un tempo random tra 1 e 5 secondi). 
Finito di giocare a carte riprende il proprio lavoro controllando nel contenitore
se ci sono esami ha eseguire.

Il programma va avanti indefinitivamente, per fermarlo è necessario fermarlo 
dall'esterno.

## Ricapitolo

4 PAZIENTI CHE FANNO RICHIESTE ESAMI.

* OGNI PAZIENTE ASPETTA PRIMA DI FARE UNA NUOVA RICHIESTA MINIMO 5 secondi e MASSIMO 9 secondi

1 SOLO MEDICO CHE PRENDE IN CARICO LE RICHIESTE.

* IL MEDICO PER PROCESSARE UNA RICHIESTA ESAME CI METTE COME MINIMO 1 secondo e al massimo 2 SECONDI
* SE IL MEDICO NON TROVA ESAMI DA SVOLGERE INIZIA A GIOCARE A CARTE PER UN MINIMO DI UN SECONDO e
  PER UN MASSIMO DI 5 SECONDI. POI RIPRENDE IL SUO LAVORO.

IL **CONTENITORE DELLE RICHIESTE** HA UNA CAPACITA' MASSIMA DI **6 ELEMENTI**. SE
UN PAZIENTE HA UNA RICHIESTA ESAME DA FARE MA IL CONTENITORE E' PIENO, DEVE ASPETTARE
A INSERIRE LA RICHIESTA FINCHE' IL MEDICO NON HA PRESO IN GESTIONE UNA DELLE
PRECEDENTI RICHIESTE E SI LIBERA QUINDI SPAZIO.

## Consigli

Per avere numeri random utilizzate i metodi della classe *java.util.Random*. 

Create una classe *Esame* per rappresentare le richieste d'esame con due attributi: 
*nomePaziente* di tipo *String* e *numRichiesta* di tipo *int*.

## Soluzione

L'applicazione [CentroPrelieviApplicazione](./src/CentroPrelieviApplicazione.java) con
le classi [Esame](./src/Esame.java), [Medico](./src/Medico.java) ed [Esame](./src/Esame.java)
