import java.util.Objects;

// Class Position records the (row,column) grid coordinates on a Boggle board

public class Position implements Comparable<Position> {
    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    @Override
    public String toString() {
        return "(" + column + "," + row + ")";
    }
    
    @Override
    public int compareTo(Position that) {
        int result = this.row - that.row;
        if(result == 0) result = this.column - that.column;
        return result;
    }
    
    @Override 
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return this.compareTo(that) == 0;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }

    public final int row;
    public final int column;
}

/*
@startuml
skinparam classAttributeIconSize 0
hide circle

interface Comparable<T> {
  + compareTo(o : T)
}
class Position extends Comparable {
  + row : int <<final>>
  + column : int <<final>>
  + Position(row : int, column : int)
  + toString() : String <<override>>
  + compareTo(that : Position) <<override>>
  + equals(o : Object) boolean <<override>>
  + hashCode() : int <<override>>
}

@enduml
*/
