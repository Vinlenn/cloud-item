package com.vinlen.cloudStore.service;

import com.vinlen.cloudStore.common.AppException;
import com.vinlen.cloudStore.common.ExceptionEnum;
import com.vinlen.cloudStore.mapper.SpecGroupMapper;
import com.vinlen.cloudStore.pojo.SpecGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecService {
	@Resource
	private SpecGroupMapper groupMapper;

	public List<SpecGroup> queryGroupByCategory(Long id) {
		// 查询规格组
		SpecGroup s = new SpecGroup();
		s.setCid(id);
		List<SpecGroup> list = groupMapper.select(s);
		if (CollectionUtils.isEmpty(list)) {
			throw new AppException(ExceptionEnum.BRAND_NOT_FOUND);
		}
		return list;
	}
}
