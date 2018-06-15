# Bookshelf

How to start the Bookshelf application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/bookshelf-1.0-SNAPSHOT.jar`
1. To check that your application is running enter url `http://localhost:8080`


How to start the Bookshelf application [Docker]
---

1. Run `docker built -t bookshelf .` at project root level
1. Start container with `docker run -p 8080:8080 bookshelf`
1. To check that your application is running enter url `http://localhost:8080/bookshelf`

Health Check
---

To see your applications health enter url `http://localhost:8080/api/healthcheck`


Runing instance [AWS: us-east]
---

A instance of this service is running in AWS cloud at EC2 machine under Elastic Beanstalk service

*Web Client*

`http://bookshelf-env.zjh23cgsr8.us-east-1.elasticbeanstalk.com/bookshelf`

*API*

`http://bookshelf-env.zjh23cgsr8.us-east-1.elasticbeanstalk.com/api/healthcheck`

API Docs
---
It's under `src/docs/api-guide.html` folder.
