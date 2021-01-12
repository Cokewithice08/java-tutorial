package cn.jast.jvm.gcroot;

/**
 *
 * Class - class loaded by system class loader. Such classes can never be unloaded.
 * They can hold objects via static fields. Please note that classes loaded by custom class loaders are not roots,
 * unless corresponding instances of java.lang.Class happen to be roots of other kind(s).
 *
 * Created by jast90 on 2021/1/9
 */
public class GCRootClass {
}
