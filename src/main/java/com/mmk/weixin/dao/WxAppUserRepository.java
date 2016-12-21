/*
 *  WxAppUserRepository 创建于 2016-12-21 15:42:41 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.weixin.model.WxAppUser;

/**
* WxAppUserRepository: 微信公众号的用户 数据资源层
* 2016-12-21 15:42:41
* @author 
* @version 1.0
*/
public interface WxAppUserRepository extends JpaRepository<WxAppUser, Long>{

    /**
     *  根据给定的字段：appid 公众号ID获取所有符合的记录
     * @param appid 公众号ID
     * @return 符合条件的所有对象
     * @author 
     * 
     */
    List<WxAppUser> findAllByAppid(String appid);
    /**
     *  根据给定的字段：appid 公众号ID所有符合的记录
     * @param appid 公众号ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 
     * 
     */
    Page<WxAppUser> findAllByAppid(String appid,Pageable pageable);
    /**
     *  根据给定的字段：openid 窗口id返回符合条件的第一个对象
     * @param openid 窗口id
     * @return 符合条件的唯一对象
     * @author 
     * 
     */
    WxAppUser findFirstByOpenid(String openid);
    /**
     *  根据给定的字段：nickname 昵称返回符合条件的第一个对象
     * @param nickname 昵称
     * @return 符合条件的唯一对象
     * @author 
     * 
     */
    WxAppUser findFirstByNickname(String nickname);

}