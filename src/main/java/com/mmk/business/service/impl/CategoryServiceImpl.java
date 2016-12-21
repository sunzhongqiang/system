package com.mmk.business.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.CategoryCondition;
import com.mmk.business.dao.CategoryDao;
import com.mmk.business.dao.CategoryRepository;
import com.mmk.business.model.Category;
import com.mmk.business.service.CategoryService;
import com.mmk.common.model.Tree;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
* CategoryServiceImpl: 商品分类 业务服务层实现
* 2016-11-29 13:54:25
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long> implements CategoryService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private CategoryDao categoryDao;
    
    private CategoryRepository categoryRepository;
    /**
    *构造方法
    * @param categoryRepository 数据容器
    */
    @Autowired
    public CategoryServiceImpl( CategoryRepository categoryRepository) {
        super(categoryRepository);
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> list(CategoryCondition categoryCondition, Pageable pageable) {
        log.info("商品分类查询列表");
        return categoryDao.list(categoryCondition, pageable);
    }
    
    @Override
    public List<Category> list(CategoryCondition categoryCondition) {
        log.info("商品分类查询列表无分页");
        return categoryDao.list(categoryCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     */
    @Override
    public List<Category>  findAllByParentId(Long parentId){
        return categoryRepository.findAllByParentId(parentId);
    }
    
     @Override
    public Page<Category>  findAllByParentId(Long parentId, Pageable pageable){
        return categoryRepository.findAllByParentId(parentId,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param name 分类名称
     * @return 符合条件的唯一对象
     */
    @Override
    public Category findByName(String name){
         return categoryRepository.findFirstByName(name);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param path 分类路径
     * @return 符合条件的所有对象
     */
    @Override
    public List<Category>  findAllByPath(String path){
        return categoryRepository.findAllByPath(path);
    }
    
     @Override
    public Page<Category>  findAllByPath(String path, Pageable pageable){
        return categoryRepository.findAllByPath(path,pageable);
    }
    @Override 
    public Category findBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return categoryDao.findBy(field,value);
    }
    
    @Override 
    public List<Category> findAllBy(String field,Object value){
        log.info("商品分类根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return categoryDao.findAllBy(field,value);
    }

	@Override
	public List<CategoryCondition> treeGrid(CategoryCondition categoryCondition) {
		List<Category> categories = categoryDao.findAllBy(categoryCondition);
		
		List<CategoryCondition> temp = new ArrayList<CategoryCondition>();
		List<CategoryCondition> result = new ArrayList<CategoryCondition>();
		Map<Long,CategoryCondition> helpMap = new HashMap<Long,CategoryCondition>();
		
		for (Category category : categories) {
			CategoryCondition condition = new CategoryCondition();
			BeanUtils.copyProperties(category, condition);
			helpMap.put(category.getId(), condition);
			temp.add(condition);
		}
		
		for (CategoryCondition category : temp) {
			CategoryCondition parent = helpMap.get(category.getParentId());
			if(parent!=null){
				parent.getChildren().add(category);
			}else{
				result.add(helpMap.get(category.getId()));
			}
		}
		
		return result;
	}

	@Override
	public List<Tree> tree(CategoryCondition categoryCondition) {
		List<Category> categories = categoryDao.findAllBy(categoryCondition);

		List<Tree> temp = new ArrayList<Tree>();
		List<Tree> result = new ArrayList<Tree>();
		Map<Long, Tree> helpMap = new HashMap<Long, Tree>();

		for (Category category : categories) {
			Tree condition = new Tree();
			condition.setId(String.valueOf(category.getId()));
			condition.setPid(String.valueOf(category.getParentId()));
			condition.setText(category.getName());
			helpMap.put(category.getId(), condition);
			temp.add(condition);
		}

		for (Tree category : temp) {
			Tree parent = helpMap.get(category.getPid());
			if (parent != null) {
				parent.getChildren().add(category);
			} else {
				result.add(helpMap.get(category.getId()));
			}
		}

		return result;
	}

	@Override
	public List<Category> findChildrenByPath(String path) {
		return categoryDao.findChildrenByPath(path);
	}
	
	@Override
	public Category save(Category category) {
		if(category.getParentId()!=null){
    		Category parent = find(category.getParentId());
    		if(parent!=null){
    			category.setPath(parent.getPath()+parent.getId()+"/");
    		}else{
    			category.setPath("/");
    		}
    	}else{
    		category.setPath("/");
    	}
		return super.save(category);
	}
	
	@Override
	public void delete(Category entity) {
		entity = find(entity.getId());
		String path = entity.getPath()+entity.getId()+"/";
		List<Category> categories = findChildrenByPath(path);
		delete(categories);
		super.delete(entity);
	}
}