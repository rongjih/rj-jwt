# rj-jwt4j

Pure Java implementation for JSON Web Token (JWT) [[RFC7519]]

## 1. Quick Start

### 1.1. Create a JWT
```
// create a default header: 
// e.g. {"typ":"JWT","alg":"HS256"}
Header header = Header.DEFAULT;

// create a payload
// e.g. {"iss":"RJ","aud":"you","exp":1483200000,"iat":1451577600,"name":"tester"}
Payload payload = new Payload();

// set some registed claims
payload.issuer = "RJ";
payload.audience = "you";
payload.issuedAt = ZonedDateTime.now().toEpochSecond();
payload.expires = ZonedDateTime.now().plusMonths(1).toEpochSecond();

// add your public/private claims
payload.add("name", "tester");
...

// sign and encode with the secret key
// eg. [header].[payload].[signature]
String jwt = new JWT(header, payload).encode("the-secret-key");
```

### 1.2. Verify a JWT

```
// verify and decode to a JWT instance
JWT jwt = JWT.decode("[header].[payload].[signature]", "the-secret-key");

// get your public/private claims value
String name = jwt.poyload.get("name");
```

## 2. Requirements

- Java 8 - this component use java8 native Base64 and HMACSHA-256
- At lease one Java API for JSON Processing ([JSR 353]) provider  
	e.g. [Genson], [Jackson], [Glassfish]

## 3. References

- JSON Web Token (JWT) Standard [[RFC7519]]
- [jwt.io](https://jwt.io)

[JSON Web Token]: https://tools.ietf.org/html/rfc7519
[RFC7519]: https://tools.ietf.org/html/rfc7519
[Java API for JSON Processing]: https://jcp.org/en/jsr/detail?id=353
[JSR 353]: https://jcp.org/en/jsr/detail?id=353
[Genson]: http://owlike.github.io/genson
[Jackson]: https://github.com/FasterXML/jackson-datatype-jsr353
[Glassfish]: https://jsonp.java.net/download.html