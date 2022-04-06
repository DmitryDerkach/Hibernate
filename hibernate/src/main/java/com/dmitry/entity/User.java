package com.dmitry.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

	@Id
	private String username;
	private String firstname;
	private String lastname;
	private LocalDate birthDate;
	private Integer age;
	
//	public User() {
//		
//	}
//	
//	public User(String username, String firstname, String lastname, LocalDate birthDate, Integer age) {
//		this.username = username;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.birthDate = birthDate;
//		this.age = age;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//	
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	public String getFirstname() {
//		return firstname;
//	}
//	
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	
//	public String getLastname() {
//		return lastname;
//	}
//	
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	
//	public LocalDate getBirthDate() {
//		return birthDate;
//	}
//	
//	public void setBirthDate(LocalDate birthDate) {
//		this.birthDate = birthDate;
//	}
//	
//	public Integer getAge() {
//		return age;
//	}
//	
//	public void setAge(Integer age) {
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "User [username=" + username + ", firstname=" + firstname + ", lastname=" + lastname + ", birthDate="
//				+ birthDate + ", age=" + age + "]";
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((age == null) ? 0 : age.hashCode());
//		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
//		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
//		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		User other = (User) obj;
//		if (age == null) {
//			if (other.age != null) {
//				return false;
//			}
//		} else if (!age.equals(other.age)) {
//			return false;
//		}
//		if (birthDate == null) {
//			if (other.birthDate != null) {
//				return false;
//			}
//		} else if (!birthDate.equals(other.birthDate)) {
//			return false;
//		}
//		if (firstname == null) {
//			if (other.firstname != null) {
//				return false;
//			}
//		} else if (!firstname.equals(other.firstname)) {
//			return false;
//		}
//		if (lastname == null) {
//			if (other.lastname != null) {
//				return false;
//			}
//		} else if (!lastname.equals(other.lastname)) {
//			return false;
//		}
//		if (username == null) {
//			if (other.username != null) {
//				return false;
//			}
//		} else if (!username.equals(other.username)) {
//			return false;
//		}
//		return true;
//	}
	
}
