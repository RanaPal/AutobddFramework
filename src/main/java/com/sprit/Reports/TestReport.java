package com.sprit.Reports;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

 
import org.openqa.selenium.By;

public class TestReport {
 
	static int Findex = 0;
	//	static  String FILENAME = "C:\\Automation\\CombineReport_";
	static  String RPT_DETAILFILE ="C:\\Automation\\CustomerPortalDetailReport_";
	static  String RPT_PASSFILE="C:\\Automation\\CustomerPortalPassReport_";
	static  String RPT_ERRORFILE="C:\\Automation\\CustomerPortalFailReport_";
	static  String RPT_SUMMARYFILE="C:\\Automation\\CustomerPortalSummeryReport_";
	static  BufferedWriter bw;
	static  String [] RWriteBuff ={"","","","",""};
	static  String HeadDetailReport,HeadSummeryReport,HeadPassReport,HeadFailReport=" ";
	static  String [] RptFile={"RPT_DETAILFILE","RPT_PASSFILE","RPT_ERRORFILE","RPT_SUMMARYFILE"};
//	static  String [] StrFl={"DetailFile","PassReportFile","ErrorReportFile","SummeryReportFile"};
	static  int []   RptID ={0,1,2,3};
	static  String RptHd="";
	static  String MainColHd="";
	static  String SumColHd="";
	static String SubTotalHd="";
	static  String RptH,McolHd,SColHd="";
	static  String Dlp_FileName = "";
	static  String Empower_FileName = "";
	static Date dNow = new Date();
	static SimpleDateFormat ft1 =  new SimpleDateFormat ("MMddyyhhmmSS");
	static SimpleDateFormat ft2 =  new SimpleDateFormat ("MM/dd/yy");
	static SimpleDateFormat ft3 =  new SimpleDateFormat ("MM-dd-yy hh:mm:SS");
	static String filedate=ft1.format(dNow);
	static String rptdate=ft2.format(dNow);
	static String rptdate1=ft3.format(dNow);
	static String Rpt1,Rpt2,Rpt3="";
	static String ProfileType=" ";
	static String ProfileType1=" ";
	static int ExecStat=0;
	static int NoofData = 0;
	static int NoofRec = 0;
	static int NoOfRows=0;
	static int NoOfCols=0;
	   static int NoReport=3;
	
	static String ReportType="H"; 
	static String ReportName=""; 
	static String DlpDataName;
	public static int NoFields=0;
	public static int ArrCnt,ColCnt=0;
	
	static String[] reportLine=new String[2];
	static String closingHtml="</table> </body> </html>";
	//static String rptfileStat="P";
	static String NoOfRowsReturned=" ";
	static String TestScenario="";
	static String TestScenarioLast="";
	static String TestScenarioLastSum="";

	static String TcActual,TcExpected,TcField,TcData="";
	static String XTcActual,XTcExpected,XTcrunStat,XTcField,XTcData="";
	
	static int RptSlNo,RptSlNoSum=0;
	static int RptTotPass,RptTotErr,RptTotal=0;
	static int TotColPass,TotColErr,TotCol=0;
	static String  ScenarioStat,TcrunStat="P";
	
