package shortcuts.model;


import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="button")
public class Button {

	private Integer id;
    private String code;
    private Integer type; 
    
    
    public Button() {
    }

	public Button(Integer id, String code, Integer type) {
		super();
		this.id = id;
		this.code = code;
		this.type = type;
	}
	@XmlElement
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	@XmlElement
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	    

}