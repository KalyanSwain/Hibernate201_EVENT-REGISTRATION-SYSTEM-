package EventRegisrtationSystem.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee {
	@Id
	@Column(name="MID" )
	String MID;
	@Column(name="NAME")
	String Name;
	@Column(name="JOIN_DATE")
	Date JoinDate;
	@Column(name="EMAIL_ID")
	String EmailID;
	@ManyToMany
	@JoinTable(name="EVENT_MANAGER",
			joinColumns={@JoinColumn(name="EMPLOYEE_ID")},
			inverseJoinColumns={@JoinColumn(name="EVENT_ID")})
	private Set<Events> event=new HashSet<Events>();
	
	
	public Employee(){
		
	}
	
	public Employee(String mID, String name, Date joinDate, String emailID) {
		super();
		MID = mID;
		Name = name;
		JoinDate = joinDate;
		EmailID = emailID;
	}
	public Set<Events> getEvent() {
		return event;
	}
	public void setEvent(Set<Events> event) {
		this.event = event;
	}
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}
	public String getEmailID() {
		return EmailID;
	}
	public void setEmailID(String emailID) {
		EmailID = emailID;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((EmailID == null) ? 0 : EmailID.hashCode());
		result = prime * result
				+ ((JoinDate == null) ? 0 : JoinDate.hashCode());
		result = prime * result + ((MID == null) ? 0 : MID.hashCode());
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
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
		Employee other = (Employee) obj;
		if (EmailID == null) {
			if (other.EmailID != null)
				return false;
		} else if (!EmailID.equals(other.EmailID))
			return false;
		if (JoinDate == null) {
			if (other.JoinDate != null)
				return false;
		} else if (!JoinDate.equals(other.JoinDate))
			return false;
		if (MID == null) {
			if (other.MID != null)
				return false;
		} else if (!MID.equals(other.MID))
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		return true;
	}
	
	
	

}
