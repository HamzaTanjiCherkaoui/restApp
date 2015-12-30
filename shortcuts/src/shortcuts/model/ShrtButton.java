package shortcuts.model;


import java.util.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="shrtbutton")

public class ShrtButton {

    private Integer id;
    private Button button;
    private Integer sequence;
    
    
	public ShrtButton() {
    }


	public ShrtButton(Integer id, Button button, Integer sequence) {
		
		this.id = id;
		this.button = button;
		this.sequence = sequence;
	}

	@XmlElement
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement
	public Button getButton() {
		return button;
	}


	public void setButton(Button button) {
		this.button = button;
	}

	@XmlElement
	public Integer getSequence() {
		return sequence;
	}


	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	
	

}