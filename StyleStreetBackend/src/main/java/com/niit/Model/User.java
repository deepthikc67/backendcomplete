package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class User {
	


		@Id
		@GeneratedValue
		private int UserID;
		private String  UserName;			
		private String  Password;
		private int  MobileNO;
		private String  UserAddress;
		public int getUserID() {
			return UserID;
		}
		public void setUserID(int userID) {
			UserID = userID;
		}
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public int getMobileNO() {
			return MobileNO;
		}
		public void setMobileNO(int mobileNO) {
			MobileNO = mobileNO;
		}
		public String getUserAddress() {
			return UserAddress;
		}
		public void setUserAddress(String userAddress) {
			UserAddress = userAddress;
		}
		
		
		

}

