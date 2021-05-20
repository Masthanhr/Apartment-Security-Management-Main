package com.cg.aps.entities;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.Id;
	import javax.persistence.Inheritance;
	import javax.persistence.InheritanceType;
	import javax.persistence.Table;
	import javax.validation.constraints.NotEmpty;
	


	@Entity
	@Table(name = "adminentity")
	@Inheritance(strategy = InheritanceType.JOINED)
	public class Admin {
		@Id
		@NotEmpty
		
		@GeneratedValue
		private int adminId;
		@NotEmpty(message = "Password must not be empty")
	
		private String password;
		@NotEmpty(message = "RoleId must not be empty")
		private String roleId;
		
		private int attempts;
		
		public int getAdminId() {
			return adminId;
		}
		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRoleId() {
			return roleId;
		}
		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}
		public int getAttempts() {
			return attempts;
		}
		public void setAttempts(int attempts) {
			this.attempts = attempts;
		}
		public Admin() {
			super();
		}
		public Admin(String password, String roleId) {
			super();
			this.password = password;
			this.roleId = roleId;
		}
		public Admin(int adminId, String password, String roleId) {
			super();
			this.adminId = adminId;
			this.password = password;
			this.roleId = roleId;
		}
		public Admin(int adminId, String password, String roleId, int attempts) {
			super();
			this.adminId = adminId;
			this.password = password;
			this.roleId = roleId;
			this.attempts = attempts;
		}
	}


