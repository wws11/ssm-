package com.soecode.lyf.demo.test.effectivejava;

/**
 * effective java  17 最小可变性
 * 对于一些公共类的设计
 *公共类直接暴露属性并不是一个好主意，但是属性不可变危害就没有那么大了。
 * 当一个属性是只读的时候，除了更改类的API之外，你不能改变类的内部表示形式，也不能采取一些辅助的行为，但是可以加强不变性。例如，下面的例子中保证每个实例表示一个有效的时间
 * @author 魏文思
 * @date 2019/11/12$ 16:05$
 */
public class MinChange17 {
    //总之公共类不应该暴露不可变属性的危害虽然仍然存在问题，但其危害较小。
    //然而有时候需要包级别或者私有内部类来暴露属性，无论此类是否是可变的。
    // 关于使用内部类暴露属性的研究后面在研究再次记录一下！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！重要重要

    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    public final int hour;
    public final int minute;

    public MinChange17(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY)
        {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        if (minute < 0 || minute >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Min: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
    //TODO 是一种程序员应该认为做，但由于某些原因目前还没做的工作。
    /**
     * effective java 17条最小可变性
     * 1.不提供修改对象的状态的方法
     * 2.确保这个类不能被继承
     * 3.把所有属性设置为final
     * 4.把所有的属性设置为private
     * 5.确保对任何可变组件的互斥访问
     *   如果你的类汇有任何引用可变对象的属性，请确保该类的客户端无法获得对这些对象的引用。
     *
     *   特点：
     *     不可变对象本质上是线程安全的；他们不需要同步
     *     不仅可以共享不可变的对象，而且可以共享内部信息
     *     不可变对象为其他对象提供了很好的构建
     *     不可变对象提供了免费的原子失败机制
     *     不可变类的主要缺点是对于每个不同的值都需要一个单独的对象
     *
     */

}
