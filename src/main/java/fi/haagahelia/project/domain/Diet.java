package fi.haagahelia.project.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Diet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long dietid;
	private String dname;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "diet")
	private List<Recipe> recipes;
	
	public Diet() {}

	public Diet(String dname) {
		super();
		this.dname = dname;
	}

	public Long getDietid() {
		return dietid;
	}

	public void setDietid(Long dietid) {
		this.dietid = dietid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Diet [dietid=" + dietid + ", dname=" + dname + ", recipes=" + recipes + "]";
	}

}
