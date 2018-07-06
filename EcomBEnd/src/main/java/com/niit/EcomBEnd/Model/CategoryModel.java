package com.niit.EcomBEnd.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity	
@Table()
public class CategoryModel implements Serializable
{

	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="categoryid")
	private int categoryid;
	@Column(name="categoryname")
	private String categoryname;
	 @OneToMany(targetEntity=ProductModel.class, mappedBy="categoryid", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
		@Column(name="setofproducts")
	private Set<ProductModel> setofproducts;
	
	
	
	
	public CategoryModel() {
		super();
	}
	public CategoryModel(int categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
		public Set<ProductModel> getSetofproducts() {
			return setofproducts;
		}
		
		public void setSetofproducts(Set<ProductModel> setofproducts) {
			this.setofproducts = setofproducts;
		}
		public void setCategoryDesc(String string) {
			// TODO Auto-generated method stub
			
		}
	
	
	

}