	//static int noOfRowsToProcess,TotColPass,TotColErr=0;
	static ArrayList <String> ARL_Input_Field_Name=new ArrayList <String>(Arrays.asList(" "));
	static ArrayList <String> ARL_Dlp_Field_Value=new ArrayList <String>(Arrays.asList(" "));
	static ArrayList <String> ARL_Empower_Field_Value=new ArrayList <String>(Arrays.asList(" "));
	static ArrayList <String> ARL_Report_dump=new ArrayList <String>(Arrays.asList(" "));
	 
	
	
public static void main(String[] args) throws Throwable {
 
//  Please Change the Report type as  H / V  for Horizontal / Vertical    Report Display *****
		ReportType="H";	

	InitReport_Routine();
//	
 
	//============ 1st Loop
	TestScenario="Borrower preliminary info";
	String inpF="FirstName , LastName , MiddleName , Suffx , Phoneno , DOB , ssno , Meritalstatus , email , street , city , State , zip ,	 Country , yearsofeducation , NoOfdependants , AgeDependent ";
	String inpv= "Robert| Furlan   | D.  | x  | 2123454321  | 11/11/1987  | 123456789  | Married  | Test@gmail.com  | 3127  ";
		 	inpv=inpv+" Cain Rd.  | Kety  | Texas  | 77845  |  USA   | 3  |  3  ";
		inpv=inpv+"|34 ,77,56"; 
 
	HashMap  <String,String> hmapexcel =new  HashMap<String,String>();
	
	TestReport.Create_Report_File();
	String [] Input_field={ "FirstName","LastName","MiddleName","Suffx","Phoneno","DOB","ssno","Meritalstatus","email","street","city","State","zip",
			"Country","yearsofeducation","NoOfdependants","AgeDependent"};
	String [] Input_Dlp_Data={ "Robert ","Furlan ","D.","x","2123454321","11/11/1987","123456789","Married","Test@gmail.com","3127 Cain Rd.","Kety","Texas",
			"77845", "USA ","3", "3", "34,77,56"};
	String[] Input_Empower_Data={ "Robert1 ","Furlan ","D.Mr.","xx", "2123454321","11/11/198","1234567","Married","Test@gmail.","3127 Cain Rd.","Kety","Texas",
			"77845", "USA ","3", "3", "34,77,5"};
	
	Creat_col_heading();
	TestReport.get_Arraylist_Value(TestScenario,Input_field,Input_Dlp_Data,Input_Empower_Data,ReportType);
	TestReport.Update_summary_Data();
	TestReport.WritetAllDetailData();

	//		//=================== 2nd loopest Data
	TestScenario="Assets ";
	String Fld="Borrower,Account,Stock, Other, Liability, Liability, Liability, Property";
	String Dlp="John,Chemical Bank,Stock,Cash On Hand,Spouse,Son,Daughter,Current Residence";
	String Emp="John2,Chemical Ba,Stock,Cash On,Spouse,Son,Daughter,Current Re";
	Input_field=Fld.split(",");
	Input_Dlp_Data=Dlp.split(",");
	Input_Empower_Data=Emp.split(",");
	Creat_col_heading();
		TestReport.get_Arraylist_Value(TestScenario,Input_field,Input_Dlp_Data,Input_Empower_Data,ReportType);
		TestReport.Update_summary_Data();
		TestReport.WritetAllDetailData();
//		 
//	
 		 WriteSummaryData();

}
  
public  static void  Create_Report_File() throws IOException {
	String[] strHd= {"","","",""};
	String  Hdr1="<!DOCTYPE html><html><body><h2 style=\"color:darkblue;\"><left>";
	String  MainHd1="                      "+"Customer portal Automation test Validation Report     ";
//	String  MainHd2=rptdate+"</center></h2>";
	String  MainHd2="</left>"+rptdate+"</h2>";
	String  MColHd="<table style=\"width:70%\" BORDER=20 bgcolor=\"lightYellow\" >\n";
			MColHd=MColHd+"<tr style=\"background-color:lightGrey;\"><th>SL No.</th><th>Test Scenario Name</th><th>Field No.</th><th>Field Name</th> <th>Test Data</th><th> Dlp  </th><th>Empower</th> <th> Passed/Failed </th> </tr>";
	String  SumHd=rptdate+"</center></h2>";
	String  SColHd="<table style=\"width:70%\" BORDER=20 bgcolor=\"lightYellow\" >\n";
	        SColHd=SColHd+"<tr style=\"background-color:lightGrey;\"><th>SL No.</th><th>Test Scenario </th><th>Total Fields</th><th>Pased</th><th>Failed</th><th>Status</th></tr>";
	        MainColHd=MColHd;
	        SumColHd=SColHd;
   String  TSColHd="<table style=\"width:50%\" BORDER=20 bgcolor=\"lightYellow\" >\n";
 	       TSColHd=TSColHd+"<tr style=\"background-color:lightGrey;\"><th>Total Scenarios Executed     </th><th> Total Pased</th><th> Total Failed</th></tr>";
           SubTotalHd=TSColHd;       
	        
	strHd[0]=Hdr1+MainHd1+" for All Scenarios "+ MainHd2;
//	strHd[1]=Hdr1+MainHd1+ " for Passed Scenarios "+MainHd2;
//	strHd[2]=Hdr1+MainHd1+ " for Failed Scenarios "+MainHd2;;
	strHd[3]=Hdr1+MainHd1+ " for Summary Testcase "+SumHd;
	createReportHeader(strHd);
//		for(int file=0;file<3;file++){
//			createColHeader(MainColHd ,file);  // Three Detail file
//		}
			createColHeader(SumColHd ,3);  /// summary file
//	
}
public  static void createReportHeader(String[] Head) throws IOException {  
//	System.out.println("*1. ***** Creating the Heading of the Report *****\n");
	String [] StrFl={RPT_DETAILFILE,RPT_SUMMARYFILE};		
	for(int i=0;i<StrFl.length;i++){	
//		System.out.println("FileName : "+StrFl[i]);
		bw = new BufferedWriter(new FileWriter(StrFl[i],true));
		bw.write(Head[i]);
		bw.close();			
	}
}
public  static void createColHeader(String ColHd , int rptId) throws IOException {  
	System.out.println("*1. ***** Creating Col.  Heading of the Report *****\n");
	String [] StrFl={RPT_DETAILFILE,RPT_PASSFILE,RPT_ERRORFILE,RPT_SUMMARYFILE};		
//		System.out.println("FileName : "+StrFl[rptId]);
		bw = new BufferedWriter(new FileWriter(StrFl[rptId],true));
		bw.write(ColHd);
		bw.close();				 
}

public static void Creat_col_heading() throws IOException{
	for(int file=0;file<3;file++){
		createColHeader(MainColHd ,file);  // Three Detail file
	}
}


public static void InitReport_Routine(){
	RPT_DETAILFILE      =RPT_DETAILFILE+ filedate+".html";
//	RPT_PASSFILE 		=RPT_PASSFILE+ filedate+".html";
//	RPT_ERRORFILE 		=RPT_ERRORFILE+ filedate+".html";
	RPT_SUMMARYFILE 	=RPT_SUMMARYFILE+ filedate+".html";
}

public static void Init_Routine(){
	ARL_Input_Field_Name.removeAll(ARL_Input_Field_Name);
	ARL_Dlp_Field_Value.removeAll(ARL_Dlp_Field_Value);
	ARL_Empower_Field_Value.removeAll(ARL_Empower_Field_Value); 
	for(int i=0;i<3;i++)
		RWriteBuff [i]="";

}




public static void  get_Arraylist_Value(String TestScenario,String[] Arlist1,String [] Arlist2 ,String[] Arlist3,String Report_type) throws Throwable {
	System.out.println("Now  Displaying the Validation Field name ....");
	for(int i=0;i<Arlist1.length;i++) {		
		ARL_Input_Field_Name.add(Arlist1[i]);
//		System.out.println("Field"+i+":"+ ARL_Input_Field_Name.get(i+1) ); 
	}
	 
	System.out.println("\nNow  Displaying the Dlp Data ....");
	for(int i=0;i<Arlist2.length;i++) {		
		ARL_Dlp_Field_Value.add(Arlist2[i]);
//		System.out.println(i+". "+ARL_Input_Field_Name.get(i+1)+" : [ "+ARL_Dlp_Field_Value.get(i+1) + "]");
		
	}
	System.out.println("\nNow  Displaying the Empower Data ....");
	for(int i=0;i<Arlist3.length;i++) {		
		ARL_Empower_Field_Value.add(Arlist3[i]);		
//		System.out.println(i+". "+ARL_Input_Field_Name.get(i+1)+" : [ "+ARL_Empower_Field_Value.get(i+1) + "]");	
	} 	
		ARL_Input_Field_Name.remove(0);
		ARL_Dlp_Field_Value.remove(0);
		ARL_Empower_Field_Value.remove(0); 
		
	TestReport.Dlp_Empower_Data_Validation( ARL_Input_Field_Name, ARL_Dlp_Field_Value,ARL_Empower_Field_Value );
		
}

