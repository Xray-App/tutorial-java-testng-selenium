# Tutorial with TestNG tests using Selenium Webdriver

[![build workflow](https://github.com/Xray-App/tutorial-java-testng-selenium/actions/workflows/main.yml/badge.svg)](https://github.com/Xray-App/tutorial-java-testng-selenium/actions/workflows/main.yml)
[![license](https://img.shields.io/badge/License-BSD%203--Clause-green.svg)](https://opensource.org/licenses/BSD-3-Clause)
[![Gitter chat](https://badges.gitter.im/gitterHQ/gitter.png)](https://gitter.im/Xray-App/community)

## Overview

Code that supports the tutorial [Testing web applications using Selenium and TestNG in Java](https://docs.getxray.app/display/XRAYCLOUD/Testing+web+applications+using+Selenium+and+TestNG+in+Java) showcasing the integration between [Xray Test Management](https://www.getxray.app/) on Jira and TestNG, using Xray related annotations.

## Prerequisites

In order to run this tutorial, you need to have JDK 11 and Maven; Gradle should also be supported.
This tutorial uses the maven package `xray-testng-extensions` which is available on Maven Central repository; previously this package was on GitHub packages but meanwhile it was moved to Maven Central.

## Running

Tests can be run using the maven command `mvn`.

```bash
mvn test
```

If you prefer Gradle, it's also possible to run the tests using the command `gradle`.

```bash
gradle clean testngTest
```

Tests can also run inside a Docker container; local directory should be mounted so that TestNG XML results are stored locally.

```bash
docker build . -t tutorial_java_testng_selenium
docker run --rm -v $(pwd)/reports:/source/target -t tutorial_java_testng_selenium
```

## Submitting results to Jira

Results can be submitted to Jira so that they can be shared with the team and their impacts be easily analysed.
This can be achieved using [Xray Test Management](https://www.getxray.app/) as shown in further detail in this [tutorial](https://docs.getxray.app/display/XRAYCLOUD/Testing+web+applications+using+Selenium+and+TestNG+in+Java).

## Contact

Any questions related with this code, please raise issues in this GitHub project. Feel free to contribute and submit PR's.
For Xray specific questions, please contact [Xray's support team](https://jira.getxray.app/servicedesk/customer/portal/2).

## LICENSE

[BSD 3-Clause](LICENSE)
