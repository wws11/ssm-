package com.soecode.lyf.demo.test.effectivejava.code20;

import java.util.Map;
import java.util.Objects;

/**
 * @author 魏文思
 * @date 2019/11/12$ 17:37$
 */
public abstract class AbstractMapEntry20<K, V> implements Map.Entry<K, V> {

    public AbstractMapEntry20() {
        super();
    }

    /**
     * 由于不允许为object类方法提供默认实现，因此所有实现均放置在骨架实现类中
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Map.Entry)) return false;
        Map.Entry<?, ?> e = (Map.Entry) o;
        return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public K getKey() {
        return null;
    }

    @Override
    public V getValue() {
        return null;
    }

    @Override
    public V setValue(V value) {
        return null;
    }
}
