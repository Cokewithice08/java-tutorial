#!/bin/bash
mvn clean package

java -cp ./exchange-rate-api/target/exchange-rate-api-1.0.0-SNAPSHOT.jar:./exchange-rate-app/target/exchange-rate-app-1.0.0-SNAPSHOT.jar io.github.jast90.exchange.rate.app.MainApp

java -Djava.ext.dirs=$JAVA_HOME/jre/lib/ext:./exchange-rate-impl/target:./exchange-rate-impl/target/depends -cp ./exchange-rate-api/target/exchange-rate-api-1.0.0-SNAPSHOT.jar:./exchange-rate-app/target/exchange-rate-app-1.0.0-SNAPSHOT.jar io.github.jast90.exchange.rate.app.MainApp