 //======== Dlp & Empower Data Validation  ===============================================
	public  static void Dlp_Empower_Data_Validation(ArrayList<String> InputFieldName, ArrayList<String> DlpFieldValue, ArrayList<String> EmpowerFieldValue) throws IOException {
		TestScenarioLastSum=TestScenario;
		RptSlNoSum=RptSlNo;
		System.out.println(" Now it is in Data_validation Routine ");
		RptSlNo = RptSlNo +1;
		RptSlNoSum=RptSlNo;
		ScenarioStat="P";
		TotCol=0;TotColPass=0;TotColErr=0;
		XTcField=""; XTcData="";XTcrunStat="P";XTcActual="";XTcExpected="";
		int MaxIndex=InputFieldName.size();
		for(int cnt=0,i=1;cnt<MaxIndex;cnt++,i++) {// ************ processing each field for the Scenario ************
			if (ReportType.equals("H")) {
				TcField=InputFieldName.get(cnt);
				TcData=DlpFieldValue.get(cnt);
			}
			else {
				XTcField=XTcField+" "+i+".) "+InputFieldName.get(cnt)+" ,";
				XTcData=XTcData+" "+i+".) "+DlpFieldValue.get(cnt);
			}
			TcActual=DlpFieldValue.get(cnt);
			TcExpected=EmpowerFieldValue.get(cnt);
			if(TcExpected.equals(TcActual)) {
				TcrunStat="P";
				TotColPass=TotColPass+1;
			}
			else	
			{	TcrunStat="F";
			TotColErr =TotColErr +1;
			}

			if (ReportType.equals("H")) {
				Process_Field_info();  // Printing for Horizontal printing
			}
			else
				XTcActual=XTcActual+" "+i+".) "+TcActual+" |,";
			XTcExpected=XTcExpected+" "+i+".) "+TcExpected+" |,";

		}
		if (ReportType.equals("V"))
			Process_Field_info();

		if (TotColErr>0)
			ScenarioStat="F";
		else
			ScenarioStat="F";

	}

