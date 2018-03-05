 /*import java.io.BufferedWriter;
import java.io.FileWriter;*/
import java.io.IOException;
import java.io.UnsupportedEncodingException;
/*import java.net.URI;
import java.net.URL;*/
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.swing.text.StyledEditorKit.BoldAction;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.StatusType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class automateTestMainClass {
	/*
	 * try { System.out.println(URLEncoder.encode("String with spaces",
	 * "UTF-8")); System.out.println(URLEncoder.encode("special chars: &%*$",
	 * "UTF-8")); } catch (UnsupportedEncodingException ex) {
	 * ex.printStackTrace(); }
	 */
	//service/xusers/secure/users/20
	private static String UrlPrefix_XUserREST = "/service/xusers";
	//private static String UrlPrefix_UserREST = "/service/users";
	private static final String policyMgrBaseUrl = "http://localhost:6080";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/ranger";
	static final String USER = "root";
	static final String PASS = "root";
	
	private static Map<Integer, String> specialCharMap = new HashMap<Integer, String>();
	private static Connection conn = null;
	private static PreparedStatement stmt = null;
	public static void main(String a[]) throws IOException, ClassNotFoundException, SQLException {
		automateTestMainClass obj = new automateTestMainClass();
		
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);

		//boolean logDetail = true;

		
		//obj.preRequisites();
		 
		// for create users //post
		
		List<VXUser> UserList1 = new ArrayList<VXUser>();
		List<VXUser> UserList2 = new ArrayList<VXUser>();
		VXUser vxuserAdmin = new VXUser();
		vxuserAdmin.setName("admin");
		vxuserAdmin.setPassword("admin");
		List<String> userRoleList1 = new ArrayList<String>();
		userRoleList1.add("ROLE_SYS_ADMIN");
		vxuserAdmin.setUserRoleList(userRoleList1);
		UserList1.add(vxuserAdmin);
		VXUser vxuserKeyAdmin = new VXUser();
		vxuserKeyAdmin.setName("keyadmin");
		vxuserKeyAdmin.setPassword("keyadmin");
		List<String> userRoleListkeyadmin = new ArrayList<String>();
		userRoleListkeyadmin.add("ROLE_KEY_ADMIN");
		vxuserKeyAdmin.setUserRoleList(userRoleListkeyadmin);
		UserList1.add(vxuserKeyAdmin);
		
		List<String> role = new ArrayList<String>();
		role.add("ROLE_SYS_ADMIN");
		role.add("ROLE_USER");
		role.add("ROLE_ADMIN_AUDITOR");
		List<String> role2 = new ArrayList<String>();
		
		role2.add("ROLE_KEY_ADMIN");
		role2.add("ROLE_KEY_ADMIN_AUDITOR");
	//create users with roles 1 users 1 admin 1 keyadmin 1 admin auditor
		for(String roleName:role){
			System.out.println("role==roleName=======1=>"+roleName);
			List<String> userRoleList = new ArrayList<String>();
			userRoleList.add(roleName);
			
            List<String> existingRole = (List<String>) vxuserAdmin.getUserRoleList();
				if(roleName.equalsIgnoreCase("ROLE_USER")){
					for (int i = 1; i <= 3; i++) {
						VXUser vXUser = new VXUser();
						vXUser.setIsVisible(1);
						
						vXUser.setPassword("user1234");
						vXUser.setUserRoleList(userRoleList);
						vXUser.setName("fatima"+roleName);
						vXUser.setFirstName("f" + vXUser.getName());
						vXUser.setLastName("l" + vXUser.getName());
						
						vXUser.setName("fatima"+roleName);
						vXUser.setName(vXUser.getName()+i);
						System.out.println(vXUser);
						UserList2.add(vXUser);
						System.out.println("userLISTWWWWWWWWW----------"+UserList2.toString());
						obj.secureCreateXUser(UrlPrefix_XUserREST + "/secure/users", vXUser,vxuserAdmin.getName(),vxuserAdmin.getPassword(),existingRole.get(0),userRoleList.get(0),userRoleList.get(0));
					}
				} else if(roleName.equalsIgnoreCase("ROLE_ADMIN_AUDITOR")){
					
						VXUser vXUser = new VXUser();
						vXUser.setIsVisible(1);
						
						vXUser.setPassword("user1234");
						vXUser.setUserRoleList(userRoleList);
						vXUser.setName("fatima"+roleName);
						vXUser.setFirstName("f" + vXUser.getName());
						vXUser.setLastName("l" + vXUser.getName());
						
						vXUser.setName("fatima"+roleName);
						vXUser.setName(vXUser.getName());
						System.out.println(vXUser);
						obj.secureCreateXUser(UrlPrefix_XUserREST + "/secure/users",vXUser, vxuserAdmin.getName(),vxuserAdmin.getPassword(),existingRole.get(0),userRoleList.get(0),userRoleList.get(0));
						UserList2.add(vXUser);
						System.out.println("userLISTWWWWWWWWW====="+UserList2.toString());
					
			}else if(roleName.equalsIgnoreCase("ROLE_SYS_ADMIN")) {
				VXUser vXUser = new VXUser();
				vXUser.setIsVisible(1);
				
				vXUser.setPassword("user1234");
				vXUser.setUserRoleList(userRoleList);
				vXUser.setName("fatima"+roleName);
				vXUser.setFirstName("f" + vXUser.getName());
				vXUser.setLastName("l" + vXUser.getName());
				
				obj.secureCreateXUser(UrlPrefix_XUserREST + "/secure/users", vXUser, vxuserAdmin.getName(),vxuserAdmin.getPassword(),existingRole.get(0),userRoleList.get(0),userRoleList.get(0));
					System.out.println(vXUser);
					UserList2.add(vXUser);
					
				}
			}
		
		boolean keadminflag=true;
		
		for(String rolekey:role2){
			
			for(int i=0;i<UserList2.size();i++){				
				VXUser vXUser = UserList2.get(i);
				Collection<String> existingrole=vXUser.getUserRoleList();
					
					if(keadminflag){
						if(rolekey.equalsIgnoreCase("ROLE_KEY_ADMIN") && existingrole.contains("ROLE_USER") ){
							List<String> updateROLELsit = new ArrayList<String>();
							updateROLELsit.add(rolekey);
							vXUser.setUserRoleList(updateROLELsit);
							UserList2.get(i).setUserRoleList(updateROLELsit);
							 List<String> keyadminRole = (List<String>) vxuserKeyAdmin.getUserRoleList();
							 
							obj.updateSecureXUser(UrlPrefix_XUserREST + "/secure/users/", UserList2.get(i),vxuserKeyAdmin.getName(),vxuserKeyAdmin.getPassword(),keyadminRole.get(0),existingrole.toString(),rolekey);
							keadminflag=false;
							break;
						}
					}
					else if(rolekey.equalsIgnoreCase("ROLE_KEY_ADMIN_AUDITOR") && existingrole.contains("ROLE_USER") ){
								List<String> updateROLELsit = new ArrayList<String>();
								updateROLELsit.add(rolekey);
								vXUser.setUserRoleList(updateROLELsit);
								UserList2.get(i).setUserRoleList(updateROLELsit);
								 List<String> keyadminRole = (List<String>) vxuserKeyAdmin.getUserRoleList();
								
								obj.updateSecureXUser(UrlPrefix_XUserREST + "/secure/users/", UserList2.get(i),vxuserKeyAdmin.getName(),vxuserKeyAdmin.getPassword(),keyadminRole.get(0),existingrole.toString(),rolekey);
								
							}
			}
		}
		System.out.println("userLsit1="+UserList1.toString());
		System.out.println("userLsit2===="+UserList2.toString());
		
			VXUser vXUsertest = new VXUser();
			vXUsertest.setIsVisible(1);
			
			vXUsertest.setPassword("user1234");
			List<String> userRoleList = new ArrayList<String>();
			userRoleList.add("ROLE_SYS_ADMIN");
			vXUsertest.setUserRoleList(userRoleList);
			vXUsertest.setName("testUser");
			vXUsertest.setFirstName("f" + vXUsertest.getName());
			vXUsertest.setLastName("l" + vXUsertest.getName());
			obj.secureCreateXUser(UrlPrefix_XUserREST + "/secure/users", vXUsertest, vxuserAdmin.getName(),vxuserAdmin.getPassword(),"ROLE_SYS_ADMIN",userRoleList.get(0),userRoleList.get(0));
			
		
		int i=0;
		List<String> roleupdate = new ArrayList<String>();
		roleupdate.add("ROLE_SYS_ADMIN");
		roleupdate.add("ROLE_USER");
		roleupdate.add("ROLE_ADMIN_AUDITOR");
		roleupdate.add("ROLE_KEY_ADMIN");
		roleupdate.add("ROLE_KEY_ADMIN_AUDITOR");
		for (VXUser userForCurlCred : UserList2) {
			int k=0;
			
			System.out.println("=====userForCurlCred====="+userForCurlCred.getName());
			List<String> existingCred = (List<String>)userForCurlCred.getUserRoleList();
			for(String initRole: roleupdate){
				List<String> initUserRoleList = new ArrayList<String>();
				initUserRoleList.add(initRole);int j=0;
				for(String userRole:roleupdate){
					k++;
					j++;
					
					List<String> userRoleUpdateList = new ArrayList<String>(); 
					vXUsertest.getUserRoleList();
					userRoleUpdateList.add(userRole);
					vXUsertest.setUserRoleList(userRoleUpdateList);
					VXUser olUserProfile= obj.getGetUserId(vXUsertest);
					List<String> current_role = (List<String>)olUserProfile.getUserRoleList();
					vXUsertest.setId(olUserProfile.getId());
					obj.updateSecureXUser(UrlPrefix_XUserREST + "/secure/users/", vXUsertest,userForCurlCred.getName(),userForCurlCred.getPassword(),existingCred.get(0).toString(),current_role.get(0),userRole);
					i++;
					vXUsertest.setUserRoleList(initUserRoleList);
					i++;
					VXUser olUserProfile2= obj.getGetUserId(vXUsertest);
					List<String> current_role2 = (List<String>)olUserProfile2.getUserRoleList();
					obj.updateSecureXUser(UrlPrefix_XUserREST + "/secure/users/",vXUsertest ,userForCurlCred.getName(),userForCurlCred.getPassword(),existingCred.get(0).toString(),current_role2.get(0),initRole);
					System.out.println("role===roleUpdate======"+i+"=>"+userRole+" "+j+" "+k);
				}
			}
		}
		
		for (VXUser userForCurlCred : UserList2) {
			List<String> existingCred = (List<String>)userForCurlCred.getUserRoleList();
			for(String initRole: roleupdate){
				List<String> initUserRoleList = new ArrayList<String>();
				initUserRoleList.add(initRole);
				for(String userRole:roleupdate){
					System.out.println("role===roleUpdate======>"+userRole);
					List<String> userRoleUpdateList = new ArrayList<String>();
					userRoleUpdateList.add(userRole);
					vXUsertest.setUserRoleList(userRoleUpdateList);
					VXUser olUserProfile= obj.getGetUserId(vXUsertest);
					List<String> current_role = (List<String>)olUserProfile.getUserRoleList();
					vXUsertest.setId(olUserProfile.getId());
					obj.updateXUser(UrlPrefix_XUserREST + "/users/", vXUsertest,userForCurlCred.getName(),userForCurlCred.getPassword(),existingCred.get(0),current_role.get(0),userRole);
					vXUsertest.setUserRoleList(initUserRoleList);
					VXUser olUserProfile2= obj.getGetUserId(vXUsertest);
					List<String> current_role2 = (List<String>)olUserProfile2.getUserRoleList();
					obj.updateXUser(UrlPrefix_XUserREST + "/users/", vXUsertest,userForCurlCred.getName(),userForCurlCred.getPassword(),existingCred.get(0),current_role2.get(0),initRole);
				}
			}
		}
		// for update users //put
		/*obj.updateXUser(UrlPrefix_XUserREST + "/users", logDetail);

		// for read users
		obj.getXUserByUserName(UrlPrefix_XUserREST + "/users/userName/${userName}", logDetail);
		//obj.checkUserRead(logDetail);

		// for read users 2 get
		obj.searchXUsers(UrlPrefix_XUserREST + "/users", logDetail);

		// to update user roles
		obj.setUserRolesByName(UrlPrefix_XUserREST + "/secure/users/roles/userName/${userName}", logDetail,"ROLE_SYS_ADMIN");

		// to get users
		obj.getUserRolesByName(UrlPrefix_XUserREST + "/secure/users/roles/userName/${userName}", logDetail); //issue logs not going

		// for delete user
		obj.deleteXUserByUserName(UrlPrefix_XUserREST + "/users/userName/${userName}?forceDelete=true", logDetail); //issue in / & \

		// for post user 2 through map -groups are linked to users
		obj.createXUserGroupFromMap(UrlPrefix_XUserREST + "/users/userinfo", logDetail); //issue -this adds users only in x_user not in x_portal_user hence ranger dont show any users from x_user only x_portal_user

		// for get userGroup
		obj.searchXGroupUsers(UrlPrefix_XUserREST + "/groupusers", logDetail); //this will bring only groups linked with users
		
		// for get groups
		obj.searchXGroups(UrlPrefix_XUserREST + "/groups", logDetail);

		// for delete group user link -groups link to users are removed
		obj.deleteXGroupAndXUser(UrlPrefix_XUserREST + "/group/${groupName}/user/${userName}", logDetail); ////issue in deleting groups "/" & "\"

		// for delete group -extra since we already have groups need to delete
		// existing to check next post
		// to delete groups
		obj.deleteXGroupByGroupName(UrlPrefix_XUserREST + "/groups/groupName/${groupName}", logDetail); //issue in deleting groups "/" & "\"

		// for post groups
		obj.createXGroup(UrlPrefix_XUserREST + "/groups", logDetail);

		 //this will delete user one by one -provided user is present in both x_user & x_portal_user
		// for creating default user
		obj.createDefaultAccountUser(UrlPrefix_UserREST + "/default", logDetail); //creates users only in x_portal_user

		// for delete user -extra -for running following
		// createDefaultAccountUser we need to run delete
		obj.deleteXUserByUserName(UrlPrefix_XUserREST + "/users/userName/${userName}?forceDelete=true", false);

		// to get groups
		obj.getXGroupByGroupName(UrlPrefix_XUserREST + "/groups/groupName/${groupName}", logDetail); //issue in getting group named "/" & "\"
*/	}

	/*private void preRequisites() {
		//loadCharList(); // load all special charecters in a map
		//boolean logDetail = false;
		//String apiUrl = UrlPrefix_XUserREST + "/users/userName/${userName}?forceDelete=true";
		//deleteXUserByUserName(apiUrl, false); // prerequisite to delete already existing data and not insert repeated data
		//deleteXGroupByGroupName(UrlPrefix_XUserREST + "/groups/groupName/${groupName}", logDetail);
		setUserRolesByName(UrlPrefix_XUserREST + "/secure/users/roles/userName/${userName}", logDetail, "ROLE_USER"); // to make all users role as users
	}*/
