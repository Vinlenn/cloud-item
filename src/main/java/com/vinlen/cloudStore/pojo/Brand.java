package com.vinlen.cloudStore.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_brand")
//品牌类
public class Brand {
	@Id
	@KeySql(useGeneratedKeys = true)
	private Long id;
	private String name;
	private String image;
	private Character letter;
	private String createTime;
	private String updateTime;
}