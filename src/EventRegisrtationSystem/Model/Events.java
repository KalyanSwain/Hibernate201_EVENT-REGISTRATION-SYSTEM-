package EventRegisrtationSystem.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="EVENTS")
public class Events {
	
	@Id
	@Column(name="EVENT_ID")
	@GeneratedValue
	private Long eventId;
	
	@Column(name="EVENT_TITLE",unique=true)
	String eventtitle;
	@Column(name="DESCRIPTION")
	String description;
	@ManyToMany(mappedBy="event")
	private Set<Employee> emp=new HashSet<Employee>();
	
	public Events(){
		
	}
	
	public Events(String eventtitle, String description) {
		super();
		this.eventtitle = eventtitle;
		this.description = description;
	}
	public Set<Employee> getEmp() {
		return emp;
	}
	public void setEmp(Set<Employee> emp) {
		this.emp = emp;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getEventtitle() {
		return eventtitle;
	}
	public void setEventtitle(String eventtitle) {
		this.eventtitle = eventtitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result
				+ ((eventtitle == null) ? 0 : eventtitle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Events other = (Events) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (eventtitle == null) {
			if (other.eventtitle != null)
				return false;
		} else if (!eventtitle.equals(other.eventtitle))
			return false;
		return true;
	}

}
