# camel-router-blueprint

Apache Camel route deployed as an OSGi Blueprint bundle (Red Hat lab exercise — Lab 01).

## What it does

The Blueprint route (`src/main/resources/OSGI-INF/blueprint/blueprint.xml`, Camel context `Lab-01`) implements a simple file-based integration flow:

1. Polls `/tmp/LabTempDir` for incoming files (`delete=true` removes each file after pickup).
2. Logs the file name and its content.
3. Renames the file with a timestamp (`yyyyMMddhhmmss-read.xml`) via the `CamelFileName` header.
4. Writes the result to `/tmp/LabTempDir/out`.

Supporting classes:

- `src/main/java/org/redhat/lab1/TradeOrder.java` — serializable Java bean modeling a stock trade order (`name`, `custId`, `vip`, `stockId`, `shares`, `cost`).
- `xsdfiles/stocktrading.xsd` — XML schema describing the stock-trading message format the route is meant to consume.

## Project structure

```
camel-router-blueprint/
├── pom.xml                                 # Maven build, packaging: OSGi bundle
├── src/main/java/org/redhat/lab1/          # TradeOrder bean
├── src/main/resources/OSGI-INF/blueprint/  # blueprint.xml — the Camel route
├── src/main/resources/log4j.properties
└── xsdfiles/stocktrading.xsd
```

## Prerequisites

- JDK 7+
- Apache Maven
- A Camel-capable OSGi container for deployment (e.g. Apache Karaf, Apache ServiceMix, Red Hat JBoss Fuse)

## Build

```bash
mvn install
```

## Run (standalone, without OSGi)

```bash
mvn camel:run
```

Before running, create the input folder and drop an XML file in it:

```bash
mkdir -p /tmp/LabTempDir
echo '<stocktrading><name>demo</name></stocktrading>' > /tmp/LabTempDir/order.xml
```

Processed files land in `/tmp/LabTempDir/out`, renamed with a timestamp.

## Deploy in OSGi

From the Karaf / ServiceMix / JBoss Fuse shell:

```
osgi:install -s mvn:org.apache.camel.archetypes/camel-archetype-blueprint/2.15.1.redhat-620133
```

## Tech notes

- Apache Camel 2.15.1 (Red Hat build `2.15.1.redhat-620133`), Blueprint DSL, OSGi bundle packaging via `maven-bundle-plugin`.
- Generated from the `camel-archetype-blueprint` Maven archetype; the route and the `TradeOrder` bean were customized for this lab.

## License

No license file is present in this repository.
