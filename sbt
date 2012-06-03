java -Xmx1G -XX:MaxPermSize=128M -Xss2M -XX:+CMSClassUnloadingEnabled -jar `dirname $0`/sbt-launcher.jar "$@"
