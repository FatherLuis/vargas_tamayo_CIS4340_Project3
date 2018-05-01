/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_cis4340_project3;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

//Class name: File_IO
//Class Author: Luis E. Vargas Tamayo
//Purpose of the class: Reads the file for the rules for the turing machine
//Date: 2/27/2018
//List of changes with dates: none
//Special Notes: Code would look cleaner if i would have made had more time
public class File_IO 
{
    File txtFile;
    String fileName;
    JFileChooser chooser;
    private HashRuleBook RuleBook;
    
    //Method Name: File_IO()
    //Purpose: Constructor
    //Parameter: none
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public File_IO()
    {
        String userDirLocation = System.getProperty("user.dir");
        //Gets file
        try
        {
            txtFile = new File(userDirLocation);
            chooser = new JFileChooser(txtFile); //creates the file dialog box to get a file from computer
            chooser.showOpenDialog(null); //shows the dialog box
            txtFile =  chooser.getSelectedFile();
        }
        catch(Exception ex){}
 
        //initiate hashtable
        RuleBook = new HashRuleBook();
    }
 
    //Method Name: File_IO()
    //Purpose: Constructor
    //Parameter: none
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public HashRuleBook GetRuleBook(){return this.RuleBook;}
    
    //Method Name: GetFileName()
    //Purpose: get filename from class variabale
    //Parameter: none
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public String GetFileName(){return fileName;}
      
    //Method Name: ReadFile()
    //Purpose: Reads each line of the text file and gets the rules and place sthem in the hashtable
    //Parameter: none
    //Method Input: CreateRuleBook()
    //Return Value: none
    //Date: 4/30/2018
    public void ReadFile() throws Exception
    {
        //String filePath = txtFile.getAbsolutePath(); //gets file's path
        fileName = txtFile.getName();      
        //BufferedReader br = new BufferedReader(new FileReader(fileName));    //not sure what this is

            Scanner sc = new Scanner(txtFile);  
             //CHECKS IS THERE EXIST ANOTHER LINE IN THE TEXT FILE
            while(sc.hasNextLine())
            {
                //SENDS THE LINE WITH CODE TO THE METHOD
                CreateRulebook(sc.nextLine());
            }

    }
        
    //Method Name: CreateRulebook()
    //Purpose: Creates the rule book from the rules found in the file
    //Parameter: string
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    private void CreateRulebook(String strRule)
    {
        //ARRAY WILL HOLD THE RULES
        String[] rule = new String[5];

        // CHECKS IF THE STRING IS EMPTY
        if(!strRule.isEmpty())
        {
            
            //THESE ARE THE PATTERNS I AM LOOKING FOR IN EACH LINE FROM THE TEXT
            
            String ptnAccept = "Accept"; //LOOKS TO SEE IF THE STRING CONTAINS THE ACCEPT
            String ptnOldState = "(?<=\\()\\s*\\d*"; // LOOKS FOR THE CURRENT STATE
            String ptnOldVar = "(?<=\\,)\\s*\\w*"; //LOOKS FOR THE CURRENT VARIABLE
            String ptnNewState = "(?<=\\=\\()\\s*\\d*"; // LOOKDS FOR THE NEW STATE
            String ptnNewVar = "(?<=\\,)\\s*\\w*\\s*(?=\\,)"; //LOOKS FOR THE NEW VARIABLE
            String ptnPhaseChange = "[R|L]";  //LOOKS FOR THE PHASE CHANGERS
            
            //LOOKS FOR THE CURRENT STATE
            Pattern ptn = Pattern.compile(ptnOldState);
            Matcher match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[0] = match.group(0);
                
                if(match.group(0).isEmpty())
                {
                    rule[1] = "";
                }
            }
            else
            {
                rule[1] = "";
            }
                       

            //LOOKS FOR THE CURRENT VARIABLE
            ptn = Pattern.compile(ptnOldVar);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[1] = match.group(0);  
                if(match.group(0).isEmpty())
                {
                    rule[1] = "";
                }
            }
            else
            {
                rule[1] = "";
            
            }
            
            //LOOKS FOR THE NEW STATE
            ptn = Pattern.compile(ptnNewState);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[2] = match.group(0);
                
                //LOOKS FOR THE NEW VARIABLE
                ptn = Pattern.compile(ptnNewVar);
                match = ptn.matcher(strRule);
                if(match.find())
                {
                    rule[3] = match.group(0);

                    
                    if(match.group(0).isEmpty())
                    {
                        rule[3] = "";
                    }
                }
                else
                {
                    rule[3] = "";
                }
                    
                //LOOKS FOR THE PHASE CHANGER
                ptn = Pattern.compile(ptnPhaseChange);
                match = ptn.matcher(strRule);
                if(match.find())
                {
                    rule[4] = match.group(0);
                    
                    if(match.group(0).isEmpty())
                    {
                        rule[4] = "";
                    }
                } 
                else
                {
                    rule[4] = "";
                }               
    
            }
            else
            {
                //SINCE NO NEW STATE WAS FOUND, CHECK TO SEE IF YOU FIND THE ACCEPT
                ptn = Pattern.compile(ptnAccept);
                match = ptn.matcher(strRule);
                if(match.find())
                { 
                    rule[2] = "Accept";
                    rule[3] =  "Accept";
                    rule[4] = "Accept";     
                }
                //SINCE NEITHER THE ACCEPT OF A NEW STATE WAS FOUND, WE SET THE BOX AS EMPTY
                else
                {
                    rule[2] = "";
                    rule[3] = "";
                    rule[4] = ""; 
                }
            }
            //System.out.println(Arrays.toString(rule) + "\n");
        
            RuleBook.HashRule(rule[0], rule[1], rule[2], rule[3], rule[4]);
        
        }
    }  
}
