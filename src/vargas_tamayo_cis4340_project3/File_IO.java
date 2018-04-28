/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_cis4340_project3;

import java.io.File;
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
    
    public File_IO()
    {
        chooser = new JFileChooser(); //creates the file dialog box to get a file from computer
        chooser.showOpenDialog(null); //shows the dialog box
        
        txtFile =  chooser.getSelectedFile();
    }
    
    public void readFile() throws Exception
    {
        //String filePath = txtFile.getAbsolutePath(); //gets file's path
        fileName = txtFile.getName();      
        //BufferedReader br = new BufferedReader(new FileReader(fileName));    //not sure what this is

            Scanner sc = new Scanner(txtFile);  
            
            while(sc.hasNextLine())
            {
                HashRules(sc.nextLine());
            }

    }
    
    private void HashRules(String strRule)
    {
        System.out.println("strRule " + strRule);
        if(!strRule.isEmpty())
        {
            
            String ptnOldState = "(?<=\\()\\s*\\d*";
            String ptnOldVar = "(?<=\\,)\\s*\\w*";
            String ptnNewState = "(?<=\\=\\()\\s*\\d*";
            String ptnNewVar = "(?<=\\,)\\s*\\w*\\s*(?=\\,)";
            String ptnPhaseChange = "(?<=\\,)\\s*\\w\\s*(?=\\))"; 
            
            Pattern ptn = Pattern.compile(ptnOldState);
            Matcher match = ptn.matcher(strRule);
            if(match.find())
            {
                System.out.println("Found: " + match.group(0));
            }
            
            ptn = Pattern.compile(ptnOldVar);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                System.out.println("Found: " + match.group(0));
            }
            
            //if statement for accept needed
            ptn = Pattern.compile(ptnNewState);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                System.out.println("Found: " + match.group(0));
            }
            
            ptn = Pattern.compile(ptnNewVar);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                System.out.println("Found: " + match.group(0));
            }
            
            ptn = Pattern.compile(ptnPhaseChange);
            match = ptn.matcher(strRule);
            if(match.find())
            {
                System.out.println("Found: " + match.group(0));
            }            
            
            
                
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        }
    
    
    
    
    
    }
    
    
    
    
    
    
}
