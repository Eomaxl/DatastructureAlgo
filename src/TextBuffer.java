import java.util.*;


/*
**Simplified Text Editor Buffer with Undo/Redo**
*
**Context**
You are tasked with building the core functionality of a simplified text editor that supports
4 operations:
- insert a character at a position
- delete a character at a position
- undo
- redo

**Deliverables**
- Implement the TextBuffer class.
- Implement a suite of unit tests that thoroughly test TextBuffer.

**Evaluation Criteria**
- Correctness: Does your code correctly implement all the required operations, including undo/redo?
- Clarity and Readability: Is your code well-structured, add easy to understand?
- Efficiency: Have you chosen appropriate data structures for the task?
- Testing: Are your tests comprehensive?
- Error Handling: Does your code handle invalid inputs (e.g. out-of-bounds positions) gracefully?
*/
public class TextBuffer {
    /*
     * Inserts the character c at the specified 0-indexed position in the text buffer.
     * Example: If the buffer contains "abc" and you call insert('x', 1), the buffer should become "axbc".
     * If position is out of bounds (less than 0 or greater than the current text length), throw exception.
     */
    Stack<String> trackOperations = new Stack<>();   // "insert|s", "insert|o"
    Stack<String> trackRedoOperations = new Stack<>();
    StringBuilder sb = new StringBuilder();
    boolean undoFlag = false;

    void insert(char c, int position) throws IllegalArgumentException {
        // TODO: implement logic
        if(position <0 || position > sb.length()){
            throw new IllegalArgumentException();
        }
        sb = sb.insert(position,c);
        String op = "insert|"+c+"|"+position;
        trackOperations.push(op);
    }
    /*
     * Deletes the character at the specified 0-indexed position.
     * Example: If the buffer contains "axbc" and you call delete(1), the buffer should become "abc".
     * If position is out of bounds, throw exception.
     */
    void delete(int position) throws IllegalArgumentException {
        // TODO: implement logic
        if(position <0 || position > sb.length()){
            throw new IllegalArgumentException();
        }
        char ch = sb.charAt(position);
        sb = sb.deleteCharAt(position);
        String op = "delete|"+ch+"|"+position;
        trackOperations.push(op);
    }
    /*
     * Returns the current content of the text buffer as a string.
     */
    String getText() {
        // TODO: implement logic

        return sb.toString();
    }
    /*
     * Reverts the last insert or delete operation.
     * If there are no operations to undo, this method should do nothing (no exception should be thrown).
     * Consecutive calls to undo() should undo operations in reverse order of their execution.
     */
    void undo() {
        // TODO: implement logic
        String op = trackOperations.pop();
    }
    /*
     * Re-applies the last undone operation (i.e., the operation that was most recently undone by undo()).
     * If there are no operations to redo, this method should do nothing.
     * Consecutive calls to redo() should redo operations in the order they were undone.
     * If a new insert or delete is performed after an undo(), the redo history should be cleared.
     *
     * asdbca
     * adf
     * safw
     */
    void redo() {
        //TODO: implement logic
    }
    public static void main(String[] args) {
        TextBuffer buffer = new TextBuffer();
        buffer.insert('a', 0);
        buffer.insert('b', 1);
        buffer.insert('c', 2);
        buffer.insert('x', 1);
        System.out.println(buffer.getText());
        buffer.delete( 1);
        System.out.println(buffer.getText());
        buffer.insert('n',-1);
        //System.out.println("Hello world!");
    }
}
