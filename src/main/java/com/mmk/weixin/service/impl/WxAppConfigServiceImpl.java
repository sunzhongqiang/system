package com.mmk.weixin.service.impl;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.weixin.dao.WxAppConfigRepository;
import com.mmk.weixin.model.WxAppConfig;
import com.mmk.weixin.condition.WxAppConfigCondition;
import com.mmk.weixin.constants.WeiXinOpenParams;
import com.mmk.weixin.service.WxAppConfigService;
import com.mmk.weixin.dao.WxAppConfigDao;
/**
* WxAppConfigServiceImpl: 微信开发者账号配置 业务服务层实现
* 2016-12-22 08:39:57
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class WxAppConfigServiceImpl extends BaseServiceImpl<WxAppConfig, Long> implements WxAppConfigService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private WxAppConfigDao wxAppConfigDao;
    
    private WxAppConfigRepository wxAppConfigRepository;
    /**
    *构造方法
    * @param wxAppConfigRepository 数据容器
    */
    @Autowired
    public WxAppConfigServiceImpl( WxAppConfigRepository wxAppConfigRepository) {
        super(wxAppConfigRepository);
        this.wxAppConfigRepository = wxAppConfigRepository;
    }

    @Override
    public Page<WxAppConfig> list(WxAppConfigCondition wxAppConfigCondition, Pageable pageable) {
        log.info("微信开发者账号配置查询列表");
        return wxAppConfigDao.list(wxAppConfigCondition, pageable);
    }
    
    @Override
    public List<WxAppConfig> list(WxAppConfigCondition wxAppConfigCondition) {
        log.info("微信开发者账号配置查询列表无分页");
        return wxAppConfigDao.list(wxAppConfigCondition);
    }

    /**
     * 是否存在该
     * @param code 配置名称
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsCode(String code){
        return wxAppConfigRepository.findFirstByCode(code)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param code 配置名称
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAppConfig findByCode(String code){
         return wxAppConfigRepository.findFirstByCode(code);
    }
    @Override 
    public WxAppConfig findBy(String field,Object value){
        log.info("微信开发者账号配置根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return wxAppConfigDao.findBy(field,value);
    }
    
    @Override 
    public List<WxAppConfig> findAllBy(String field,Object value){
        log.info("微信开发者账号配置根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return wxAppConfigDao.findAllBy(field,value);
    }

	@Override
	public void refresh(String code, String value, String remark) {
		WxAppConfig config = findByCode(code);
		if(config==null){
			config = new WxAppConfig();
			config.setCode(code);
			config.setRemark(remark);
		}
		config.setModified(new Date());
		config.setValue(value);
		save(config);
	}
}