package cn.jast.jvm.gcroot;

/**
 * Held by JVM - objects held from garbage collection by JVM for its purposes.
 * Actually the list of such objects depends on JVM implementation.
 * Possible known cases are: the system class loader, a few important exception classes which the JVM knows about,
 * a few pre-allocated objects for exception handling, and custom class loaders when they are in the process of loading classes.
 * Unfortunately, JVM provides absolutely no additional detail for such objects. Thus it is up to the analyst to decide to which case a certain "Held by JVM" belongs.
 *
 * Created by jast90 on 2021/1/9
 */
public class GCRootHeldByJVM {


}
