# Exercise: REST API using spring-boot
Excercise to create a REST controller using spring-boot

## API
- The REST API should offer one endpoint `/v1/resources`
- Said endpoint returns a sorted list of resource objects

For example:
```json
[

    {
        "id": "456",
        "value1": "another value",
        "value2": 1337,
        "createdAt": "14:45:00"
    },
    {
        "id": "123",
        "value1": "some value",
        "value2": 9000,
        "createdAt": "12:00:00"
    }

]
```

## Testing
[Tests](src/test/kotlin/EndpointResponseTests.kt) for the endpoint are already implemented and need to be satisfied
