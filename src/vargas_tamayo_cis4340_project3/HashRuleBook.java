/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vargas_tamayo_cis4340_project3;


public class HashRuleBook 
{
    private String[][] RuleBook;
    
    
    public HashRuleBook()
    {
        RuleBook = new String[260][1];
    }
    
    public void SetRuleBook(String[][] RuleBook){this.RuleBook = RuleBook;}
    public String[][] GetRuleBook(){return this.RuleBook;}
    
    private int CreateKey(String incomingState, String letter)
    {
        int key = 0;
        int value;
        
        switch(letter)
        {
            case "a":
                value = 0;
                key = value + Integer.parseInt(incomingState);
                break;
            case "b":
                value = 10;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "c":
                value = 20;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "d":
                value = 30;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "e":
                value = 40;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "f":
                value = 50;
                key = value + Integer.parseInt(incomingState);
                break;
            case "g":
                value = 60;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "h":
                value = 70;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "i":
                value = 80;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "j":
                value = 90;
                key = value + Integer.parseInt(incomingState);
                break;         
            case "k":
                value = 100;
                key = value + Integer.parseInt(incomingState);
                break;
            case "l":
                value = 110;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "m":
                value = 120;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "n":
                value = 130;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "o":
                value = 140;
                key = value + Integer.parseInt(incomingState);
                break;         
            case "p":
                value = 150;
                key = value + Integer.parseInt(incomingState);
                break;
            case "q":
                value = 160;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "r":
                value = 170;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "s":
                value = 180;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "t":
                value = 190;
                key = value + Integer.parseInt(incomingState);
                break; 
            case "u":
                value = 200;
                key = value + Integer.parseInt(incomingState);
                break;
            case "v":
                value = 210;
                key = value + Integer.parseInt(incomingState);
                break;               
            case "w":
                value = 220;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "x":
                value = 230;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "y":
                value = 240;
                key = value + Integer.parseInt(incomingState);
                break;        
            case "z":
                value = 250;
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
    
    public String[] Instructions(String incomingState, String incomingLetter)
    {
        int key = CreateKey(incomingState, incomingLetter);
        String[] box = {"-1","-1","-1"};
        try{ box = RuleBook[key];} catch(Exception ex){System.out.println("Rule Does not Exist");}
        return box;
    }
    
    public boolean CheckString(String userInput)
    {
        String finalState = "2";
        boolean isAccepted = false;
        
        
        
        
    
    
    
        
        
        
        
        
        
        
        
        
    
    
    
        return isAccepted;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
