# VoltCache

VoltCache is a Redis-inspired in-memory key-value database built in Java. It supports concurrent client connections, TTL-based expiration, disk persistence, and command-driven architecture over TCP sockets.

---

## Features

- In-memory key-value storage
- TCP socket-based server
- Multi-client support using ExecutorService
- TTL expiration with `SETEX`
- Background expiration cleanup scheduler
- Disk persistence across server restarts
- Command Pattern architecture
- ConcurrentHashMap-based storage engine

---

## Supported Commands

| Command | Description |
|----------|------------|
| SET key value | Store a value |
| GET key | Retrieve a value |
| DEL key | Delete a key |
| EXISTS key | Check if a key exists |
| SETEX key ttl value | Store value with expiration |
| KEYS | List all keys |
| STATS | Show total keys |
| INFO | Show server information |
| FLUSH | Clear database |
| PING | Health check |
| HELP | List all commands |

---

## Tech Stack

- Java 21
- Maven
- TCP Sockets
- ConcurrentHashMap
- ExecutorService
- ScheduledExecutorService

---

## Running VoltCache

### Start the server

```bash
mvn clean install
mvn exec:java
```

### Connect using Telnet

```bash
telnet localhost 6379
```

---

## Example Session

```text
Welcome to VoltCache!

SET name Pragya
OK

GET name
Pragya

EXISTS name
true

SETEX otp 10 1234
OK

PING
PONG

INFO
VoltCache Version : 1.0
Total Keys : 1
```

---

## Architecture

```text
Client
   │
   ▼
TCP Socket
   │
   ▼
VoltCache Server
   │
   ▼
Client Handler
   │
   ▼
Command Parser
   │
   ▼
Command Factory
   │
   ▼
Storage Engine
   │
   ▼
Persistence Layer
```

---

## Project Highlights

- Built a Redis-inspired database from scratch in Java.
- Implemented concurrent client handling using thread pools.
- Added TTL-based expiration with automatic background cleanup.
- Designed a pluggable command architecture using the Command Pattern.
- Persisted data to disk to survive server restarts.
