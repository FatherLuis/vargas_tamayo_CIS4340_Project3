/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_cis4340_project3;

import java.util.Arrays;


public class HashRuleBook 
{
    private String[][] RuleBook;
    
    
    public HashRuleBook()
    {
        RuleBook = new String[270][1];
    }
    
    public void SetRuleBook(String[][] RuleBook){this.RuleBook = RuleBook;}
    public String[][] GetRuleBook(){return this.RuleBook;}
    
    private int CreateKey(String incomingState, String letter)
    {
        int key = 0;
        int value;
        
        switch(letter)
        {
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
                System.out.println("Something is Wrong");
                
        }
    
    
    
    
    
        return key;
    }
    
    public void HashRule(String incomingState, String incomingLetter, String newState, String phaseChange, String directionChange)
    {
        int key = CreateKey(incomingState, incomingLetter);
        String[] box = {newState, phaseChange, directionChange};       
        RuleBook[key] = box;
    }
    
    private String[] Instructions(String incomingState, String incomingLetter)
    {
        int key = CreateKey(incomingState, incomingLetter);
        String[] box = null;
        try
        {

            box = RuleBook[key];
            
        } catch(Exception ex){System.out.println("Rule Does not Exist");}
                
            System.out.println("             Box status: "+Arrays.toString(box));
            
            if(box[0] == null)
            {
                box = null;
            }
            else
            {
                
                System.out.println("             1___________Random");
                
                if(box[0].isEmpty() || box[2].isEmpty())
                {
                    box = null;      
                }
                
                System.out.println("             2___________Random");

            }
            //System.out.println(Arrays.toString(box));
            
            return box;   

    }
    
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
    
    public boolean CheckString(String userInput)
    {
        String strInput = "  " + userInput + "  ";
        char[] medium;
        String currentState = "1";
        int index = 2;
        //String finalState = "2";
        boolean isAccepted = false;
        
        //Character.toString(userInput.charAt(i))
        
        try
        {
            while(true)
            {
                System.out.println("\n1--------------------1");
                String[] box = Instructions(currentState, Character.toString(strInput.charAt(index)));
                System.out.println("2--------------------2");
                
                System.out.println("\n"+Arrays.toString(box));
                
                
                if(box != null)
                {
                    if(box[0].equals("Accept"))
                    {
                        return true;
                    }
                    else
                    {
                        currentState = box[0];
   
                        medium = strInput.toCharArray();
                        medium[index] = box[1].charAt(0);
                        strInput = String.valueOf(medium);
                        //System.out.println(strInput);

                        index += PhaseChanger(box[2]);  
                    }
                    
                }
                else
                {
                    return false;
                }
            }

        }catch(Exception ex){ System.out.println("Something Went Wrong...Fix it");}
        

        return isAccepted;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
