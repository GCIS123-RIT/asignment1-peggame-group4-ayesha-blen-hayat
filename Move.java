public class Move  {
   
    private Location from;
    private Location to;
    
    
    public Move(Location from,Location to){
        this.from = from;
        this.to = to;
    }

    //Retrieves peg's original point .
    public Location getFrom() {
        return from;
    }
    //Retrieves peg's new selected point. 
    public Location getTo() {
        return to;
    }
    

    
}

    

