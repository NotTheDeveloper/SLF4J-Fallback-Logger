/**
 * Root package of all logging utils.
 * <br>From here you can navigate to all logging utils.
 *
 * <ul>
 * <li>{@link dev.blocky.library.logging.SimpleLogger}
 * <br>A custom {@link dev.blocky.library.logging.SimpleLogger}. (from
 * <a href="https://www.slf4j.org/api/org/slf4j/simple/SimpleLogger.html">slf4j-simple</a>).</li>
 *
 * <li>{@link dev.blocky.library.logging.FallbackLogger}
 * <br>This class serves as a {@link org.slf4j.LoggerFactory}..
 * <br>It will either return a logger from a SLF4J implementation via {@link org.slf4j.LoggerFactory} if present,
 * or an instance of a custom {@link dev.blocky.library.logging.SimpleLogger}. (from slf4j-simple)
 * <br>It also has the utility method {@link dev.blocky.library.logging.FallbackLogger#getLazyString(FallbackLogger.LazyEvaluation)}
 * which is used to lazily construct strings for logging.</li>
 * </ul>
 */
package dev.blocky.library.logging;