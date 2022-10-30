[github-packages-shield]: https://img.shields.io/github/v/release/BlockyDotJar/SLF4J-Fallback-Logger
[github-packages]: https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/packages/1685612

[license-shield]: https://img.shields.io/badge/License-Apache%202.0-white.svg
[license]: https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/tree/main/LICENSE

[discord-invite-shield]: https://discord.com/api/guilds/876766868864647188/widget.png
[discord-invite]: https://discord.gg/mYKK4BwGxe

[download]: #download

# SLF4J-Fallback-Logger

[ ![github-packages-shield][] ][download] [ ![license-shield][] ][license] [ ![discord-invite-shield][] ][discord-invite]

This is a fallback logger for SLF4J, which triggers if there is no `StaticLoggerBinder` or `ServiceProvider` implementation.

## Summary

1. [Introduction](#introduction)
2. [Download](#download)
3. [Documentation](#documentation)
4. [Contribution](#contribution)
5. [Dependencies](#dependencies)
6. [Related projects](#related-projects)

## Introduction

Creating the `Logger` object is done via the `FallbackLogger` class.

**Example**:

```java
final Logger logger = FallbackLogger.getLog(YourClass.class);
```

If no implementation is found, following message will be printed to the console on startup:

```php
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#noProviders for further details.
```
Or if you use an outdated version of it, something like this will appear in your console:

```php
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#noProviders for further details.
SLF4J: Class path contains SLF4J bindings targeting slf4j-api versions prior to 1.8.
SLF4J: Ignoring binding found at [jar:file:/C:/Users/UserName/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.11/4741689214e9d1e8408b206506cbe76d1c6a7d60/logback-classic-1.2.11.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#ignoredBindings for an explanation.
```

If there was an implementation found, the logger will work as intended.

## Download

[ ![github-packages-shield][] ][github-packages]

Find the latest GitHub release [here](https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/releases/latest).

Be sure to replace the **`VERSION`** key below with the one of the versions shown above!

### Maven

First you should create a `settings.xml` and add this to it:
<br> Be sure to replace the **`GITHUB_USERNAME`** key below with your GitHub username and **`GITHUB_TOKEN`** with a [GitHub token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)!

```xml
<servers>
  <server>
    <id>github</id>
    <username>GITHUB_USERNAME</username>
    <password>GITHUB_TOKEN</password>
  </server>
</servers>
```

After that you add this repository and dependency to your `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <name>GitHub BlockyDotJar Apache Maven Packages</name>
    <url>https://maven.pkg.github.com/BlockyDotJar/SLF4J-Fallback-Logger</url>
  </repository>
</repositories>
```

```xml
<dependencies>
  <dependency>
    <groupId>dev.blocky.library</groupId>
    <artifactId>slf4j-fbl</artifactId>
    <version>VERSION</version>
  </dependency>
</dependencies>
```

### Gradle

Be sure to replace the **`GITHUB_USERNAME`** key below with your GitHub username and **`GITHUB_TOKEN`** with a [GitHub token](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/creating-a-personal-access-token)!

**Gradle Groovy:**

```gradle
repositories {
    maven {
        url = uri 'https://maven.pkg.github.com/BlockyDotJar/SLF4J-Fallback-Logger'
        credentials {
            username = project.findProperty('gpr.user') ?: 'GITHUB_USERNAME'
            password = project.findProperty('gpr.key') ?: 'GITHUB_TOKEN'
        }
    }
}
```

```gradle
dependencies {
    implementation 'dev.blocky.library:slf4j-fbl:VERSION'
}
```

**Kotlin DSL:**

```gradle
repositories {
    maven {
        url = uri("https://maven.pkg.github.com/BlockyDotJar/SLF4J-Fallback-Logger")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: "GITHUB_USERNAME"
            password = project.findProperty("gpr.key") as String? ?: "GITHUB_TOKEN"
        }
    }
}
```

```gradle
dependencies {
    implementation("dev.blocky.library:slf4j-fbl:VERSION")
}
```

## Documentation

JavaDocs are available in both jar format and web format.

The jar format is available on the [promoted downloads](https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/packages/1520119) page or on any of the build pages of the [downloads](https://BlockyDotJar.github.io/SLF4J-Fallback-Logger).

## Contribution

If you want to contribute to SLF4J-fbl, make sure to base your branch off of our **developer** branch
and create your PR into that **same** branch.
<br>**We will be rejecting any PRs, which are not based to the developer branch!**
<br>It is very possible that your change might already be in development or you missed something.

More information can be found at the [contributing](https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/wiki/Contributing) wiki page.

### Deprecation Policy

When a feature is introduced to replace or enhance existing functionality we might deprecate old functionality.

A deprecated method/class usually has a replacement mentioned in its documentation which should be switched to.
<br>Deprecated functionality might or might not exist in the next minor release. (Hint: The minor version is the `MM` of `XX.MM.RR(-TT.ZZ)` in our version format)

It is possible that some features are deprecated without replacement, in this case the functionality is no longer supported by either the SLF4J-fbl structure
due to fundamental changes or due to SLF4J changes that cause it to be removed.

We highly recommend discontinuing usage of deprecated functionality and update by going through each minor release instead of jumping.
<br>For instance, when updating from version `1.0.0-beta.1` to version `1.0.0-rc.2` you should do the following:

- Update to `1.0.0-beta.ZZ` and check for deprecation
- Update to `1.0.0-rc.2` and check for deprecation

The `RR` in version `1.0.RR` should be replaced by the latest version that was published for `1.0`, you can find out which the latest
version was by looking at the [release page](https://github.com/BlockyDotJar/SLF4J-Fallback-Logger/releases).

## Dependencies:

This project requires **Java 17+**
<br>All dependencies are managed automatically by Gradle.

* slf4j-api
    * Version: **v2.0.3**
    * [Github](https://github.com/qos-ch/slf4j)
* commons-collections4
    * Version: **v4.4**
    * [Github](https://github.com/apache/commons-collections)
* jetbrains-annotations
    * Version: **v23.0.0**
    * [Github](https://github.com/JetBrains/java-annotations)
* error_prone_annotations
    * Version: **v2.16.0**
    * [Github](https://github.com/google/error-prone)

## Related Projects

* [logback](https://mvnrepository.com/artifact/ch.qos.logback)
* [slf4j-simple](https://mvnrepository.com/artifact/org.slf4j/slf4j-simple)
* [slf4j-nop](https://mvnrepository.com/artifact/org.slf4j/slf4j-nop)

**See also:** [SLF4J Maven artifacts](https://mvnrepository.com/artifact/org.slf4j)
