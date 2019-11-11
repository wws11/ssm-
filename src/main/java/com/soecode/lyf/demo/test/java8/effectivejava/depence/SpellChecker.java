package com.soecode.lyf.demo.test.java8.effectivejava.depence;

import java.util.Objects;
import java.util.function.Supplier;

/**
 * effective Java 第五讲 依赖注入优于硬件连接  Harding resources
 * @author 魏文思
 * @date 2019/11/11$ 15:44$
 */
public class SpellChecker {

    private   final Lexicon dictionary;

    /*public  SpellChecker(Lexicon lexicon){
        this.dictionary=Objects.requireNonNull(lexicon);
    }
    */
    // 将参数包装一次 使用Java8的supply接口，创建任意类型的子类型
    public  SpellChecker(Supplier<? extends Lexicon> lexicon){
        this.dictionary=Objects.requireNonNull(lexicon.get());
    }

    /**
     * 依赖注入的灵活变体
     * @param args
     */
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(() -> Lexicon.builder().adress("").name("").build());
    }
}
