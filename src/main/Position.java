
public class Position {

    private int xPosition;
    private int yPosition;

    public Position(int xPosition, int yPosition) {
        super();
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        if(obj==this) return true;
        if(obj instanceof Position){
            if(xPosition==((Position)obj).xPosition && yPosition==((Position)obj).yPosition) return true;
        }
        return super.equals(obj);
    }

}
