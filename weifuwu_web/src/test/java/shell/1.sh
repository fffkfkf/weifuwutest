#!/bin/bash
echo Starting application
nohup java -jar a-service-1.0-SNAPSHOT.jar > info.log 2>&1 &
echo "end---"
