package shortcuts.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import shortcuts.model.Button;
import shortcuts.model.Shortcut;
import shortcuts.model.ShrtButton;
import shortcuts.model.Tag;



@Path("shortcuts")
public class ShortcutService {
static final String api_version = "1.01A rev.18729";
	
	static String xmlString = null;
	static Map<Integer, Shortcut> shortcuts = new HashMap<Integer, Shortcut>();
	
	
	static
	{
		System.out.println("Initializing Internal DataStore/DB...");
		ArrayList<ShrtButton> shrtbtns = new ArrayList<ShrtButton>();
		ArrayList<ShrtButton> shrtbtns2 = new ArrayList<ShrtButton>();
		ArrayList<Tag> tags = new ArrayList<Tag>();
		
		shrtbtns.add(new ShrtButton(2, new Button(1,"ctrl",1), 1));
		shrtbtns.add(new ShrtButton(2, new Button(2,"c",1), 2));
		
		tags.add(new Tag(1, "windows", null));
		tags.add(new Tag(2, "daily use", null));
		
		Shortcut s = new Shortcut(1, "shortcut to copy text ", 44, shrtbtns, tags);
		shortcuts.put(1, s);
		shrtbtns2.add(new ShrtButton(2, new Button(1,"ctrl",1), 1));
		shrtbtns2.add(new ShrtButton(3, new Button(3,"v",1), 2));
		Shortcut s2 = new Shortcut(1, "shortcut to paste text ", 44, shrtbtns2, tags);
		shortcuts.put(2	, s2);
		
		
	}
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Shortcut> getAllshortcuts() {
		System.out.println("Getting all shortcuts...");
		ArrayList<Shortcut> shrtList = new ArrayList<Shortcut>(shortcuts.values());
		return shrtList;
	}

	//get shortcut by id 
	
	@Path("{id}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Shortcut getshortcut(@PathParam("id")int id) {
		System.out.println("Getting shortcuts by id:"+id);
		return shortcuts.get(id);
	}

	@GET @Path("/tag/{tag}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ArrayList<Shortcut>  getShortcutByTag(@PathParam("tag")String tag) {
		System.out.println("Getting shortcuts by tag:"+tag);
		List<Shortcut> shrtList = new ArrayList<Shortcut>(shortcuts.values());
		ArrayList<Shortcut> list = new ArrayList<Shortcut>();
for (Shortcut shortcut : shrtList) {
	for (Tag t : shortcut.getTags()) {
		
		if(t.getTag().equals(tag))
		{
			list.add(shortcut);
			break;
		}
		
	}


}

		return list;
	}
	
	//create shortcut 
	@POST
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Shortcut newshortcut(Shortcut s) {
		shortcuts.put(s.getId(), s);
		return s;
	}
	
	//update shortcut
	@Path("{id}")
	@PUT
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Shortcut updateshortcut(Shortcut shortcut) {
		System.out.println("updating shortcut with ID: " + shortcut.getId());
		shortcuts.remove(shortcut.getId());
		shortcuts.put(shortcut.getId(), shortcut);
		//shortcuts.get(shortcut.getId()).setTask(shortcut.getTask());
		return shortcut;
	}
	
	
	//delete shortcut
	@Path("{id}")
	@DELETE
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Shortcut deleteshortcut(@PathParam("id") int id) {
	  System.out.println("Deleting shortcut with ID: " + id);
		
	  Shortcut shortcut = shortcuts.remove(id);
	  
	  return shortcut;
	}

	
}
