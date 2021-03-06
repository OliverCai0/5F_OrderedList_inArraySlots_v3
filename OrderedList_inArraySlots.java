import java.util.ArrayList;

/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        //return binarySearch(0, list_iAS.size(), (list_iAS.size()) / 2, findMe);
        return binarySearch(findMe);
    }

    public int binarySearch(int findMe){
        int upperBound = list_iAS.size();
        int lowerBound = 0;
        int average = (upperBound + lowerBound) / 2;
        while(list_iAS.get(average).compareTo(findMe) != 0){
            if(Math.abs(upperBound - lowerBound) == 1) return -1;
            if(list_iAS.get(average).compareTo(findMe) < 0){
                lowerBound = average;
                average = (average + upperBound) / 2;
            }
            else{
                upperBound = average;
                average = (average + lowerBound) / 2;
            }
        }
        return average;
    }

    /**
     * recursive style
     */
    public int binarySearch(int lowerBound, int upperBound, int average, int findMe){
        if(list_iAS.get(average).compareTo(findMe) == 0) return average;
        if(Math.abs(upperBound - lowerBound) == 1) return -1;
        if(list_iAS.get(average).compareTo(findMe) < 0){
            return binarySearch(average, 
             upperBound, 
             (average + upperBound) / 2,
             findMe);
    }
    else{
    return binarySearch(lowerBound, 
             average, 
             (average + lowerBound) / 2,
             findMe); 
    }
}
    

    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
