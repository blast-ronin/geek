#!/usr/bin/env sh
java -Xlog:gc\*::t  -XX:+UseSerialGC  -Xms128m -Xmx128m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseSerialGC  -Xms256m -Xmx256m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseSerialGC  -Xms512m -Xmx512m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseSerialGC  -Xms1024m -Xmx1024m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseSerialGC  -Xms2048m -Xmx2048m GCLogAnalysis


java -Xlog:gc\*::t  -XX:+UseParallelGC  -Xms128m -Xmx128m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseParallelGC  -Xms256m -Xmx256m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseParallelGC  -Xms512m -Xmx512m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseParallelGC  -Xms1024m -Xmx1024m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseParallelGC  -Xms2048m -Xmx2048m GCLogAnalysis


java -Xlog:gc\*::t  -XX:+UseG1GC  -Xms128m -Xmx128m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseG1GC  -Xms256m -Xmx256m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseG1GC  -Xms512m -Xmx512m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseG1GC  -Xms1024m -Xmx1024m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseG1GC  -Xms2048m -Xmx2048m GCLogAnalysis


java -Xlog:gc\*::t  -XX:+UseConcMarkSweepGC  -Xms128m -Xmx128m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseConcMarkSweepGC  -Xms256m -Xmx256m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseConcMarkSweepGC  -Xms512m -Xmx512m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseConcMarkSweepGC  -Xms1024m -Xmx1024m GCLogAnalysis
java -Xlog:gc\*::t  -XX:+UseConcMarkSweepGC  -Xms2048m -Xmx2048m GCLogAnalysis