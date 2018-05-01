/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_cis4340_project3;

import java.util.Arrays;

//Class name: HashRuleBook
//Class Author: Luis E. Vargas Tamayo
//Purpose of the class: Stores the rules in a hashtable
//Date: 4/30/2018
//List of changes with dates: none
//Special Notes: Code would look cleaner if i would have made had more time
public class HashRuleBook 
{
    private String[][] RuleBook;
    
    //Method Name: HashRuleBook()
    //Purpose: Constructor
    //Parameter: none
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public HashRuleBook()
    {
        //instantiate
        RuleBook = new String[270][1];
    }
       
    //Method Name:SetRuleBook()
    //Purpose: Setter
    //Parameter: String[][]
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public void SetRuleBook(String[][] RuleBook){this.RuleBook = RuleBook;}
     
    //Method Name:
    //Purpose: Getter
    //Parameter: none
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public String[][] GetRuleBook(){return this.RuleBook;}
     
    //Method Name: CreateKey
    //Purpose: Creates the key for where the rules are located in the hashtable
    //Parameter: String, String
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    private int CreateKey(String incomingState, String letter)
    {
        //Key-Value
        int key = 0;
        //Letter Value
        int value;
        
        //VALUE OF EACH LETTER IS GIVEN IN EACH CASE
        switch(letter)
        {
            //SPACES ARE GIVEN A ZERO VALUE
            case " ":
                key = Integer.parseInt(incomingState);
                break;
            case "a":
                value = 10;
                key = value + Integer.parseInt(incomingState);
                break;
            case "b":
                value = 20;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "c":
                value = 30;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "d":
                value = 40;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "e":
                value = 50;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "f":
                value = 60;
                key = value + Integer.parseInt(incomingState);
                break;
            case "g":
                value = 70;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "h":
                value = 80;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "i":
                value = 90;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "j":
                value = 100;
                key = value + Integer.parseInt(incomingState);
                break;         
            case "k":
                value = 110;
                key = value + Integer.parseInt(incomingState);
                break;
            case "l":
                value = 120;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "m":
                value = 130;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "n":
                value = 140;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "o":
                value = 150;
                key = value + Integer.parseInt(incomingState);
                break;         
            case "p":
                value = 160;
                key = value + Integer.parseInt(incomingState);
                break;
            case "q":
                value = 170;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "r":
                value = 180;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "s":
                value = 190;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "t":
                value = 200;
                key = value + Integer.parseInt(incomingState);
                break; 
            case "u":
                value = 210;
                key = value + Integer.parseInt(incomingState);
                break;
            case "v":
                value = 220;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "w":
                value = 230;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "x":
                value = 240;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "y":
                value = 250;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "z":
                value = 260;
                key = value + Integer.parseInt(incomingState);
                break;            
            default:
                key = 0;
                //only reason it would reach default is because the string
                //is not a letter, rather a special character
        }
    
    
    
    
    
        return key;
    }
      
    //Method Name: HashRule()
    //Purpose: Places the rules in the hashable
    //Parameter: String incomingState, String incomingLetter, String newState, String phaseChange, String directionChange
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    public void HashRule(String incomingState, String incomingLetter, String newState, String phaseChange, String directionChange)
    {
        //Creates key for allocating the rule in the hashtable
        int key = CreateKey(incomingState, incomingLetter);
        //Array will hold the rule
        String[] box = {newState, phaseChange, directionChange};      
        //places the rules in the hashtable in the allocated key location
        RuleBook[key] = box;
    }
      
    //Method Name: Instructions
    //Purpose: Gets rule from the hashtable
    //Parameter: String incomingState, String incomingLetter
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    private String[] Instructions(String incomingState, String incomingLetter)
    {
        //Gets key, if exist, FROM THE GIVEN PARAMETERS
        int key = CreateKey(incomingState, incomingLetter);
        //INSTANTIATES
        String[] box = null;
        
        //TRY CATCH IS USED BECAUSE THE RULE MIGHT NOT EXIST AND THUS SOME CODE
        //WILL NOT WORK
        try
        {
            //GETS THE RULES FROM THE HASHTABLE
            box = RuleBook[key];
            
        } catch(Exception ex){System.out.println("Rule Does not Exist");}
            
            if(box[0] == null)
            {
                box = null;
            }
            else
            {          
                //CHEKS IF THE RULES ARE COMPLETE, IF THEY ARE NOT, THEN SET THE BOX AS NULL
                if(box[0].isEmpty() || box[2].isEmpty())
                {
                    box = null;      
                }
            }
            
            return box;   

    }
        
    //Method Name: PhaseChanger
    //Purpose: returns a numeric value of the representation of the given letter
    //Parameter: String
    //Method Input: none
    //Return Value: none
    //Date: 4/30/2018
    private int PhaseChanger(String letter)
    {       
        if(letter.equals("R"))
        {
            return 1;
        }
        else if(letter.equals("L"))
        {
            return -1;
        }

            return 0;
    }
       
    //Method Name: CheckString
    //Purpose: checks if a string follows the rules
    //Parameter: String
    //Method Input: none
    //Return Value: Boolean
    //Date: 4/30/2018
    public boolean CheckString(String userInput)
    {
        //Gives an extra space before and after the string
        String strInput = "  " + userInput + "  ";
        //variable that holds an array of char
        char[] medium;
        //the beginning state is always one
        String currentState = "1";
        int index = 2; // the string starts on index 2

        //MOST ERRORS OCCUR BECAUSE RULE IS NOT FOUND
        try
        {
            //LOOPS UNTIL FOREVER
            while(true)
            {
                //GETS RULES FROM HASHTABLE
                String[] box = Instructions(currentState, Character.toString(strInput.charAt(index)));

                if(box != null)
                {
                    if(box[0].equals("Accept"))
                    {
                        return true;
                    }
                    else
                    {
                        //CHANGES THE STRING TO THE CHANGES ASKED BY THE RULES
                        currentState = box[0];
                        medium = strInput.toCharArray();
                        medium[index] = box[1].charAt(0);
                        strInput = String.valueOf(medium);
                        //MOVES THE HEAD TO THE NEXT LOCATION
                        index += PhaseChanger(box[2]);  
                    }
                    
                }
                else
                {
                    return false;
                }
            }

        }catch(Exception ex){ System.out.println("Rule was not found");}
        

        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
