package fi.haagahelia.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String title;
    private String samplepicture;
   
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "dietid")
    private Diet diet;

    public Recipe() {}
    	

	public Recipe(String title, String samplepicture, Category category, Diet diet) {
		super();
		this.title = title;
		this.samplepicture = samplepicture;
		this.category = category;
		this.diet = diet;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}


	public String getSamplepicture() {
		return samplepicture;
	}
	public void setSamplepicture(String samplepicture) {
		this.samplepicture = samplepicture;
	}


	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}


	public Diet getDiet() {
		return diet;
	}
	public void setDiet(Diet diet) {
		this.diet = diet;
	}


	@Override
	public String toString() {
		if (this.category != null || this.diet != null)
		return "Recipe [id=" + id + ", title=" + title + ", samplepicture=" + samplepicture + ", category=" + category
				+ ", diet=" + diet + "]";
		else
			return "Recipe [id=" + id + ", title=" + title + ", samplepicture=" + samplepicture + "]";

	}
}


	

