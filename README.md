# Centro Prelievi

L'esercizio simula un centro prelievi con un medico che esegue le analisi. 
I pazienti inviano al medico gli esami eseguiti e il medico ritorna il responso, 
una volta visti gli esami.  

I pazienti sono 4 e inviano i loro esami al medico mettendoli in un 
contenitore (coda FIFO) che **può contenere al massimo 6 esami contemporaneamente**. 
Se il contenitore è in quel momento pieno, il paziente deve aspettare che il medico non 
prelevi qualche esame per analizzarlo.

Ogni paziente solo quando riceve l'esito dell'esame può inviare, dopo un po' di tempo, un
nuovo esame al medico per essere analizzato, sempre utilizzando il contenitore. 

Una segretaria inoltra riceve l'esito degli esami dal medico e li comunica al 
singolo paziente.

Il risultato dell'esame possono essere 'tutto ok' o 'altro esame da eseguire'. 
In media 3/4 degli esami danno come risultato tutto OK, mentre 1/4 richiede 
un nuovo esame.

Ogni paziente fa una nuova richiesta di esame aspettando come minimo 5 secondi e come 
massimo 9 secondi (un numero random tra 5 e 9 secondi), se il precedente esame aveva dato 
esito tutto ok, mentre come minimo 3 secondi e massimo 7 secondi se il precedente 
esame aveva dato esito 'altro esame'.

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
e come tempo massimo 5 secondi e scrive in output **analizzato esame, stampando in output per ogni esame, 
il nome paziente e numero esame** che è stato analizzato.

Il medico se non trova lavori di svolgere in quel momento (ha sbrigato tutti
i lavori precedenti), comincia a giocare a carte per un tempo minimo di 1 secondo e 
massimo di 5 secondi (un tempo random tra 1 e 5 secondi). 
Finito di giocare a carte riprende il proprio lavoro controllando nel contenitore
se ci sono esami ha eseguire.

Il programma va avanti indefinitamente, per fermarlo è necessario fermarlo 
dall'esterno.

## Consigli

Per avere numeri random utilizzate i metodi della classe *java.util.Random*. 

Create una classe *Esame* per rappresentare l'esame da analizzare, con due attributi: 
*nomePaziente* di tipo *String* e *numRichiesta* di tipo *int*.

Una classe *EsitoEsame* che contiene il responso del medico sull'esame, da consegnare 
al paziente.

## Esempio soluzione (abbozzo)

L'applicazione [CentroPrelieviApplicazione](./src/CentroPrelieviApplicazione.java) con
le classi [Paziente](./src/Paziente.java), [Medico](./src/Medico.java), 
[Segretaria](./src/Segretaria.java), [Esame](./src/Esame.java) ed 
[EsitoEsame](./src/EsitoEsame.java).
