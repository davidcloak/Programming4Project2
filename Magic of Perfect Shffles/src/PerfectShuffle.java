/**
 ******************************************************************************
 *                    Project #2
 ******************************************************************************
 *                    Magic of Perfect Shuffles
 ******************************************************************************
 *
 *
 *
 * Name:  David Cloak
 *
 * Class: Programming IV
 * 
 * Date:  10/11/2018
 ******************************************************************************/

import java.util.*;

public class PerfectShuffle
{
    private int[] deck;//has value changed
    private int[] full;//Original deck
    private int[] deckHolder;//copy of deck for changing values
    private int deckSize;//size of the deck
        // IMPLEMENT THIS CLASS
    PerfectShuffle(int n){
        //sets value(s) for deck size and card num or array length
        deckSize = n;
        full = new int[n];
        deck = new int[n];
        deckHolder = new int[n];
        for(int i = 0; i < n; i++){
            full[i] = i;
            deck[i] = i;
        }
        
    }
    
    
    
    public int[] inShuffle(int[] input){
        //makes a copy of deck to deckHolder
        for(int x = 0; x < input.length; x++){
            deckHolder[x] = input[x];
        }
        
        //uses deckHolder to change values in deck
        for(int x = 0; x < deckSize; x+=2){
            //divided by 2 so it go up by 1
            input[x] = deckHolder[(x/2)+26];//adds 26 to start with back end
            input[x+1] = deckHolder[x/2];
        }
        return input;
    }
    
    
    public int perfectInShuffle(){
        int count = 0;//counts number of times for full shuffle
            do{
                deck = this.inShuffle(deck);
                
                count++;
            }while(!Arrays.equals(deck, full));//check to see if the array value
        return count;                          // are same but not position in storage
    }
    
    
    //comment seperating in and out Shuffles
    
    
    public int[] outShuffle(int[] input){
        //makes a copy of deck to deckHolder
        for(int x = 0; x < input.length; x++){
            deckHolder[x] = input[x];
        }
        
        //uses deckHolder to change values in deck
        for(int x = 0; x < deckSize; x+=2){
            //divided by 2 so it go up by 1
            input[x] = deckHolder[x/2];
            input[x+1] = deckHolder[(x/2)+26];//adds 26 to start with back end
        }
        return input;
    }
    
    
    public int perfectOutShuffle(){
        int count = 0;//counts number of times for full shuffle
            do{
                deck = this.outShuffle(deck);
                
                count++;
            }while(!Arrays.equals(deck, full));//check to see if the array value
        return count;                          // are same but not position in storage
    }
    
    
    //comment seperating outShuffle and moveTopCard
    
    
    public int[] moveTopCard(int z){
        int[] deckChange = new int[deck.length];
        //makes a copy of deck to deckChange so that deck is unchanged
        for(int x = 0; x < deck.length; x++){
            deckChange[x] = deck[x];
        }
        
        String binary = Integer.toBinaryString(z);
        for(int x = 0; x < binary.length(); x++){
            if(binary.charAt(x) == 49){//One is == to 49 as a String or char
                deckChange = this.inShuffle(deckChange);//calls & sets inshuffle
            }else if(binary.charAt(x) == 48){//Zero is == to 48 as a String or Char
                deckChange = this.outShuffle(deckChange);//calls & sets outShuffle
            }
        }
        return deckChange;
    }
}