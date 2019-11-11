package com.soecode.lyf.demo.datastruct.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魏文思
 * @date 2019/8/30$ 17:04$
 */
public class Link<E> {
    private Node head;
    private int size;

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }




    public static void main(String[] args) {


        List<String> list=new ArrayList<>();
        list.add("ssss");
        list.add("sffff");
        list.add("dfsfdfs");
        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){

            String next = iterator.next();

            iterator.forEachRemaining(e->{
                System.out.println("cousume:---->>>> "+e);
            });
            System.out.println(next);
        }*/
        list.remove("ssss");
        System.out.println(list.toString());
    }

}
