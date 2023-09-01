/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;

class Link {
   public String song;
   public String singer;
   public int ID;
   
   public Link next;
   
     public Link(int id, String Song, String Singer) {
          this.ID = id; 
         this.song = Song;
           this.singer = Singer;
            this.next = null;
     }

//    public String toString() {
//return data.toString();
//}
}


public class linkList {
    
    private Link head;
             
    public linkList() {
  head = null;
  
  }
    
 public void insertFirst(int id, String Song, String Singer) {

     Link newLink = new Link(id ,Song, Singer);
   newLink.next = head;
   head = newLink;
   
}
 public String removeFirst() {
    String res = head.song;
  head = head.next;
   return res;
   
}
 
  public int getFirstID() {
return head.ID;
}
  
 public String getFirstSong() {
return head.song;
}
  public String getFirstSinger() {
return head.singer;
}
  
public void insertLast(int id, String Song, String Singer) {
Link newLink = new Link(id, Song, Singer);
if (head == null) {
head = newLink;
return;
}
Link current = head;
while (current.next != null)
current = current.next;
current.next = newLink;
}
public String removeLast() {
if (head.next == null) {
String res = head.song;
head = null;
return res;
}
Link current = head;
while (current.next.next != null)
current = current.next;
String res = current.next.song;
current.next = null;
return res;
}

public void editID ()
{
    int i=0;
    
    Link current = head;
    while (current!= null)
    {
        current.ID = ++i;
        current = current.next;
    }
}

public void removeByID (int id)
{
  id--; // zero base
        // If linked list is empty
        if (head == null)
        {
            return;
        }
 
        // Store head node
        Link temp = head;
 
        // If head needs to be removed
        if (id == 0) {
            
            // Change head
            head = temp.next;
            editID ();
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < id - 1; i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Link next = temp.next.next;
 
        // Unlink the deleted node from list
        temp.next = next;
        editID ();
    
}

public int getLastID() {
Link current = head;
while (current.next != null)
current = current.next;
return current.ID;
}
public String getSongByID(int id) {
Link current = head;
String Song = "";
while (current != null)
{
    if (current.ID == id)
        Song = current.song;
current = current.next;
}
return Song;
}
public String getSingerById(int id) {
Link current = head;
String Singer = "";
while (current != null)
{
    if (current.ID == id)
        Singer = current.singer;
current = current.next;
}
return Singer;
}
public boolean isEmpty() {
return head == null;
}
public void show()
{
    System.out.println("*************************************************************");
    if (head == null)
        System.out.println("the List is Empty!");
    else
    {
    System.out.println( head.ID + " ) " + head.song + "  " + head.singer );
		Link current = head.next;
		while (current != null) {
	 System.out.println( current.ID + " ) " + current.song + "  " + current.singer );
			current = current.next;     
		}
    }
    System.out.println("*************************************************************");
}
public String getURIByID (int id)
{
    String URI="";
    Link current = head;
     while(current != null){
            if (current.ID == id)
            {
                URI = current.song +"-"+ current.singer +".wav";
                return URI;
            }
            current = current.next;
}
     return "001.wav";
}
public linkList SearchBySong (String Song)
{
    linkList temp = new linkList();
     Link current = head;
     int i=0;
     boolean find = false;   
     while(current != null){
            if (current.song.toString().equals(Song) )
            {
                 find = true;
                temp.insertLast(++i, current.song, current.singer);
            }
            current = current.next;
}
          if (!find)
         temp.insertLast(00, "not", "find");
     return temp;
}

public linkList SearchBySinger (String Singer)
{
       linkList temp = new linkList();
     Link current = head;
     int i=0;
     boolean find = false;
     while(current != null){
            if (current.singer.toString().equals(Singer) )
            {
                find = true;
                temp.insertLast(++i, current.song, current.singer);
            }
            current = current.next;
}
     if (!find)
         temp.insertLast(00, "not", "find");
     return temp; 
}
public int getSize ()
{
    int size=0;
    Link current = head;
    while(current != null)
    {
        size++;
       current = current.next;
    }
    return size;
}
    
}

