package shortcuts.model;


import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *  
 */
@XmlRootElement(name="shortcut")

public class Shortcut {

    private Integer id;
    private String description;
    private Integer rating;
    private ArrayList<ShrtButton> shrtButtons;
    private ArrayList<Tag> tags;
	/**
     * Default constructor
     */
    public Shortcut() {
    }

	

	public Shortcut(Integer id, String description, Integer rating,
			ArrayList<ShrtButton> shrtButtons, ArrayList<Tag> tags) {
		
		this.id = id;
		this.description = description;
		this.rating = rating;
		this.shrtButtons = shrtButtons;
		this.tags = tags;
	}


	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@XmlElement
	public ArrayList<ShrtButton> getShrtButtons() {
		return shrtButtons;
	}

	public void setShrtButtons(ArrayList<ShrtButton> shrtButtons) {
		this.shrtButtons = shrtButtons;
	}


	@XmlElement
	public ArrayList<Tag> getTags() {
		return tags;
	}


	
	public void setTags(ArrayList<Tag> tags) {
		this.tags = tags;
	}
	
    
    
}