	public  static void Process_Field_info() throws IOException {
		    TotCol=TotCol+1;
//		    System.out.println("TotCol "+ TotCol+ " Pass "+TotColPass+" Fail "+TotColErr);
			TestReport.Set_Process_Data();
			
	}
	public  static void Set_Process_Data() {
		ExecStat=ExecStat+1;
		
//		  System.out.println("TotCol "+ TotCol+ " Pass "+TotColPass+" Fail "+TotColErr);
		if(!TestScenarioLast.equals(TestScenario))
			
		{  // System.out.println("TotCol "+ TotCol+ " Pass "+TotColPass+" Fail "+TotColErr+ " Scn "+TestScenarioLastSum);
			RptSlNoSum=RptSlNo;
		  TestScenarioLastSum=TestScenario;
			TestScenarioLast=TestScenario;
			// ***** Writing a control total for the last Scenario *******
			reportLine[0]="<tr><td style=\"color:white;background-color:darkblue;\">"+RptSlNo+
					       "</td><td style=\"color:white;background-color:darkblue;\">"+TestScenarioLastSum;			 
			Rpt3=reportLine[0];
            
		}
		else 
		Rpt1=Rpt3;
		reportLine[0]="<tr><td></td><td></td>";
		
 		    if (ExecStat<2){
		    	reportLine[0]="<tr><td style=\"color:white;background-color:darkblue;\">"+RptSlNoSum+
					       "</td><td style=\"color:white;background-color:darkblue;\">"+TestScenarioLastSum;
		    	//Rpt2="N"; 
		   	    }
// 		   System.out.println("TotCol "+ TotCol+ " Pass "+TotColPass+" Fail "+TotColErr);
		if (ReportType.equals("H")){
			reportLine[0]=reportLine[0] +"</td><td style=\"color:white;background-color:darkblue;\">"+Integer.toString(TotCol)+
					"</td><td style=\"color:white;background-color:darkblue;\">"+TcField+"</td> <td>"+TcData+"</td><td>"+TcActual+"</td>";  
			Rpt1=Rpt3+"</td><td style=\"color:white;background-color:darkblue;\">"+Integer.toString(TotCol)+
			"</td><td style=\"color:white;background-color:darkblue;\">"+TcField+"</td> <td>"+TcData+"</td><td>"+TcActual+"</td>";
		}
		else
			reportLine[0]=reportLine[0] +"</td><td>"+Integer.toString(TotCol)+"</td> <td>"+XTcField+"</td> <td>"+XTcData+"</td><td>"+ XTcActual+"</td>";  
		    
		if (ReportType.equals("H")) {
			if (TcrunStat.equals("P")){
				reportLine[0]=reportLine[0]+"<td style=\"color:white;background-color:green;\">"+TcExpected+"</td>\"<td style=\"color:white;background-color:green;\">Passed</td></tr>";
				Rpt1=Rpt1+"<td style=\"color:white;background-color:green;\">"+TcExpected+"</td>\"<td style=\"color:white;background-color:green;\">Passed</td></tr>";
				//System.out.println("Tpass "+TotColPass);
			}
			else if (TcrunStat.equals("F")){						
				reportLine[0]=reportLine[0]+"<td style=\"color:white;background-color:red;\">"+TcExpected+"</td>\"<td style=\"color:white;background-color:red;\">Failed</td></tr>";	
				Rpt1=Rpt1+"<td style=\"color:white;background-color:red;\">"+TcExpected+"</td>\"<td style=\"color:white;background-color:red;\">Failed</td></tr>";	
			}
		}
		else {
			if (TcrunStat.equals("P")){
				RptTotPass=RptTotPass+1;
				reportLine[0]=reportLine[0]+"<td style=\"color:white;background-color:green;\">"+XTcExpected+"</td><td style=\"color:white;background-color:green;\">Passed</td></tr>";
			}
			else if (TcrunStat.equals("F")){
				RptTotErr=RptTotErr+1;
				reportLine[0]=reportLine[0]+"<td style=\"color:white;background-color:red;\">"+XTcExpected+"</td><td style=\"color:white;background-color:red;\">Failed</td></tr>";	
			}
		}
																																								
		RWriteBuff[0]= RWriteBuff[0]+reportLine[0];//  All Report Detail & Summary
		if ((TotCol==1) && (TotColPass==1))
			Rpt2="P";
		else if ((TotCol==1) && (TotColErr==1))
			Rpt2="F";

		if (TcrunStat=="P"){
			if ((TotCol==2) && (TotColPass==1) && ( Rpt2!="P")) { //&&(Rpt2.equals("N"))
				RWriteBuff[1]= RWriteBuff[1]+Rpt1;Rpt2="P"; // All Passed Report	
				System.out.println("Tpass "+TotColPass);
 			}
			else
				RWriteBuff[1]= RWriteBuff[1]+reportLine[0];// All Passed Report
		}
		else
			if ((TotCol==2) && (TotColErr==1) && ( Rpt2!="F")) { 
				RWriteBuff[2]= RWriteBuff[2]+Rpt1; Rpt2="F";// All Passed Report	
								System.out.println("TFail "+TotColErr);
			}
			else 
				RWriteBuff[2]= RWriteBuff[2]+reportLine[0];// All Fails Report
	}
	//		System.out.println("Check Detail data  Passed :\n "+RWriteBuff[1]+" Failed\n "+RWriteBuff[2]);

	
	
	
	public  static void  Update_summary_Data() throws IOException {
		System.out.println("..... Update Summary Data ");			 
//		String SummaryData="<tr><td>"+Integer.toString(RptSlNo)+"</td><td style=\"color:white;background-color:darkblue;\">"+TestScenarioLast;
		 RptTotal=RptTotal+1;
	    	     
 		 String Sdata="<tr> <td style=\"color:white;background-color:darkblue;\">"+RptSlNoSum+"</td><td style=\"color:white;background-color:darkblue;\">"+TestScenarioLastSum+"</td><td>"+TotCol+"</td><td style=\"color:white;background-color:green;\">"+TotColPass;
						Sdata=Sdata+"</td><td style=\"color:white;background-color:red;\">"+TotColErr+"</td>";

		
						
			if (ScenarioStat=="P"){
				Sdata=Sdata+"<td style=\"color:white;background-color:green;\">Passed</td></h2></tr>";
					RptTotPass=RptTotPass+1;
			}
			else {
				Sdata=Sdata+"<td style=\"color:white;background-color:red;\">Failed</td></tr>";
			    	RptTotErr=RptTotErr+1;
			}
 			RWriteBuff[3]=RWriteBuff[3]+Sdata;
 			RWriteBuff[0]=RWriteBuff[0]+Sdata;
  	}
	
public  static void  writeToFile(String fld) throws IOException {
	 Findex=3; /// for 0,1,2
	 String [] StrFl={RPT_DETAILFILE,RPT_PASSFILE,RPT_ERRORFILE};
	 for(int  i =0;i<Findex;i++){		
		 bw = new BufferedWriter(new FileWriter(StrFl[i],true));
		 bw.write(RWriteBuff[i]+closingHtml);
		 bw.close();
		 RWriteBuff[i]="";
	 }
	 Findex=0;
	}


//	public  static void  OpenFile() throws IOException {
//		bw = new BufferedWriter(new FileWriter(FILENAME ,true));
//	}
	
	
	 public static void WritetAllDetailData() throws IOException{
		 Findex=3; /// for 0,1,2
		 String [] StrFl={RPT_DETAILFILE,RPT_PASSFILE,RPT_ERRORFILE};
		 for(int  i =0;i<Findex;i++){		
			 bw = new BufferedWriter(new FileWriter(StrFl[i],true));
			 bw.write(RWriteBuff[i]+closingHtml);
			 bw.close();
			 RWriteBuff[i]="";
		 }
		 Findex=0;
	 }
	 
