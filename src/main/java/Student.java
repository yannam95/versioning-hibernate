

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="student")
@DynamicUpdate
public class Student {

@Id

@Column(name="stdid")
private int id;

@Column(name="name")
private String Name;

@Column(name="major")
private String Major;

@Column(name="gpa")
private double Gpa;


public double getGpa() {
	return Gpa;
}
public void setGpa(double gpa) {
	Gpa = gpa;
}
@Version
@Column(name="version")
private int version;


public int getVersion() {
	return version;
}
public void setVersion(int version) {
	this.version = version;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getMajor() {
	return Major;
}
public void setMajor(String major) {
	Major = major;
}





}
