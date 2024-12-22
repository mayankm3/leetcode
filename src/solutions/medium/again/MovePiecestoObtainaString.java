package solutions.medium.again;

public class MovePiecestoObtainaString {

    public static void main(String[] args) {
        boolean result = canChange("__L__L____R___R__", "LL_____________RR");
        System.out.println(result);
    }

    // https://leetcode.com/problems/move-pieces-to-obtain-a-string check editorial
    // https://www.youtube.com/watch?v=jsQciMXyz_A some logic was taken from here
    // TC: O(n)
    // Asked to me in Freecharge
    public static boolean canChange(String start, String target) {
        int n = start.length();
        char[] startCharArray = start.toCharArray();
        char[] targetCharArray = target.toCharArray();
        int source = 0, destination = 0;

        while (source < n || destination < n){

            while (source < n && startCharArray[source] == '_'){
                source++;
            }

            while (destination < n && targetCharArray[destination] == '_'){
                destination++;
            }

            if (source == n && destination == n) return true;
            if (source == n || destination == n) return false;

            char startCharAtSource = startCharArray[source];
            if (startCharAtSource != targetCharArray[destination]
                    || (startCharAtSource == 'L' && source < destination)
                    || startCharAtSource == 'R' && destination < source){
                return false;
            }

            source++;
            destination++;
        }

        return true;
    }


    // __L__L____R___R__
    // 0123456789
    // L____L____R___R__
    // LL________R_____R    -> START FROM END
    // LL_____________RR
}
