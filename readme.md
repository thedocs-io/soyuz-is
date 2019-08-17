# soyuz-is
Java truthy check library (**75 lines of code**) that will make your code **cleaner** and **safer**. Replace all your `!= null` check statements with `is.t(myObject)`:

```java
Boolean isItCleanCode = null;

if (isItCleanCode != null && isItCleanCode) {
   //... is it?
}

if (is.t(isItCleanCode)) {
  //... probably 
}
```

## Details
`is.t` will return `true` in a following cases:

```
Boolean                                 | true
String                                  | != ""
Number (Integer, Long, BigDecimal, etc) | != 0
Collection / Map                        | not empty
File                                    | exists
```

## TruthyCastableI
`TruthyCastableI` interface will allow you to make any class checkable by `is.t`. 

## How to use
### Maven
```
<dependency>
    <groupId>io.thedocs</groupId>
    <artifactId>soyuz-is</artifactId>
    <version>1.0</version>
</dependency>
```

### Gradle
```
repositories {
    mavenCentral()
}

dependencies {
    compile 'io.thedocs:soyuz-is:1.0'
}
```

### Import to java class
```
import io.thedocs.soyuz.is;
```

## Dependencies
This library depends on `com.google.code.findbugs:jsr305` (`javax.annotation.Nullable`)

## License
MIT
