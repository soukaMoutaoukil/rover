#!/bin/bash

cd src/main/java
find . -name "*.java" -print | xargs javac

jar cmf META-INF/MANIFEST.MF rover.jar *.class

mv Rover.jar ../../../
