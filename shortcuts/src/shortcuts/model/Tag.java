package shortcuts.model;


import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="tag")
public class Tag {
	
    private Integer id;
    private String tag;
    private ArrayList<Shortcut> shortcuts;
    
	public Tag() {
    }

	public Tag(Integer id, String tag, ArrayList<Shortcut> shortcuts) {
		super();
		this.id = id;
		this.tag = tag;
		this.shortcuts = shortcuts;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@XmlElement
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	@XmlElement
	public ArrayList<Shortcut> getShortcuts() {
		return shortcuts;
	}

	public void setShortcuts(ArrayList<Shortcut> shortcuts) {
		this.shortcuts = shortcuts;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final Tag other = (Tag) obj;
	    if ((this.tag == null) ? (other.tag != null) : !this.tag.equals(other.tag)) {
	        return false;
	    }
	    if (this.tag != other.tag) {
	        return false;
	    }
	    return true;
	}




}