# In-Memory Cache Low-Level Design

## Overview

This project implements a low-level design for an in-memory cache in Java. The cache is designed to efficiently store and retrieve frequently accessed data in memory, thereby improving application performance.

## Features

Key-Value Storage: The cache employs a key-value storage mechanism, allowing fast and direct access to stored information.
Time-Based Expiration: Each cached item has a configurable expiration time, ensuring that outdated data is automatically removed from the cache.
Thread-Safe Operations: The cache supports concurrent access, making it suitable for multi-threaded applications.
Getting Started

## Prerequisites
- Java Development Kit (JDK) 8 or higher
## Usage
- Clone the repository to your local machine:
```bash
git clone https://github.com/your-username/in-memory-cache-java.git
cd in-memory-cache-java
```
- Initialize the cache:
``` java
InMemoryCache<String, Object> myCache = new InMemoryCache<>();
```
- Add data to the cache:
``` java
myCache.put("key", "value", Duration.ofMinutes(1)); // Set a key-value pair with a 1-minute expiration time
```
- Retrieve data from the cache:
``` java
Object value = myCache.get("key");
if (value != null) {
    System.out.println("Value found: " + value);
} else {
    System.out.println("Key not found in the cache");
}
```

## Configuration

The cache can be configured with various parameters, such as the maximum number of items, default expiration time, and more. Refer to the configuration documentation for details.

## Examples

Check out the examples directory for usage examples and sample applications incorporating the in-memory cache.

## Contributing

We welcome contributions! Please follow our contribution guidelines before submitting pull requests or raising issues.

# License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

Special thanks to contributors who have helped shape this project.
Contact

For questions or feedback, please open an issue.

Thank you for using the In-Memory Cache Low-Level Design in Java!
