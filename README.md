

3. WeatherPortfolio App

Sviluppo Android Nativo in Kotlin
Obiettivo del Progetto

Questa applicazione è stata sviluppata per dimostrare le mie competenze nell'integrazione di servizi REST esterni, gestione del threading e design moderno delle interfacce Android. L'app permette di cercare il meteo in tempo reale di qualsiasi città del mondo.
 Stack Tecnologico e Competenze Dimostrate

    Linguaggio: Kotlin con l'uso di Coroutines per la gestione asincrona delle chiamate di rete (evitando blocchi della UI).

    Networking: Retrofit 2 & Gson per il consumo e il parsing di API REST.

    UI/UX: Implementazione di Material Design con l'uso di CardView e layout flessibili.

    Architettura: Organizzazione del codice orientata alla manutenibilità e separazione delle responsabilità (Service, Data Models, UI).

 Come Funziona

    L'utente inserisce il nome di una città.

    L'app effettua una chiamata GET asincrona verso l'endpoint di OpenWeatherMap.

    I dati JSON vengono mappati automaticamente in oggetti Kotlin.

    L'interfaccia si aggiorna dinamicamente mostrando temperatura e descrizione.


Setup API Key
Per motivi di sicurezza, la chiave API non è inclusa nel codice sorgente. 
Per testare l'app:
1. Registrati su [OpenWeatherMap](https://openweathermap.org/) per ottenere una chiave gratuita.
2. Inserisci la chiave nella costante `API_KEY` all'interno di `MainActivity.kt`.
    
