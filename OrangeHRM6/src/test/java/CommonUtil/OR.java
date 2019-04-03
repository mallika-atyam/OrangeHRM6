package CommonUtil;


import org.openqa.selenium.WebDriver;

public class OR {
	
public static String sTargetTestCaseExcelPath="";	
public static String sTargetFolderPath="";	
public static String sTestCaseName="";	

//public static WebDriver driver ; 

//Pages
//1.MercuryFlightFinderPage  = MFFPage
//2.MercuryLoginPage  = MLPage
//3.SelectFlightPage = SFPage




//LeaveList Export
public static String Leave_focus="//*[@id='menu_leave_viewLeaveModule']";
public static String Leavelist_click="//a[@id='menu_leave_viewLeaveList']";
public static String Leave_all_checkbox="//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";
public static String Leave_search_click="//*[@id='btnSearch']";
public static String Leave_Num_columns="//*[@id='resultTable']/thead/tr/th";
public static String Leave_Num_rows="//*[@id='resultTable']/tbody/tr/td[2]";

public static String LE_Leave_focus="//*[@id='menu_leave_viewLeaveModule']";
public static String LE_Assignleave_focus=" //*[@id='menu_leave_assignLeave']";
public static String LE_Empnaqme_sendkey="//*[@id='assignleave_txtEmployee_empName']";
public static String LE_Leavetype_listbox="//*[@id='assignleave_txtLeaveType']";
public static String LE_Fromdate_sendkey="//*[@id='assignleave_txtFromDate']";
public static String LE_Todate_sendkey="/*[@id='assignleave_txtToDate']";
public static String LE_Comment_sendkey="//*[@id='assignleave_txtComment']";
public static String LE_Assign_click="//*[@id='assignBtn']";
public static String LE_Confirm_click="//*[@id='confirmOkButton']";
public static String LE_Leavelist_focus="//*[@id='menu_leave_viewLeaveList']";
public static String LE_All_checkbox="//*[@id='leaveList_chkSearchFilter_checkboxgroup_allcheck']";
public static String LE_search_click="//*[@id='btnSearch']";
public static String LE_No_coloumns="//*[@id='resultTable']/thead/tr/th";
public static String LE_No_Rows="//*[@id='resultTable']/tbody/tr/td[1]";



public static String LAfrdtpicker="//*[@id='frmLeaveApply']/fieldset/ol/li[4]/img";
public static String LAtodtpicker="//*[@id='frmLeaveApply']/fieldset/ol/li[5]/img";
public static String LAfrmon="//*[@id='ui-datepicker-div']/div/div/select[1]";
public static String LAfrday="//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[4]/a";
public static String LAfryear="//*[@id='ui-datepicker-div']/div/div/select[2]";
public static String LAtomon="//*[@id='ui-datepicker-div']/div/div/select[1]";
public static String LAtoday="//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a";
public static String LAtoyear="//*[@id='ui-datepicker-div\']/div/div/select[2]";




//JobTitle 

public static String Job_focus="//a[@id='menu_admin_Job']";
public static String Jobtitle_click="//a[@id='menu_admin_viewJobTitleList']";
public static String Jobtitle_add="//*[@id='btnAdd']";
public static String Jobtitle_delete="//*[@id='btnDelete']";
public static String Jobtitle_columns="//*[@id='resultTable']/thead/tr/th";
public static String Jobtitle_rows="//*[@id='resultTable']/tbody/tr/td[2]";
public static String Jobtitle_new="//*[@id='jobTitle_jobTitle']";
public static String Job_description="//*[@id='jobTitle_jobDescription']";
public static String Job_note="//*[@id='jobTitle_note']";
public static String Job_savebtn="//*[@id='btnSave']";
public static String Jobtitle_delConfirmBtn="//*[@id='dialogDeleteBtn']";

public static String username_sendkey="//input[@id='txtUsername']";
public static String password_sendkey="//input[@id='txtPassword']";
public static String login_click="//input[@id='btnLogin']";

//EMP EXPORT


public static String pim_focus="//a[@id='menu_pim_viewPimModule']";
public static String EMPlist_click="//a[@id='menu_pim_viewEmployeeList']";
public static String EMPcolumn="//*[@id='resultTable']/thead/tr/th";
public static String EMProws="//*[@id='resultTable']/tbody/tr/td[2]";

//add emp with photo
public static String photopicker="//*[@id='photofile']";


//ADMIN EXPORT

public static String ADMIN_focus="//a[@id='menu_admin_viewAdminModule']";
public static String ADMIN_USERMANAGEMENT_focus="//a[@id='menu_admin_UserManagement']";
public static String ADMIN_USERS_click="//a[@id='menu_admin_viewSystemUsers']";
public static String ADMIN_COLUMNS_click="//*[@id='resultTable']/thead/tr/th";
public static String ADMIN_ROWS_click="//*[@id='resultTable']/tbody/tr/td[2]";

public static String ADMIN_username="//*[@id='searchSystemUser_userName']";
public static String ADMIN_userrole="//*[@id='searchSystemUser_userType']";
public static String ADMIN_empname="//*[@id='searchSystemUser_employeeName_empName']";
public static String ADMIN_status="//*[@id='searchSystemUser_status']";
public static String ADMIN_search_btn="//*[@id='searchBtn']";
public static String ADMIN_reset_btn="//*[@id='resetBtn']";
public static String ADMIN_user_add="//*[@id='btnAdd']";
public static String ADMIN_user_del="//*[@id='btnDelete']";
public static String ADMIN_adduser_userrole="//*[@id='systemUser_userType']";
public static String ADMIN_adduser_empname="//*[@id='systemUser_employeeName_empName']";
public static String ADMIN_adduser_username="//*[@id='systemUser_userName']";
public static String ADMIN_adduser_status="//*[@id='systemUser_status']";
public static String ADMIN_adduser_pass1="//*[@id='systemUser_password']";
public static String ADMIN_adduser_pass2="//*[@id='systemUser_confirmPassword']";
public static String ADMIN_adduser_save="//*[@id='btnSave']";


//admin qualifications export
public static String ADMIN_FOCUS="//a[@id='menu_admin_viewAdminModule']";
public static String ADMIN_QUALIFICATIONS_FOCUS="//a[@id='menu_admin_Qualifications']";
public static String ADMIN_SKILLS_CLICK="//a[@id='menu_admin_viewSkills']";
public static String ADMIN_NUMOFCOLUMNS="//*[@id='recordsListTable']/thead/tr/th";
public static String ADMIN_NUMOFROWS="//*[@id='recordsListTable']/tbody/tr/td[2]";

//admin membership

public static String ADMIN_MEMBERSHIP="//*[@id='menu_admin_membership']";
public static String ADMIN_MEM_ADD="//*[@id='btnAdd']";
public static String ADMIN_MEM_DEL="//*[@id='btnDelete']";
public static String ADMIN_MEM_COLS="//*[@id='resultTable']/tbody/tr[1]/td";
public static String ADMIN_MEM_ROWS="//*[@id='resultTable']/tbody/tr/td[2]";
public static String ADMIN_MEM_DEL_OK="//*[@id='dialogDeleteBtn']";

//BooLEAN USERROLE
public static String Admin_focus="//a[@ id='menu_admin_viewAdminModule' ]";

public static String UserManagement_focus="//a[@id='menu_admin_UserManagement']";
public static String UserRole_Listbox="//select[@id='searchSystemUser_userType']";
public static String NoColumns="//*[@id='resultTable']/thead/tr/th";
public static String NoRows="//*[@id='resultTable']/tbody/tr/td[2]/a";
public static String search_click="//input[@id='searchBtn']";
//Pim Jobtitle Search
public static String Employee_focus="//a[@id='menu_pim_viewEmployeeList']";
public static String Jobtitle_listbox="//select[@id='empsearch_job_title']";
public static String Jobtitle_search_click="//input[@id='searchBtn']";
public static String PimColumns="//*[@id='resultTable']/thead/tr/th";
public static String PimRows="//*[@id='resultTable']/tbody/tr/td[2]";

//pimempidsearch
public static String Pim_focus1="//*[@id='menu_pim_viewPimModule']";
public static String emp_listclick="//*[@id='menu_pim_viewEmployeeList']";
public static String empid_sendkey="//*[@id='empsearch_id']";

public static String emp_searchclick="//*[@id='searchBtn']";

public static String empcoloumns="//*[@id='resultTable']/thead/tr/th";
public static String emprows="//*[@id='resultTable']/tbody/tr/td[2]";
public static String emp_name="//*[@id='empsearch_employee_name_empName']";


//boolean various search
public static String BSpimfocus="//a[@id='menu_pim_viewPimModule']";

public static String BSEMPCLICK="//a[@id='menu_pim_viewEmployeeList']";

public static String BSEMPNAMESENDKEY="//input[@id='empsearch_employee_name_empName' ] ";

public static String BSIDSENDKEY="//input [@id='empsearch_id']";

public static String BSJOBTITLELISTBOX="//select[@id='empsearch_job_title' ]";

public static String BSSEARCHCLICK="//input[@id='searchBtn' ]";

public static String BSCOLOUMNS="//*[@id='resultTable']/thead/tr/th";

public static String BSROWS="//*[@id='resultTable']/tbody/tr/td[1]";

//addemp
public static String Emp_Pim_focus1="//*[@id='menu_pim_viewPimModule']";
public static String Emp_list_focus="//*[@id='menu_pim_viewEmployeeList']";

public static String Emp_firstname_sendkey="//*[@id='firstName']";

public static String Emp_middlename_sendkey="//*[@id='middleName']";

public static String Emp_lastname_sendkey="//*[@id='lastName']";

public static String Emp_id_sendkey="//*[@id='employeeId']";

public static String Emp_save_click="//*[@id='btnSave']";

public static String Emp_pimadd_click="//input[@id='btnAdd']";







////////////////////



public static String username="//input[@id='txtUsername']";
public static String password="//input[@id='txtPassword'] ";
public static String login="//input[@id='btnLogin']";
//public static String admin="//a[@id='menu_admin_viewAdminModule']";

//PIM starts
public static String Home_MainMenu_PIM_click="//a[@id='menu_pim_viewPimModule']";

public static String PIM_Addemployee_click="//a[@id='menu_pim_addEmployee']";
//PIM ends


//Add employee starts


public static String firstname_sendkeys="//input[@id='firstName']";

public static String middlename_sendkeys="//input[@id='middleName']";

public static String lastname_sendkeys="//input[@id='lastName']";

public static String EmployeeId_defaultno="//input[@id='employeeId']";


public static String CreateLoginDetails_checkbox="//input[@id='chkLogin']";

public static String UserName_sendkeys="//input[@id='user_name']";

public static String Password_sendkeys="//input[@id='user_password']";

public static String ConfirmPassword_sendkeys="//input[@id='re_password']";

public static String Status_listbox="//select[@id='status']";

public static String save="//input[@id='btnSave']";

public static String Vacancies_Add_Backbutton_click="//input[@id='btnBack']";

//Add employee 


public static String Pim_focus="//*[@id='menu_pim_viewPimModule']";

public static String Employee_click="//*[@id='menu_pim_viewEmployeeList']";
public static String Employeename_click="//*[@id='empsearch_employee_name_empName']";
public static String Empserch_click="//*[@id='searchBtn']";
public static String Empcoloums="//*[@id='resultTable']/thead/tr/th";
public static String EmpRows="//*[@id='resultTable']/tbody/tr/td[5]";



//Admin_Qualification Starts

public static String  Admin="//a[@id='menu_admin_viewAdminModule']";

public static String Qualification_Focus="//a[@id='menu_admin_Qualifications']";

public static String Qualification_skills_click="//a[@id='menu_admin_viewSkills']";

public static String Skills_Add="//input[@id='btnAdd']";

public static String AddSkill_Name="//input[@id='skill_name']";

public static String AddSkill_Description="//textarea[@id='skill_description']";

public static String AddSkill_Save="//input[@id='btnSave']";

public static String skillcoloumns="//*[@id='recordsListTable']/thead/tr/th";

public static String SkillRows="//*[@id='recordsListTable']/tbody/tr/td[2]";

}

