public VXUser getGetUserId(VXUser vXUsertest){
	Client c = getClient("admin","admin");

	VXUser VxEntity = new VXUser();
	String getPath="/service/xusers/users/userName/${userName}";
	if(vXUsertest.getName()!=null) {
		VxEntity = getUserObjForIdByName(vXUsertest.getName(), c,getPath);
	}
	
	return VxEntity;
}

	// GET @PATH("/secure/users/roles/userName/{userName}")
	private void getUserRolesByName(String path, boolean logDetail) {
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		String methodName = "getXGroupByGroupName";
		ClientResponse clientResp = null;
		String response = null;
		Set<Integer> charSet = specialCharMap.keySet();
		System.out.println("uri: [" + path + "]");
		String userName = null;
		String pathTmp = null;
		WebResource r = null;
		VXUser vXUser = new VXUser();
		//VXStringList vXStringList = null;
		for (Integer asciicode : charSet) {
			try {
				userName = specialCharMap.get(asciicode);
				pathTmp = path.replaceAll(Pattern.quote("${userName}"), CharEncode.encodeURIParam(userName,false));
				r = c.resource(getURL(path));
				clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
				clientResp.bufferEntity();
				response = clientResp.getEntity(String.class);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (logDetail == true && response != null) {
					try {
						insertLog(userName, vXUser, methodName, clientResp, r, pathTmp,"admin","admin123","ROLE_SYS_ADMIN","-","-");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

/*	// @PUT @PATH("/secure/users/roles/userName/{userName}") //this will set all
	// users role as admin
	private void setUserRolesByName(String path, boolean logDetail, String role) {
		
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		
		Gson gson = new GsonBuilder().create();
		String methodName = "setUserRolesByName";
		ClientResponse clientResp = null;
		String response = null;
		String jsonString = null;
		String userName = null;
		String pathTmp = null;
		WebResource r = null;
		VXUser vXUser = new VXUser();
		VXStringList vXStringList = new VXStringList();
		VXString vString = new VXString();
		List<VXString> vXStringL = new ArrayList<VXString>();
		vString.setValue(role);
		vXStringL.add(vString);
		vXStringList.setVXStrings(vXStringL);
		try {
			System.out.println("in try");
			userName = "fatima";
			pathTmp = path.replaceAll(Pattern.quote("${userName}"), CharEncode.encodeURIParam(userName,false));
			r = c.resource(getURL(pathTmp));
			jsonString = gson.toJson(vXStringList);
			clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
					.put(ClientResponse.class, jsonString);
			clientResp.bufferEntity();
			response = clientResp.getEntity(String.class);
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			System.out.println("logDetail-----"+logDetail);
			if (logDetail == true && response != null) {
				try {
					System.out.println("in finally");
					insertLog(userName, vXUser, methodName, clientResp, r, pathTmp,"admin","admin123","ROLE_SYS_ADMIN");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		
	}*/

	// @DELETE @PATH("/groups/groupName/${groupName}") deletes all special char
/*	// groups one by one
	private void deleteXGroupByGroupName(String path, boolean logDetail) {
		System.out.println("private void deleteXGroupByGroupName(String path, boolean logDetail) {");
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		String methodName = "deleteXGroupByGroupName";
		ClientResponse clientResp = null;
		Set<Integer> charSet = specialCharMap.keySet();
		System.out.println("uri: [" + path + "]");
		String groupName = null;
		String pathTmp = null;
		WebResource r = null;
		VXUser vXUser = new VXUser();
		for (Integer asciicode : charSet) {
			try {

				groupName = specialCharMap.get(asciicode);
				// vXUser.setDescription("user_description = "+userName);
				pathTmp = path.replaceAll(Pattern.quote("${groupName}"), CharEncode.encodeURIParam(groupName,false));
				r = c.resource(getURL(pathTmp));
				clientResp = r.delete(ClientResponse.class);
				// vXUser = gson.fromJson(response, VXUser.class);
			} catch (Exception ex) {
				ex.printStackTrace();
				// System.out.println(ex);
			} finally {
				if (logDetail == true && clientResp != null) {
					try {
						insertLog("groupName=" + groupName, vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {

						e.printStackTrace();
					}
				}
			}
		}
	}
*/
	// @GET @PATH("/groups/groupName/{groupName}")
	/*private void getXGroupByGroupName(String path, boolean logDetail) {
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		String methodName = "getXGroupByGroupName";
		ClientResponse clientResp = null;
		String response = null;
		Set<Integer> charSet = specialCharMap.keySet();
		System.out.println("uri: [" + path + "]");
		String groupName = null;
		String pathTmp = null;
		WebResource r = null;
		VXUser vXUser = new VXUser();
		for (Integer asciicode : charSet) {
			try {
				groupName = specialCharMap.get(asciicode);
				pathTmp = path.replaceAll(Pattern.quote("${groupName}"), CharEncode.encodeURIParam(groupName,false));
				r = c.resource(getURL(pathTmp));
				clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
				clientResp.bufferEntity();
				response = clientResp.getEntity(String.class);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (logDetail == true && response != null) {
					try {
						insertLog("groupName=" + groupName, vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {

						e.printStackTrace();
					}
				}
			}
		}
	}*/

	// @POST @PATH("/default") create user in x_portal_user
	/*private void createDefaultAccountUser(String path, boolean logDetail) {
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		Gson gson = new GsonBuilder().create();
		String methodName = "createDefaultAccountUser";
		ClientResponse clientResp = null;
		String response = null;
		String userName = null;
		Set<Integer> charSet = specialCharMap.keySet();
		System.out.println("uri: [" + path + "]");
		String jsonString = null;
		WebResource r = c.resource(getURL(path));
		VXPortalUser vxp = new VXPortalUser();
		for (Integer asciicode : charSet) {
			try {

				vXUser = new VXUser();
				userName = specialCharMap.get(asciicode);
				vxp.setFirstName("f" + userName);
				vxp.setLastName("l" + userName);
				vxp.setLoginId(userName);
				vxp.setPassword("user1234");
				jsonString = gson.toJson(vxp);
				clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
						.post(ClientResponse.class, jsonString);
				clientResp.bufferEntity();
				response = clientResp.getEntity(String.class);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (logDetail == true && response != null) {
					try {
						insertLog(vxp.getLoginId(), vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}*/

	// @DELETE @Path("/group/{groupName}/user/{userName}") //to remove user from group note :this will not delete neither group nor user
/*	private void deleteXGroupAndXUser(String path, boolean logDetail) {
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		//Gson gson = new GsonBuilder().create();
		String methodName = "deleteXGroupAndXUser";
		ClientResponse clientResp = null;
		String userName = null;
		Set<Integer> charSet = specialCharMap.keySet();
		System.out.println("uri: [" + path + "]");
		//String jsonString = null;
		String pathTmp = null;
		//VXUserGroupInfo vXUserGroupInfo = null;
		VXGroup vXGroup1 = null;
		//List<VXGroup> vXGroupList = null;
		String groupName = null;
		WebResource r = null;
		for (Integer asciicode : charSet) {
			try {
				//vXUserGroupInfo = new VXUserGroupInfo();
				vXGroup1 = new VXGroup();
				//vXGroupList = new ArrayList<VXGroup>();
				userName = specialCharMap.get(asciicode);
				groupName = userName;
				vXUser = getVXUserObj();
				vXUser.setName(userName);
				vXUser.setDescription("user_description = " + userName);
				vXUserGroupInfo.setXuserInfo(vXUser);
				vXGroup1.setName(userName);
				vXGroup1.setIsVisible(1);
				vXGroup1.setDescription("group_description = " + userName);
				pathTmp = path.replaceAll(Pattern.quote("${groupName}"), CharEncode.encodeURIParam(groupName,false))
						.replaceAll(Pattern.quote("${userName}"), CharEncode.encodeURIParam(userName,false));
				r = c.resource(getURL(pathTmp));
				//vXGroupList.add(vXGroup1);
				//vXUserGroupInfo.setXgroupInfo(vXGroupList);
				//jsonString = gson.toJson(vXUserGroupInfo);
				clientResp = r.delete(ClientResponse.class);
				clientResp.bufferEntity();
				//response = clientResp.getEntity(String.class);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (logDetail == true) {
					try {
						insertLog("username= " + vXUser.getName() + " GroupName= " + vXGroup1.getName(), vXUser,
								methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// @GET @path("/groupUsers") //100 records Brings users who are in some group
	private void searchXGroupUsers(String path, boolean logDetail) {
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		WebResource r = c.resource(getURL(path));
		Gson gson = new GsonBuilder().create();
		String methodName = "searchXGroupUsers";
		ClientResponse clientResp = null;
		String response = null;
		GetXUserGroupListResponse usergroupList = new GetXUserGroupListResponse();
		List<XUserGroupInfo> xusergroupList = new ArrayList<XUserGroupInfo>();
		try {
			r = c.resource(getURL(path)).queryParam("pageSize", String.valueOf(100)).queryParam("startIndex",
					String.valueOf(0));
			clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
			clientResp.bufferEntity();
			response = clientResp.getEntity(String.class);
			usergroupList = gson.fromJson(response, GetXUserGroupListResponse.class);

		} finally {
			if (logDetail == true && response != null) {
				try {
					if (usergroupList.getXusergroupInfoList() != null) {
						xusergroupList.addAll(usergroupList.getXusergroupInfoList());

						for (XUserGroupInfo ug : usergroupList.getXusergroupInfoList()) {
							insertLog("userId=" + ug.getUserId() + " GroupName=" + ug.getGroupName(), vXUser,
									methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// @POST @Path("/groups") to create groups as same name as users
	private void createXGroup(String path, boolean logDetail) {
		String userName = null;
		Set<Integer> charSet = specialCharMap.keySet();
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		WebResource r = c.resource(getURL(path));
		Gson gson = new GsonBuilder().create();
		String methodName = "createXGroup";
		String jsonString = null;
		ClientResponse clientResp = null;
		String response = null;
		VXGroup vXGroup1 = null;
		for (Integer asciicode : charSet) {
			try {
				vXUser = new VXUser();
				vXGroup1 = new VXGroup();
				userName = specialCharMap.get(asciicode);
				vXGroup1.setName(userName);
				vXGroup1.setIsVisible(1);
				vXGroup1.setDescription("group_description = " + userName);
				jsonString = gson.toJson(vXGroup1);
				clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
						.post(ClientResponse.class, jsonString);
				clientResp.bufferEntity();
				response = clientResp.getEntity(String.class);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (logDetail == true && response != null) {
					try {
						insertLog("GroupName= " + userName, vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// @GET @Path("/groups") this will bring list of groups based on pagesize
	// and parse it one by one in loop pagesize =100 also brings groups other than spcl chars eg.public
	private void searchXGroups(String path, boolean logDetail) {
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		WebResource r = null;
		Gson gson = new GsonBuilder().create();
		String methodName = "searchXGroups";
		ClientResponse clientResp = null;
		String response = null;
		List<XGroupInfo> xgroupList = new ArrayList<XGroupInfo>();
		GetXGroupListResponse groupList = new GetXGroupListResponse();
		try {
			// here we are taking only 100 results
			r = c.resource(getURL(path)).queryParam("pageSize", String.valueOf(100)).queryParam("startIndex",
					String.valueOf(0));
			clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
			clientResp.bufferEntity();
			response = clientResp.getEntity(String.class);
			groupList = gson.fromJson(response, GetXGroupListResponse.class);

		} finally {
			if (logDetail == true && response != null) {
				try {
					if (groupList.getXgroupInfoList() != null) {
						xgroupList.addAll(groupList.getXgroupInfoList());

						for (XGroupInfo g : groupList.getXgroupInfoList()) {
							System.out.println(g.getName());
							insertLog("GroupName= " + g.getName(), vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

		}

	}

	// @POST @Path("/users/userinfo") creates user and group and assigns them to
	// each other
	private void createXUserGroupFromMap(String path, boolean logDetail) {
		String userName = null;
		VXUser vXUser = null;
		Set<Integer> charSet = specialCharMap.keySet();
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		Gson gson = new GsonBuilder().create();
		String methodName = "createXUserGroupFromMap";
		ClientResponse response = null;
		String jsonString = null;
		VXUserGroupInfo vXUserGroupInfo = null;
		VXGroup vXGroup1 = null;
		List<VXGroup> vXGroupList = null;
		WebResource r = c.resource(getURL(path));
		for (Integer asciicode : charSet) {
			try {
				vXUserGroupInfo = new VXUserGroupInfo();
				vXGroup1 = new VXGroup();
				vXGroupList = new ArrayList<VXGroup>();
				userName = specialCharMap.get(asciicode);
				vXUser = getVXUserObj();
				vXUser.setName(userName);
				vXUser.setDescription("user_description = " + userName);
				vXUserGroupInfo.setXuserInfo(vXUser);
				vXGroup1.setName(userName);
				vXGroup1.setIsVisible(1);
				vXGroup1.setDescription("group_description = " + userName);
				vXGroupList.add(vXGroup1);
				vXUserGroupInfo.setXgroupInfo(vXGroupList);
				jsonString = gson.toJson(vXUserGroupInfo);
				response = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
						.post(ClientResponse.class, jsonString);
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (logDetail == true && response != null) {
					try {
						insertLog("username= " + vXUser.getName() + " GroupName= " + vXGroup1.getName(), vXUser,
								methodName, response, r, path,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	// @GET @Path("/users") this will bring list of users based on pagesize and parse it one by one in loop Note:this will bring other than special char users also
	private void searchXUsers(String path, boolean logDetail) {
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		WebResource r = null;
		Gson gson = new GsonBuilder().create();
		String methodName = "searchXUsers";
		ClientResponse clientResp = null;
		String response = null;
		List<XUserInfo> xuserList = new ArrayList<XUserInfo>();
		GetXUserListResponse userList = null;
		try {
			r = c.resource(getURL(path)).queryParam("pageSize", String.valueOf(100)).queryParam("startIndex",
					String.valueOf(0));
			clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
			clientResp.bufferEntity();
			response = clientResp.getEntity(String.class);
			userList = gson.fromJson(response, GetXUserListResponse.class);

		} finally {
			if (logDetail == true && response != null) {
				try {
					if (userList.getXuserInfoList() != null) {
						xuserList.addAll(userList.getXuserInfoList());

						for (XUserInfo u : userList.getXuserInfoList()) {
							insertLog(u.getName(), vXUser, methodName, clientResp, r, path,"admin","admin123","ROLE_SYS_ADMIN");
						}
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}

		}

	}

	// @GET @Path("/users/userName/{userName}") this will read users one by one
	// using username in URL
	private void getXUserByUserName(String path, boolean logDetail) {
		// here we are getting list of users , need to put entry in table
		String userName = null;
		VXUser vXUser = null;
		Set<Integer> charSet = specialCharMap.keySet();
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		WebResource r = null;
		Gson gson = new GsonBuilder().create();
		String methodName = "getXUserByUserName";
		ClientResponse clientResp = null;
		String response = null;
		String pathTmp = null;
		for (Integer asciicode : charSet) {
			try {
				userName = specialCharMap.get(asciicode);
				pathTmp = path.replaceAll(Pattern.quote("${userName}"), CharEncode.encodeURIParam(userName,false));
				r = c.resource(getURL(pathTmp));
				clientResp = r.accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
				clientResp.bufferEntity();
				response = clientResp.getEntity(String.class);
				vXUser = gson.fromJson(response, VXUser.class);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (logDetail == true) {
					try {
						insertLog(userName, vXUser, methodName, clientResp, r, pathTmp,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}*/

	// @PUT @Path("secure/users") //this will update first name of users and set it as
	// char twice ideal response:200
	private void updateSecureXUser(String path,VXUser vXUser,String OWNERName,String OWNERPassword,String OWNERRole,String user_current_role,String user_target_role ) {
		//String userName = null;
		Client c = getClient(OWNERPassword,OWNERPassword);
		
		
		String jsonString = null;
		ClientResponse response = null;
		String getPath="/service/xusers/users/userName/${userName}";
		try {
			System.out.println("USERROLE--------"+vXUser.getUserRoleList().toString());
			
			if (vXUser.getId() != null) {
				System.out.println("in -f---------updateSecureXUser--------");
				path =path+vXUser.getId();
				System.out.println("===========updateSecureXUser==================uri: [" + path + "]");
				
			}
			else{
				VXUser VxEntity = getUserObjForIdByName(vXUser.getName(), c,getPath);
				path =path+vXUser.getId();
				vXUser.setUserSource(VxEntity.getUserSource());
				vXUser.setFirstName(VxEntity.getFirstName());
				vXUser.setLastName(VxEntity.getLastName());
				vXUser.setStatus(VxEntity.getStatus());
				vXUser.setUserSource(VxEntity.getUserSource());
				vXUser.setEmailAddress(VxEntity.getEmailAddress());
				vXUser.setName(vXUser.getName());
				vXUser.setDescription(VxEntity.getDescription());
				vXUser.setId(VxEntity.getId());
			
			}
			
			WebResource r = c.resource(getURL(path));
			Gson gson = new GsonBuilder().create();
			String methodName = "updateXUser";
			vXUser.setUserRoleList(vXUser.getUserRoleList());
			
			gson = new GsonBuilder().create();
			jsonString = gson.toJson(vXUser);
			
			response = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
					.put(ClientResponse.class, jsonString);
			insertLog(vXUser.getName(), vXUser, methodName, response, r, path,OWNERName,OWNERPassword,OWNERRole,user_current_role,user_target_role);
			} catch (Exception ex) {
			} 
		

	}


	// @PUT @Path("/users") //this will update first name of users and set it as
	// char twice ideal response:200
	private void updateXUser(String path,VXUser vXUser,String OWNERName,String OWNERPassword,String OWNERRole,String user_current_role,String user_target_role ) {
		//String userName = null;
		Client c = getClient(OWNERPassword,OWNERPassword);
		
		
		String jsonString = null;
		ClientResponse response = null;
		String getPath="/service/xusers/users/userName/${userName}";
		try {
			
			
			if (vXUser.getId() == null) {
				VXUser VxEntity = getUserObjForIdByName(vXUser.getName(), c,getPath);
				System.out.println("in -f-----------updateXUser------");
				System.out.println("===============updateXUser==============uri: [" + path + "]");
				vXUser.setId(VxEntity.getId());
			
				vXUser.setUserSource(VxEntity.getUserSource());
				vXUser.setFirstName(VxEntity.getFirstName());
				vXUser.setLastName(VxEntity.getLastName());
				vXUser.setStatus(VxEntity.getStatus());
				vXUser.setUserSource(VxEntity.getUserSource());
				vXUser.setEmailAddress(VxEntity.getEmailAddress());
				vXUser.setName(VxEntity.getName());
				vXUser.setDescription(VxEntity.getDescription());
			}
			WebResource r = c.resource(getURL(path));
			Gson gson = new GsonBuilder().create();
			String methodName = "updateXUser";
			vXUser.setUserRoleList(vXUser.getUserRoleList());
			
			gson = new GsonBuilder().create();
			jsonString = gson.toJson(vXUser);
			System.out.println("jsonString========updateXUser==========> "+jsonString);
			response = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
					.put(ClientResponse.class, jsonString);
			insertLog(vXUser.getName(), vXUser, methodName, response, r, path,OWNERName,OWNERPassword,OWNERRole,user_current_role,user_target_role);
			} catch (Exception ex) {
			} 
		

	}

	/*// @DELETE @Path("/users/userName/{userName}") //this will delete user one by one -provided user is present in both x_user & x_portal_user
	// by one using query param
	private void deleteXUserByUserName(String path, boolean logDetail) {
		System.out.println("private void deleteXUserByUserName(String path, boolean logDetail) {");
		String userName = null;
		// VXUser vx=null;
		Set<Integer> charSet = specialCharMap.keySet();
		VXUser vXUser = null;
		Client c = getClient("admin","admin123");
		System.out.println("uri: [" + path + "]");
		String methodName = "deleteXUserByUserName";// print REST method
		ClientResponse response = null;
		WebResource r = null;
		String pathTmp = null;
		try {
				userName = "fatima";
				pathTmp = path.replaceAll(Pattern.quote("${userName}"), CharEncode.encodeURIParam(userName,false));
				r = c.resource(getURL(pathTmp));
				response = r.delete(ClientResponse.class);
				System.out.println("end of try");
			} catch (Exception e) {

			} finally {
				if (logDetail == true && response != null) {
					try {
						vXUser.setFirstName("Fatima");
						vXUser.setLastName("khan");
						vXUser.setOwner("admin");
						insertLog(userName, vXUser, methodName, response, r, pathTmp,"admin","admin123","ROLE_SYS_ADMIN");
					} catch (UnsupportedEncodingException e) {

						e.printStackTrace();
					}
				}
			}

		}
*/
	

	// @POST @PATH("/secure/users") //
	// as users ideal response:200
	private void secureCreateXUser(String path, VXUser vXUser,String OWNERName,String OWNERPassword,String OWNERRole,String user_current_role,String user_target_role) {
		System.out.println("private void secureCreateXUser(String path, boolean logDetail) {");
		//String userName = null;
		
		
		Client c = getClient(OWNERName,OWNERPassword);
		System.out.println("uri: [" + path + "]");
		WebResource r = c.resource(getURL(path));
		Gson gson = new GsonBuilder().create();
		String methodName = "secureCreateXUser";
		String jsonString = null;
		ClientResponse response = null;
		try {
			
			jsonString = gson.toJson(vXUser);
				response = r.accept(MediaType.APPLICATION_JSON_TYPE).type(MediaType.APPLICATION_JSON_TYPE)
						.post(ClientResponse.class, jsonString);
				insertLog(vXUser.getName(), vXUser, methodName, response, r, path,OWNERName,OWNERPassword,OWNERRole,user_current_role,user_target_role);
				//return response.getStatus();
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		//return response.get`();
	}

	/*public void loadCharList() {
		for (int i = 1500; i < 1600; i++) {
			if ( i <= 999){
			if (i >= 778 ) {
				continue;
			}
			}
				specialCharMap.put(i, "user" + (char) (i)+i);
		}
	}*/
	private VXUser getUserObjForIdByName(String userName, Client c,String getPath) {
		VXUser vxusr = new VXUser();
		try {
			String uri = getPath.replaceAll(Pattern.quote("${userName}"),
					CharEncode.encodeURIParam(userName,true));
			WebResource r = c.resource(getURL(uri));
			Gson gson = new GsonBuilder().create();
			String response = r.accept(MediaType.APPLICATION_JSON_TYPE).get(String.class);
			vxusr = gson.fromJson(response, VXUser.class);
			System.out.println(response);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return vxusr;
	}
	
	
	
	
	public Client getClient(String OWNERName, String OWNERPassword) {
		Client ret = null;
		ClientConfig cc = new DefaultClientConfig();
		cc.getProperties().put(ClientConfig.PROPERTY_FOLLOW_REDIRECTS, true);
		ret = Client.create(cc);
		ret.addFilter(new HTTPBasicAuthFilter(OWNERName,OWNERPassword));

		return ret;
	}

	public String getURL(String uri) {
		String ret = null;
		ret = policyMgrBaseUrl + (uri.startsWith("/") ? uri : ("/" + uri));
		return ret;
	}

	private void insertLog(String userName, VXUser vx, String methodName, ClientResponse response, WebResource r,
			String APIName,String OWNERName,String OWNERPassword,String OWNERRole,String user_current_role,String user_target_role) throws UnsupportedEncodingException {
		System.out.println("private void insertLog(String userName, VXUser vx, String methodName, ClientResponse response, WebResource r,");
		int statusCode=-1;
		StatusType statusMsg=null;
		String methodType="";
		try {
			System.out.println("userNAME: " + userName);
			System.out.println("vx: "+vx);
			System.out.println("methodName: "+methodName);
			System.out.println("response: "+response);
			System.out.println("webresouce: "+r.toString());
			System.out.println("ApiName: "+APIName);
			//Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OWNERName"+OWNERName);
			System.out.println("OWNERPassword"+OWNERPassword);
			
			if (response!=null){
			statusCode = response.getStatus();
			System.out.println("statusCode: "+statusCode);
			statusMsg = response.getStatusInfo();
			System.out.println("statusMsg: "+statusMsg);
			
			String methodTypeResp = response.toString();
			System.out.println("methodTypeResp: "+methodTypeResp);
			methodType = methodTypeResp.substring(0, methodTypeResp.indexOf(" "));
			System.out.println("methodType: "+methodType);
			}
			stmt = conn.prepareStatement(
					"insert into username_details(user_name,user_password,url_encoded_char,API_name,request_json,method_name,method_type, status_code, status_msg, url,Owner,OwnerPassword,ownerRole,user_current_role,user_target_role) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, userName);
			stmt.setString(2, vx.getPassword());
			stmt.setString(3, URLEncoder.encode(vx.getName(), StandardCharsets.UTF_8.toString()));
			stmt.setString(4, APIName);
			stmt.setString(6, methodName);
			stmt.setString(7, methodType);
			stmt.setString(11,OWNERName);
			stmt.setString(12, OWNERPassword);
			stmt.setString(13, OWNERRole);
			stmt.setString(14, user_current_role);
			stmt.setString(15, user_target_role);
			stmt.setInt(8, statusCode);
			if(statusMsg!=null){
				stmt.setString(9, statusMsg.getReasonPhrase());
			}else{
				stmt.setString(9, "null");
			}
			if(r!=null){
			stmt.setString(10, r.toString());
			
			}
			else{
				stmt.setString(10, "null");
			}
			
			
			if (methodType.trim().equalsIgnoreCase("DELETE")) {
				stmt.setString(5, "");
				stmt.execute();
			} else if (methodType.trim().equalsIgnoreCase("POST")) {
				stmt.setString(5, vx.toString());
				stmt.executeUpdate();
			}

			else if (methodType.trim().equalsIgnoreCase("UPDATE")) {
				stmt.setString(5, vx.toString());
				stmt.executeUpdate();
			}

			else if (methodType.trim().equalsIgnoreCase("GET")) {
				stmt.setString(5, "");
				stmt.executeUpdate();
			}

			else {
				if(vx!=null)
				stmt.setString(5, vx.toString());
				stmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private VXUser getVXUserObj() {
		VXUser vXUser = new VXUser();
		vXUser.setIsVisible(1);
		vXUser.setName("fatima");
		vXUser.setPassword("user1234");
		List<String> userRoleList = new ArrayList<String>();
		//userRoleList.add(USERROLE);
		vXUser.setUserRoleList(userRoleList);
		vXUser.setFirstName("f" + vXUser.getName());
		vXUser.setLastName("l" + vXUser.getName());

		return vXUser;
	}
}
