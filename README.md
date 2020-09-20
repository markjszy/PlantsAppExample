# Plants App Example
A simple demo of a basic RESTful Spring-based API

# How to run
1. Clone the repository
1. Build and run it! (Gradle): `./gradlew bootRun`

Migrating to Maven, if preferred, should be trivial.

# Step-by-Step Evolution
Commits on the main branch serve as a 
walkthrough of application evolution, from super-simple to slightly
more complex. Use diffs to get a clear picture of successive
updates!
 
Overview:
1. Initial Spring Boot web app with a simple entity (Plant)
1. Introduce Controller with naive GET implementation
1. Introduce Plant repository
1. Use the repository and ensure Plant is a managed entity
1. Initialize the db with some values (purely convenience/demo purposes)
1. Introduce custom 'not found' exception
1. Add advice and proper response for 'not found'
1. Introduce HATEOAS

# Exercise ideas 
* Leverage additional Spring functionality to make code even mode concise 
* Add testing!
* Deploy 
* Introduce new entities and functionality
* Introduce true persistence (not just in-memory DB)
* Add sessions and personalization - 
    how can we make this application and API capable
    of handling individual user data (e.g. personal "favorite plants" list)?