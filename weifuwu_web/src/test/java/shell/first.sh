#!/usr/bin/env bash
echo "Hello Worleeed -----------"
for i in  `find /home/123/shell  -name "*.log"` ; do
    tar -czf 20200620log.tar.gz $i
done

echo "Hello Worleeed ------------"