#!/usr/bin/env sh
mem_size=(128 256 512 1024 2048)

gc_type=("Serial" "Parallel" "G1" "ConcMarkSweep")
cd ../out/production/week02-gc/
for i in ${mem_size[@]} ;
do
  for j in ${gc_type[@]} ; do
    echo use${j}GC mem_size=${i}m
      java -Xlog:gc\*:file=../../../week02-gc/logs/Use${j}GC${i}m.txt:time:filecount=0  -XX:+Use${j}GC  -Xms${i}m -Xmx${i}m GCLogAnalysis
  done
done