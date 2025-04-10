# FixClientExample

Questo progetto è un **client FIX** (Financial Information eXchange) sviluppato in **Java** con **QuickFIX/J**. Esegue un ordine di acquisto (buy) di 100 azioni AAPL tramite una connessione FIX 4.2 verso un server compatibile (es. simulatore, broker, gateway).

---

## 📦 Struttura del progetto

```
FixClientExample/
├── pom.xml              # Configurazione Maven
├── fix.cfg              # Configurazione della sessione FIX
└── src/
    └── main/
        └── java/
            └── com/
                └── example/
                    └── fixclient/
                        └── FIXClient.java
```

---

## ⚙️ Requisiti

- Java 8 o superiore
- Maven 3+
- Server FIX o Simulatore (es. [Fixsim.com](https://fixsim.com), QuickFIX acceptor, IBKR FIX demo)

---

## 🚀 Come eseguire

### 1. Clona o scarica il progetto

```bash
git clone https://github.com/tuo-utente/FixClientExample.git
cd FixClientExample
```

### 2. Compila con Maven

```bash
mvn clean install
```

### 3. Avvia il client

Assicurati che il server FIX (o simulatore) sia attivo sulla `fix.cfg` (`127.0.0.1:9876`), quindi:

```bash
mvn exec:java -Dexec.mainClass="com.example.fixclient.FIXClient"
```

> In alternativa, puoi eseguire il file `.jar` se hai configurato il plugin Maven Shade o Assembly.

---

## 🔧 Configurazione `fix.cfg`

Modifica `fix.cfg` per connetterti a un server FIX:

```ini
SocketConnectHost=127.0.0.1
SocketConnectPort=9876
SenderCompID=CLIENT1
TargetCompID=SERVER1
```

---

## 🧪 Test con simulatore

Puoi testare il client con un simulatore FIX gratuito:

- [FixSim](https://fixsim.com/)
- QuickFIX acceptor locale (QuickFIX acceptor + FIX42.xml)
- Broker FIX compatibile (es. IBKR, Exante, LMAX)

---

## 📜 Licenza

MIT

---
