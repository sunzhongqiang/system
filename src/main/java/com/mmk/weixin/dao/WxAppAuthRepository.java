/*
 *  WxAuthAppRepository 创建于 2016-12-21 11:14:34 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.weixin.model.WxAppAuth;

/**
* WxAuthAppRepository: 微信授权APP 数据资源层
* 2016-12-21 11:14:34
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface WxAppAuthRepository extends JpaRepository<WxAppAuth, Long>{

    /**
     *  根据给定的字段：authorizerAppid 授权方appid返回符合条件的第一个对象
     * @param authorizerAppid 授权方appid
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAppAuth findFirstByAuthorizerAppid(String authorizerAppid);
    /**
     *  根据给定的字段：modified 更新时间获取所有符合的记录
     * @param modified 更新时间
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<WxAppAuth> findAllByModified(Date modified);
    /**
     *  根据给定的字段：modified 更新时间所有符合的记录
     * @param modified 更新时间
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<WxAppAuth> findAllByModified(Date modified,Pageable pageable);
    /**
     *  根据给定的字段：nickName 昵称返回符合条件的第一个对象
     * @param nickName 昵称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAppAuth findFirstByNickName(String nickName);

}