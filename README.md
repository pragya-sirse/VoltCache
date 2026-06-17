# VoltCache

VoltCache is a Redis-inspired in-memory key-value database built in Java.

## Features

- TCP Socket Server
- Multi Client Support
- In-Memory Key-Value Storage
- TTL Expiration (SETEX)
- Background Expiration Cleanup
- Disk Persistence
- Command Pattern Architecture

## Supported Commands

| Command | Description |
|----------|------------|
| SET key value | Store a value |
| GET key | Retrieve a value |
| DEL key | Delete a key |
| EXISTS key | Check if key exists |
| SETEX key ttl value | Store value with expiration |
| KEYS | List all keys |
| STATS | Show total keys |
| INFO | Show server information |
| FLUSH | Clear database |
| PING | Health check |
| HELP | List commands |

## Tech Stack

- Java 21
- Maven
- TCP Sockets
- ConcurrentHashMap
- ExecutorService

## Run

```bash
mvn clean install
mvn exec:java
```

## Connect

```bash
telnet localhost 6379
```

## Example

```text
SET name Pragya
OK

GET name
Pragya

PING
PONG

INFO
VoltCache Version : 1.0
Total Keys : 1
```

## Architecture

Client
↓
TCP Socket
↓
VoltCache Server
↓
Command Layer
↓
Storage Layer
↓
Persistence