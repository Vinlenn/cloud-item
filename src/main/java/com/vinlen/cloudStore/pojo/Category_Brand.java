package com.vinlen.cloudStore.pojo;

import lombok.Data;

import javax.persistence.Table;
@Data
@Table(name="tb_category_brand")
public class Category_Brand {

	private Long category_id;
	private Long brand_id;

}
