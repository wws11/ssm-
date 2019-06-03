package com.soecode.lyf.bookuserservice.dao;

import com.soecode.lyf.bookuserservice.pojo.User;
import org.apache.ibatis.annotations.Param;


/**
 * @Description
 * @Author DJZ-WWS
 * @Date 2019/6/2 18:05
 */
public interface AccountDao {
    /**根据用户的id查询用户
     * @param
     * @return
     * @throws Exception
     * @author weiwensi
     * @date 8:35 2019/6/3
     * @version 2.1
     **/

   User getUserById(@Param("id") String id);
}