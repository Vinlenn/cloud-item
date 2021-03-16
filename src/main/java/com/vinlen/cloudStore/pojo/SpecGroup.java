package com.vinlen.cloudStore.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_spec_group")
@Data
//商品规格
public class SpecGroup {

	@Id
	@KeySql(useGeneratedKeys = true)
	private Long id;

	private Long cid;

	private String name;

	private String createTime;

	private String updateTime;
}
