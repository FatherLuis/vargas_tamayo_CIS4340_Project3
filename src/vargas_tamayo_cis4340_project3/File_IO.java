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

/**
 *
 * @author fathe
 */
public class File_IO 
{
    File txtFile;
    String fileName;
    JFileChooser chooser;
    private HashRuleBook RuleBook;
    
    public File_IO()
    {
        chooser = new JFileChooser(); //creates the file dialog box to get a file from computer
        chooser.showOpenDialog(null); //shows the dialog box
        
        txtFile =  chooser.getSelectedFile();
        RuleBook = new HashRuleBook();
    }
    
    public HashRuleBook GetRuleBook(){return this.RuleBook;}
    
    public void readFile() throws Exception
    {
        //String filePath = txtFile.getAbsolutePath(); //gets file's path
        fileName = txtFile.getName();      
        //BufferedReader br = new BufferedReader(new FileReader(fileName));    //not sure what this is

            Scanner sc = new Scanner(txtFile);  
            
            while(sc.hasNextLine())
            {
                CreateRulebook(sc.nextLine());
            }

    }
    
    private void CreateRulebook(String strRule)
    {
        String[] rule = new String[5];
        
        System.out.println("strRule " + strRule);
        if(!strRule.isEmpty())
        {
            
            String ptnAccept = "Accept";
            String ptnOldState = "(?<=\\()\\s*\\d*";
            String ptnOldVar = "(?<=\\,)\\s*\\w*";
            String ptnNewState = "(?<=\\=\\()\\s*\\d*";
            String ptnNewVar = "(?<=\\,)\\s*\\w*\\s*(?=\\,)";
            String ptnPhaseChange = "[R|L]"; 
            
            
            Pattern ptn = Pattern.compile(ptnOldState);
            Matcher match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[0] = match.group(0);
                System.out.println("Found: " + match.group(0));
                
                if(match.group(0).isEmpty())
                {
                    System.out.println("Cannot be empty");
                    rule[1] = "";
                }
            }
            else
            {
                System.out.println("Cannot be empty");
            }
                       


            ptn = Pattern.compile(ptnOldVar);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[1] = match.group(0);
                System.out.println("Found: " + match.group(0));
                
                if(match.group(0).isEmpty())
                {
                    System.out.println("empty");
                    rule[1] = "";
                }
            }
            else
            {
                rule[1] = "";
            
            }
                    
            ptn = Pattern.compile(ptnNewState);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                rule[2] = match.group(0);
                System.out.println("Found: " + match.group(0));
                
                ptn = Pattern.compile(ptnNewVar);
                match = ptn.matcher(strRule);
                if(match.find())
                {
                    rule[3] = match.group(0);
                    System.out.println("Found: " + match.group(0));
                    
                    if(match.group(0).isEmpty())
                    {
                        System.out.println("empty");
                        rule[3] = "";
                    }
                }
                else
                {
                    rule[3] = "";
                }

                ptn = Pattern.compile(ptnPhaseChange);
                match = ptn.matcher(strRule);
                if(match.find())
                {
                    rule[4] = match.group(0);
                    System.out.println("Found: " + match.group(0));
                    
                    if(match.group(0).isEmpty())
                    {
                        System.out.println("Cannot be empty");
                        rule[4] = "";
                    }
                } 
                else
                {
                    rule[4] = "";
                    System.out.println("Cannot be empty");
                }               
    
            }
            else
            {
                ptn = Pattern.compile(ptnAccept);
                match = ptn.matcher(strRule);
                if(match.find())
                {
                    System.out.println("Found: " + match.group(0));  
                    rule[2] = "Accept";
                    rule[3] =  "Accept";
                    rule[4] = "Accept";     
                }
                else
                {
                    rule[2] = "";
                    rule[3] = "";
                    rule[4] = ""; 
                    System.out.println("Cannot be empty");
                
                }
            }
            
            
            System.out.println(Arrays.toString(rule) + "\n");
        
            RuleBook.HashRule(rule[0], rule[1], rule[2], rule[3], rule[4]);
        
        }
    
    
    
    
    
    }
    
    
    
    
    
    
}
