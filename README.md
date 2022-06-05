# Offline-Caching
This project fetch data from a REST API using Retrofit, and cache this data for offline use in an SQLite database using the Room persistence library. For this, NetworkBoundResource is used implementation based on Kotlin Coroutines and Kotlin Flow. The app will follow a simple MVVM architecture with dependency injection, single source of truth principle, and separation of concerns.
