#!/bin/sh
MAVEN_OPTS="-Xms256m -Xmx1024m"
mvn exec:java -Dexec.mainClass="koJ.Run"

