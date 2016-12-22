/*
 *  WxAppConfigRepository 创建于 2016-12-22 08:39:57 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.weixin.model.WxAppConfig;

/**
* WxAppConfigRepository: 微信开发者账号配置 数据资源层
* 2016-12-22 08:39:57
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface WxAppConfigRepository extends JpaRepository<WxAppConfig, Long>{

    /**
     *  根据给定的字段：code 配置名称返回符合条件的第一个对象
     * @param code 配置名称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAppConfig findFirstByCode(String code);

}