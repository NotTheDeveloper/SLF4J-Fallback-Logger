/**
 * A fallback logger for SLF4J, which triggers if there is no 'StaticLoggerBinder' or 'ServiceProvider' implementation.
 */
module slf4jfbl {
    requires org.slf4j;
    requires org.apache.commons.collections4;

    requires com.google.errorprone.annotations;
    requires org.jetbrains.annotations;

    exports dev.blocky.library.logging;
}
