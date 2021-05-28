package cn.jast.jvm.gc;

/**
 * Created by jast90 on 2021/5/28
 */
public class ExplicitGCTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.gc();
    }
}


/**
 * -verbose:gc
 *[GC (System.gc())  1997K->536K(125952K), 0.0013920 secs]
 * [Full GC (System.gc())  536K->434K(125952K), 0.0229668 secs]
 *
 * -XX:+PrintGC
 *[GC (System.gc())  2662K->536K(125952K), 0.0012450 secs]
 * [Full GC (System.gc())  536K->410K(125952K), 0.0046909 secs]
 *
 *
 * -XX:+PrintGC -XX:+PrintGCDetails
 *[GC (System.gc()) [PSYoungGen: 2662K->528K(38400K)] 2662K->536K(125952K), 0.0015812 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 * [Full GC (System.gc()) [PSYoungGen: 528K->0K(38400K)] [ParOldGen: 8K->424K(87552K)] 536K->424K(125952K), [Metaspace: 2957K->2957K(1056768K)], 0.0046974 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
 * Heap
 *  PSYoungGen      total 38400K, used 998K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
 *   eden space 33280K, 3% used [0x0000000795580000,0x0000000795679b20,0x0000000797600000)
 *   from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
 *   to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 *  ParOldGen       total 87552K, used 424K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
 *   object space 87552K, 0% used [0x0000000740000000,0x000000074006a138,0x0000000745580000)
 *  Metaspace       used 2964K, capacity 4496K, committed 4864K, reserved 1056768K
 *   class space    used 328K, capacity 388K, committed 512K, reserved 1048576K
 *
 *
 * -XX:+PrintGC -XX:+DisableExplicitGC
 * 不会打印GC信息
 */
