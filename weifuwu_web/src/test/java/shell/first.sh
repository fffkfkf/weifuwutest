#!/usr/bin/env bash
echo "11"
case $1 in
aa)
  echo 'aa'
  ;;
bb)
  echo 'bb'
  ;;

* )
  echo "Usage:{$0 momitor_log | archive_log |help}"
  ;;
esac