	 public static void WriteSummaryData() throws IOException{
		 Findex=3;
		 String [] StrFl={RPT_DETAILFILE,RPT_PASSFILE,RPT_ERRORFILE,RPT_SUMMARYFILE};
		 System.out.println("  Summary Test "+ RptFile[Findex]+"\n"+RWriteBuff[Findex]);
		 bw = new BufferedWriter(new FileWriter(StrFl[Findex],true));
		 bw.write(RWriteBuff[Findex]);
		// bw.write(RWriteBuff[Findex]+closingHtml);
		 bw.close();
		 
		 System.out.println("Closing Summary report ->\n "+RptFile[Findex]);
		 
	 }
	 
	 public static void Write_finalClosing() throws IOException{
		 Findex=3;
		 String [] StrFl={RPT_DETAILFILE,RPT_PASSFILE,RPT_ERRORFILE,RPT_SUMMARYFILE};
		 bw = new BufferedWriter(new FileWriter(StrFl[Findex],true));
		RWriteBuff[Findex]=closingHtml;
		 bw.write(RWriteBuff[Findex]);
		 bw.close();
		 
		 System.out.println("Closing Summary report ->\n "+RptFile[Findex]);
	 }
 		
		public  static void  write(String fld) throws IOException {
			bw.write(fld);
		}
		
//		public  static void  OpenFile() throws IOException {
//			bw = new BufferedWriter(new FileWriter(FILENAME,true));
//		}

		public  static void  closeFile() throws IOException {
			bw.close();
		}	
}
	


