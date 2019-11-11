package com.soecode.lyf.design.adapter.itemobject;

import com.soecode.lyf.design.adapter.Phone;
import com.soecode.lyf.design.adapter.Vga;

/**
 * 对象的适配器模式
 * 适配器 通过继承。实现的方式，既可以实现手机的功能也保留适配器本身的功能
 *
 * @author 魏文思
 * @date 2019/11/8$ 10:52$
 */
public class VgaObjectAdapter extends Phone implements Vga {

    @Override
    public void vgaInterface() {
        typePhone();
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }

    public static void main(String[] args) {
        VgaObjectAdapter vga1 = new VgaObjectAdapter();
        vga1.vgaInterface();
    }
}
