PoC implmentation of Testcontainers with Springboot

using:
	- SpringBoot 3.2.2
	- Docker
	- PostgreSQl
	- Java 21

Remember to use @Restartscope annotation when the application context restarts, to avoid losing the db container and having to regenerate the test data.
