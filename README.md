# jing-trang-patch

## Howto

* checkout jing-trang
`svn co --revision 2368 http://jing-trang.googlecode.com/svn`
* copy patch to directory
* apply patch
`patch -p2 < ltx-jing-trang.patch`
* compile jing-trang
`./ant`
* compile Example
`javac -cp /path/to/trunk/build/jing.jar ValidationExample.java`
* set CLASSPATH (bash)
`export CLASSPATH=$CLASSPATH:/path/to/jing.jar`
* run
`java ValidationExample`
* result will be located under /tmp/transpect-rng-(some numbers).txt
