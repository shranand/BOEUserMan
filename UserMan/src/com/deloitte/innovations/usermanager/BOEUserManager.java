package com.deloitte.innovations.usermanager;

import com.crystaldecisions.sdk.exception.SDKException;
import com.crystaldecisions.sdk.framework.CrystalEnterprise;
import com.crystaldecisions.sdk.framework.IEnterpriseSession;
import com.crystaldecisions.sdk.occa.infostore.IInfoObject;
import com.crystaldecisions.sdk.occa.infostore.IInfoObjects;
import com.crystaldecisions.sdk.occa.infostore.IInfoStore;
import com.crystaldecisions.sdk.occa.pluginmgr.IPluginInfo;
import com.crystaldecisions.sdk.occa.pluginmgr.IPluginMgr;
import com.crystaldecisions.sdk.plugin.desktop.user.IUser;
import com.deloitte.innovations.main.User;

public class BOEUserManager implements UserManager {

	@Override
	public void createUser() {
		// TODO Auto-generated method stub
		
		
		// Set the logon information
	    String boUser = "shranand";
	    String boPassword = "Abcd1234";
	    String boCmsName = "saintclinical01.dev.dci.local:6400";  //10.118.255.228
	    String boAuthType = "secEnterprise";

		// Declare Variables
	    IInfoStore boInfoStore=null;
		IInfoObjects boInfoObjects=null;
		SDKException failure = null;
		IEnterpriseSession boEnterpriseSession = null;
	    
		IPluginMgr boPluginMgr = null; //Plugin Manager returned from InfoStore
	   	IPluginInfo boUserPlugin = null; //User PluginInfo object
	   	IInfoObjects boNewInfoObjects = null; //new collection created from InfoStore
	   	IInfoObject boNewUser = null; //New User created
	   	IUser boUserInfo = null; //IUser interface to allow us to change user specific settings
	    
	   try{
	   	    // Logon and obtain an Enterprise Session
	    	boEnterpriseSession = CrystalEnterprise.getSessionMgr().logon( boUser, boPassword, boCmsName, boAuthType);

	        boInfoStore = (IInfoStore) boEnterpriseSession.getService("", "InfoStore");
	        
	        //Retrieve the PluginManager and use it to retrieve User plug-in.
	        boPluginMgr = boInfoStore.getPluginMgr();
	        boUserPlugin = boPluginMgr.getPluginInfo("CrystalEnterprise.User");
	        
	        //Create a new, empty InfoObjects collection.
	        boNewInfoObjects = boInfoStore.newInfoObjectCollection();
	        
	        //Add the plug-in to the collection.  This creates a new InfoObject that represents a new User
	        boNewUser = boNewInfoObjects.add(boUserPlugin);
	        
	        //Set the name and description of the User.
	        boNewUser.setTitle("New User");
	        boNewUser.setDescription("A new user created through code");

	        //cast the InfoObject as an IUser to access the User settings
	        boUserInfo = (IUser)boNewUser;
	        boUserInfo.setFullName("Business Objects");
	        boUserInfo.setConnection(IUser.CONCURRENT);
			boUserInfo.setPasswordExpiryAllowed(false);
			boUserInfo.setPasswordToChangeAtNextLogon(true);
			boUserInfo.setPasswordChangeAllowed(true);

			        //Commit the changes to the InfoStore.
	        boInfoStore.commit(boNewInfoObjects);
	        System.out.println("The New User has been created!");
	     }
	    catch(SDKException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	    finally
	    {
		   // boEnterpriseSession.logoff();
	    }
		
		
		
		
		
		
		
	}

	@Override
	public void updateUser(User tempUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User tempUser) {
		// TODO Auto-generated method stub
		
	}

}
