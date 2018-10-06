# [KotlinConf 2018](https://kotlinconf.com/)
Notes from KotlinConf 2018

## Keynote
[Kotlin 1.3](http://kotl.in/1.3)

[Coroutines - async non-blocking code](http://kotl.in/coroutines)

[Ktor](http://ktor.io/)

[Kotlin Native](https://kotlinlang.org/docs/reference/native-overview.html)

[multiplatform](https://kotlinlang.org/docs/reference/multiplatform.html)

http, serialization, coroutines, settings, logging

unified tooling, Intellij opens up JVM, JS, Native multiplatform projects

Gradle Kotlin DSL

scratch files, scripts, *.kts

build time is better

https://github.com/hzsweers/CatchUp

Future
* keep language modern
* comfortable upgrades - run migrations window in intellij
* feedback loop
* focus on compiler API, it's possible to write compiler plugins
* saner concurrency - more distant future

[progressive mode](https://kotlinlang.org/docs/reference/whatsnew13.html#progressive-mode)

experimental
* inline classes
* unsigned arithmetics
* contracts & type inference

kotlin for java developers coursera specialization

[edutools plugin](https://www.jetbrains.com/help/education/install-edutools-plugin.html?section=IntelliJ%20IDEA)

[learn](http://kotl.in/learn)

[play](https://play.kotl.in)

https://www.atomickotlin.com/
https://github.com/BruceEckel/AtomicKotlinExamples

spring + kotlin

https://spring.io/blog/2016/02/15/developing-spring-boot-applications-with-kotlin

https://spring.io/guides/tutorials/spring-boot-kotlin/

## Komparing Kotlin Server Frameworks

* Ktor
* Http4k
* Jooby
* Vertx
* jhipster - scaffolding
* Spring - most popular framework, slowest?

spring fu, there is also coroutines support

https://github.com/spring-projects/spring-fu

GraalVM, SubstrateVM
* no dynamic class loading
* no jmx vm monitoring

going native makes startup much faster

## Code Lab - Kotlin Interop
https://gist.github.com/dgreenhalgh/70e63dcd410b11974ff5d9a5e821b77b
https://gist.github.com/dgreenhalgh/ecb25561d711769d4ab45e981a173a7d
https://gist.github.com/dgreenhalgh/9acb9fd6bd2668a0235c7387b5b03478

String! is shown in IDE when there is ambiguity, this can be improved with @NotNull, @Nullable annotations

String vs String? - as a question :), then it may be null

Kotlin represents all data using objects

https://www.bignerdranch.com/books/kotlin-programming/

## GraphQL powered by Kotlin

http://adavis.info/2018/02/graphql-api-in-kotlin.html

is query language, e.g. similar to SQL

```
query OPERATION_NAME {
  object_I_am_interested_in {
    field1,
    field2
  }
}
```

query - GET
mutations - POST, PUT, PATCH, DELETE

is spec

servers and client, multiple languages

is introspective
metadata about endpoints

Server in Kotlin - kgraphql
* types
* schemas
* resolvers
Ktor

https://github.com/APIs-guru/graphql-apis

https://wehavefaces.net/graphql-shorthand-notation-cheatsheet-17cd715861b6

https://www.apollographql.com/client/

## Architecting a Kotlin JVM and JS multiplatform project

experimental

write code only in Kotlin and target multiple platforms

https://medium.com/airbnb-engineering/react-native-at-airbnb-f95aa460be1c

common
to share business logic

* kotlinc -> JVM, Android
* kotlin/native -> executable, dynamic lib, iOS
* kotlin2js -> JS

https://kotlinlang.org/docs/reference/multiplatform.html

https://github.com/felipecsl/ktnes

## Exploring the Kotlin type hierarchy from top to bottom

https://speakerdeck.com/npryce/the-kotlin-type-hierarchy-from-top-to-bottom

https://rollbar.com/blog/top-10-javascript-errors/

## New Type Inference and Related Language Features
* Kotlin contracts
* compiler is more clever
* better type inference

## Building a Browser Extension with Kotlin
https://kotlinlang.org/docs/tutorials/javascript/kotlin-to-javascript/kotlin-to-javascript.html

https://developer.mozilla.org/en-US/docs/Mozilla/Add-ons/WebExtensions

browser object

https://rakhman.info/

https://medium.com/@Cypressious/your-first-firefox-web-extension-in-kotlin-348fc907915

https://medium.com/@Cypressious/your-second-firefox-extension-in-kotlin-bafd91d87c41

## Exploring Coroutines in Kotlin
https://www.agiledeveloper.com/downloads.html

* structure of functional sequential code is the same as parallel code
* functional style is great
* exception handling is a mess
* coroutines: rely on continuations

```
val sequence - buildSequence {
  yield(1)
  yield(2)
  yield(3)
}

for (value in sequence) {
  println("Value is $value")
}
```
code execution returns multiple times into the same function

`suspend fun` + `launch`

* structure of imperative sync code is the same as async code

`async` + `Deferred` + `await()`

## Code Lab - Higher-order Functions
https://gist.github.com/dgreenhalgh/6f14267507cbec6e9f52fa3e84971771
https://gist.github.com/dgreenhalgh/54d87412fec2705119a72bd08e12fbe6

* function inlining, removes the need for the JVM to use an object instance and to perform variable memory allocations for the lambda
* `inline fun`

## Kotlin Coroutines in Practice
coroutines ~ light weight threads 
`suspend fun` - doesn't block, waits for the completion, function returns only when everything is completed, is sequential

in parallel -> `launch{}` -> when we use it this way, that invocation is child of coroutine scope instead of being global as it is with `Thread`s

structured concurrency

* shared + mutable state = danger => shared by communication
* synchronized primitives => communication primitives - channels
* classes => coroutines

communication primitives
`CoroutineScope.`...
`ReceiveChannel`
`SendChannel`

* concurrency must be limited
* worker pool
* it can be achieved with `SendChannel`

`select` expression to choose from multiple receive channels

everything inside coroutine: no concurrency, no synchronization, code is sequential

patterns: worker pool, actor

* coroutines can be written in a way where they never leak - they are closed properly
* `CoroutineScope` - launches new coroutines & quickly returns, doesn't wait for them

takeaways
* coroutines are not like threads
* the code needs to be restructured, but it's much better
* no exception is ever lost, it bubbles up

## Learn together. Not the same
deliveroo

learning Kotlin as a team

cross-functional teams: consumer | rider | restaurant

catchup on e.g. Android

collaboration through code reviews

add link to slack, if e.g. PR is way too big, people wouldn't pick it up -> wheel decide

sharing knowledge

teaching somebody is the best way

assume that anyone you're teaching has no knowledge, but infinite intelligence

code reviews are for more than just correctness

create forums for discussion

it's ok to say I dunno, not understand everything

fight for your right to learn - add value to yourself & your company

doing code review is about learning + you can reflect on your own pull request while it is assigned to other team member

be mindful about commits

get feedback in advance

##### Kotlin hour

have a clear value proposition - agenda

use the hive mind - if I am backend developer, I can also contribute on frontend level or tests

learning has no definition of done

## Creating Internal DSLs in Kotlin
https://www.agiledeveloper.com/downloads.html

DSL - very targeted API

* external - I can define my own syntax, disatvantage: handle parsing
* internal - we build DSL on top of something, e.g. compiler

context + fluency

what makes Kotling good for DSLs:
* optional semicolon
* drop `.`, `()` - `infix fun`
* extension functions - no bytecode injection, compiler handles it, it's just syntactic sugar
* no `()` for passing last lambda

* implicit receivers
  * JS `.call`
  * it's possible to attach context to given function
  * I can take any function and supplement object on which function is called

inspiration: HTML builder, Spring fu

## Kotlin puzzlers, vol 2
https://github.com/angryziber/kotlin-puzzlers

