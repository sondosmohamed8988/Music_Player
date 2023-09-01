/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;




import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusicPlayer {

    static void FillOutMainList (linkList mainList, linkList myList)
    {
        mainList.insertLast(1, "Elfatha", "Elhosary");
        mainList.insertLast(2, "Elfil", "Elmenshawy");
        mainList.insertLast(3, "Quraish", "Elagamy");
        mainList.insertLast(4, "Elkauther", "Elhosary");
        mainList.insertLast(5, "Elkaferon", "Sherem");
        mainList.insertLast(6, "Elnaser", "Elmenshawy");
        mainList.insertLast(7, "Elmasd", "Elagamy");
        mainList.insertLast(8, "Elekhlas", "Sherem");
        mainList.insertLast(9, "Elfalk", "Elhosary");
        mainList.insertLast(10, "Elnas", "Elmenshawy");
        
    }// end mainList insetion
    //*************************************************************************************************************
    
    
    
    
    
        public static boolean playSong (String URI) throws UnsupportedAudioFileException, LineUnavailableException, IOException
    {
          Scanner scanner = new Scanner(System.in);
  
        File file = new File(URI);
  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
  Clip clip = AudioSystem.getClip();
  clip.open(audioStream);
  String response = "";
  
   System.out.println("\tP -> Play\n\tS -> Stop\n\tF -> Flush 3S\n\tL -> Loop\n\tR -> Restart\n\tK -> Skip\n\tC -> Close");
 
   int i=0;
   while(!response.equals("C")) {
   System.out.print("Enter your choice: ");
     if (++i == 1) clip.start();
    // if (clip.getMicrosecondPosition() == clip.getMicrosecondLength()) return true;
   response = scanner.next();
   
   response = response.toUpperCase();
   switch(response) {
    case ("P"): clip.start();
    break;
    case ("S"): clip.stop();
    break;
     case ("F"): clip.flush();
    break;
    case ("L"): clip.loop(1);
    break;
    case ("R"): clip.setMicrosecondPosition(0);
    break;
    case ("K"): {clip.close(); return true; }
    
    case ("C"): clip.close();
    break;
    default:System.out.println(" ");
   }
   
  }
 return false;
    } // end palySong method
        //***********************************************************************************************************
        
        
        
        
        
        
        
        
    static void clearScreen()
    {
        for (int i = 0; i < 40; i++) {
            System.out.println("");
        }
    }
    
    
    
    
    
    
    
   //**************************************************************************************************************
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
     
        Scanner scan = new Scanner(System.in);
        
        linkList mainList = new linkList();
        linkList myList = new linkList();
        
        FillOutMainList(mainList, myList);
        
        
        int choseHome=1;
        
        while (choseHome != 0)
        {
            System.out.println("*************************************************************");
            System.out.println("01) enter to the main lest");
            System.out.println("02) enter to your play lest");
            System.out.println("00) quit");
            System.out.println("*************************************************************");
                    choseHome = scan.nextInt();
                    
                    clearScreen();
                    
          switch(choseHome)
        {
            case 1: // main List
            {  
                
                int choseMainList=1;
                while (choseMainList != 0)
                {
                    clearScreen();
                    System.out.println("01) Show the list ");
                    System.out.println("02) Searsh in the list by Song or Singer");
                    System.out.println("00) back");
                    choseMainList = scan.nextInt();
                   clearScreen();
                 
                        switch (choseMainList)
                        {
                           
                            case 1 :
                            {
                                int i=1;
                                while (i != 0)
                                {
                              mainList.show();
                            System.out.println("Enter the song number ( 1 -> "+ mainList.getSize() +" )");
                            System.out.println("0 ) back" );
                              i = scan.nextInt();
                            clearScreen();
                
                           if (i==0)
                               break; 
                             else if (i>0 && i<=mainList.getSize())
                             {
                                  boolean skip = false;
                                 do
                                 {
                                     clearScreen();
                                     skip = playSong(mainList.getURIByID(i++));
                                 }while(skip);
                                 clearScreen();
                             }
                                
                                else System.out.println("Please enter a valid choice");
                                }
                                break;
                            } // end case 1 mainList
  //*****************************************************************************************************************                          
                            case 2:
                            {
                              
                                int choseSearch =1;
                                System.out.println("01) Search by Song");
                                System.out.println("02) Search by Singer");
                                System.out.println("00) back");
                                choseSearch = scan.nextInt();
                                switch (choseSearch)
                                {
                                    case 1:
                                    {
                                        String song;
                                        System.out.print("enter the name of Song : ");
                                        song = scan.next();
                                        linkList mySearch = new linkList();
                                        
                                        mySearch  = mainList.SearchBySong(song);

                                         int i=1;
                                                while (i != 0)
                                                {
                                            mySearch.show();
                                                
                                            System.out.println("Enter the song number( 1 -> "+ mySearch.getSize() +" )");
                                            System.out.println("0 ) back" );
                                              i = scan.nextInt();
                                            clearScreen();
                                
                                           if (i==0)
                                             break;
                                             else if (i>0 && i<=mySearch.getSize())
                                             {   boolean skip = false;
                                                        do
                                                          {
                                                           clearScreen();
                                                         skip = playSong(mySearch.getURIByID(i++));
                                                            }while(skip);
                                                              clearScreen();
                                             }
                                
                                                else System.out.println("Please enter a valid choice");
                                                  }
                                        break;
                                    } // end case 1 search
    //*****************************************************************************************  
                                    
                                    
                                    
                                    case 2:
                                    {
                                        String singer;
                                        System.out.print("enter the name of Singer : ");
                                        singer = scan.next();
                                        linkList mySearch = new linkList();
                                        
                                        mySearch  = mainList.SearchBySinger(singer);

                                         int i=1;
                                                while (i != 0)
                                                {
                                            mySearch.show();
                                                
                                            System.out.println("Enter the song number ( 1 -> "+ mySearch.getSize() +" )");
                                            System.out.println("0 ) back" );
                                              i = scan.nextInt();
                                            clearScreen();
                                
                                           if (i==0)
                                             break;
                                             else if (i>0 && i<=mySearch.getSize())
                                             {
                                                    boolean skip = false;
                                                      do
                                                      {
                                                      clearScreen();
                                                    skip = playSong(mySearch.getURIByID(i++));
                                                      }while(skip);
                                                       clearScreen();
                                             }
                                
                                                else System.out.println("Please enter a valid choice");
                                                  }
                                        break;
                                    } // end case 2 search
                                   
                                } // end switch search
                                break;
                            }
                            
                        } // end switch main List
                       
    
                }
                break;
                
            } // end case 1 home
   //*************************************************************************************************     
            
            
            
            case 2: // my List
            {
                 int choseMyList=1;
                while (choseMyList != 0)
                {
                   
                    clearScreen();
                    System.out.println("01) Show my list ");
                    System.out.println("02) Searsh in the list by Song or Singer");
                    System.out.println("03) insert to my list");
                    System.out.println("04) delete from my list");
                    System.out.println("00) back");
                    choseMyList = scan.nextInt();
                   clearScreen();
                   
            
                                       
                        switch (choseMyList)
                        {
                            
                            
                            
                            
                            
                            case 1 :
                            {
                                int i=1;
                                while (i != 0)
                                {
                              myList.show();
                            System.out.println("Enter the song number ( 1 -> "+ myList.getSize() +" )");
                            System.out.println("0 ) back" );
                              i = scan.nextInt();
                            clearScreen();
                
                           if (i==0)
                                 break; 
                             else if (i>0 && i<=myList.getSize())
                             {
                                  boolean skip = false;
                                 do
                                 {
                                     clearScreen();
                                     skip = playSong(myList.getURIByID(i++));
                                 }while(skip);
                                 clearScreen();
                             }
                                
                                else System.out.println("Please enter a valid choice");
                                }
                                break;
                            } // end case 1 mainList
                            
                            
                            
                            
                            
                            
                            
                            case 2:
                            {
                                
                                int choseSearch =1;
                                System.out.println("01) Search by Song");
                                System.out.println("02) Search by Singer");
                                System.out.println("00) back");
                                choseSearch = scan.nextInt();
                                switch (choseSearch)
                                {
                                    case 1:
                                    {
                                        String song;
                                        System.out.print("enter the name of Song : ");
                                        song = scan.next();
                                        linkList mySearch = new linkList();
                                        
                                        mySearch  = myList.SearchBySong(song);

                                         int i=1;
                                                while (i != 0)
                                                {
                                            mySearch.show();
                                                
                                            System.out.println("Enter the song number( 1 -> "+ mySearch.getSize() +" )");
                                            System.out.println("0 ) back" );
                                              i = scan.nextInt();
                                            clearScreen();
                                
                                           if (i==0)
                                           { break;}
                                             else if (i>0 && i<=mySearch.getSize())
                                             {   boolean skip = false;
                                                        do
                                                          {
                                                           clearScreen();
                                                         skip = playSong(mySearch.getURIByID(i++));
                                                            }while(skip);
                                                              clearScreen();
                                             }
                                
                                                else System.out.println("Please enter a valid choice");
                                                  }
                                        break;
                                    } // end case 1 search
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    
                                    case 2:
                                    {
                                       
                                        String singer;
                                        System.out.print("enter the name of Singer : ");
                                        singer = scan.next();
                                        linkList mySearch = new linkList();
                                        
                                        mySearch  = myList.SearchBySinger(singer);

                                         int i=1;
                                                while (i != 0)
                                                {
                                            mySearch.show();
                                                
                                            System.out.println("Enter the song number ( 1 -> "+ mySearch.getSize() +" )");
                                            System.out.println("0 ) back" );
                                              i = scan.nextInt();
                                            clearScreen();
                                
                                           if (i==0)
                                             break;
                                             else if (i>0 && i<=mySearch.getSize())
                                             {
                                                    boolean skip = false;
                                                      do
                                                      {
                                                      clearScreen();
                                                    skip = playSong(mySearch.getURIByID(i++));
                                                      }while(skip);
                                                       clearScreen();
                                             }
                                
                                                else System.out.println("Please enter a valid choice");
                                                  }
                                        break;
                                    } // end case 2 search
                                    
                                } // end switch search
                                break;
                            }
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            case 3: // insert to myList
                            {
                                int i=1;
                                                while (i != 0)
                                                {
                                                    clearScreen();
                                                    System.out.println("       The Main List    ");
                                                 mainList.show();
                                                    System.out.println("           My List      ");
                                                 myList.show();
                                                 
                                System.out.println("Choose the song number to insert it to your List : ");
                                                    System.out.println("00 ) Back");
                                                    i = scan.nextInt();
                                                    
                                                    if (i == 0) break;
                                                     else if (i>0 && i<=mainList.getSize())
                                                     {
                                                         myList.insertLast(myList.getSize()+1, mainList.getSongByID(i),mainList.getSingerById(i) );
                                                         System.out.println("  done  ");
                                                     }
                                                     else System.out.println("Please enter a valid choice");
                                                }
                             break;
                            }
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
   
                            case 4:
                            {
                                int i=1;
                                while(i!=0)
                                {
                                    clearScreen();
                                    System.out.println("        My List        ");
                                    myList.show();
                                    System.out.println("Choose the song number to delete it from your List : ");
                                System.out.println("00 ) Back ");
                                i = scan.nextInt();
                                 if (i == 0) break;
                                 else if (i>0 && i<=myList.getSize())
                                 {
                                     myList.removeByID(i);
                                     System.out.println("  done  ");
                                 }
                                 else System.out.println("Please enter a valid choice");
                                     
                                
                                
                                }
                                
                                
                                
                                break;
                            }
                            
                        } // end switch my List
                   
                }
                break;
            }
            
        }
                   
        }
       
        
         
    }
    }
