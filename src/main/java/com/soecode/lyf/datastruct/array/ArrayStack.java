package com.soecode.lyf.datastruct.array;

/**  基于数组实现的栈数据结构
 * @author 魏文思
 * @date 2019/8/30$ 16:08$
 */
public class ArrayStack <E>{

private   Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<>(capacity);
    }

    //获取栈的长度
    public int getSize(){
        return array.getSize();
    }
    //判断栈的数据是否为空
    public boolean isEmpty(){
        return array.isEmpty();
    }
    //获取栈的容量
    public int getCapacity(){
        return array.getCapacity();
    }
    //入栈
    public  void push (E e){
        array.addLast(e);
    }
    //出栈
    public  E  pop(){
       return array.removeLast();
    }
    //获取栈顶的数据
    public E peek(){
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
    public static void main(String[] args) {
        ArrayStack<String> stringArrayStack = new ArrayStack<>(5);
        stringArrayStack.push("a");
        stringArrayStack.push("b");
        stringArrayStack.push("c");
        stringArrayStack.push("d");
        stringArrayStack.push("e");
        stringArrayStack.push("f");
        stringArrayStack.push("g");
        stringArrayStack.push("h");
        stringArrayStack.push("i");
        stringArrayStack.push("j");
        System.out.println("============================栈里全部的数据");
        System.out.println(stringArrayStack.toString());
        System.out.println("============================数据出栈");
        System.out.println(stringArrayStack.pop());
        System.out.println("============================栈顶数据");
        System.out.println(stringArrayStack.peek());
    }
}
