package com.soecode.lyf.demo.test.effectivejava.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**Comparable 接口
 * @author 魏文思
 * @date 2019/11/12$ 14:50$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User/* implements Comparable<User>*/ {
    private String name;
    private Integer age;

    /*@Override
    public int compareTo(User o) {
        if (this.age < o.getAge()) {
            return -1;
        } else if (this.getAge() > o.getAge()) {
            return 1;
        }
        return 0;
    }*/
    //重写这个方法 以后调用Colletions.sort(),不需要额外加其他参数，这样算法写在对象的属性里面，而不用在业务层
}
