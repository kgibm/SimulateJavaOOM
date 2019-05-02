# SimulateJavaOOM

```
java -Xmx256m -Dsize=10485760 SimulateJavaOOM
```

## Docker

Dockerfile:

```
FROM ibmjava:8-sdk
RUN wget -q -O /tmp/SimulateJavaOOM.class https://github.com/kgibm/SimulateJavaOOM/raw/master/SimulateJavaOOM.class
```

Build:

```
docker build -t test .
```

Run:

```
docker run -v /:/host --rm -it test java -Xmx256m -Xdump:directory=/host/tmp/ -Xdump:heap:none -cp /tmp -Dsize=10485760 SimulateJavaOOM
```
