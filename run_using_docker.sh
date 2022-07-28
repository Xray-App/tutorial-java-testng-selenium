#!/bin/bash

# please review the settings.xml.sample

docker build . -t tutorial_java_testng_selenium

docker run --rm -v $(pwd)/reports:/source/target -t tutorial_java_testng_selenium
