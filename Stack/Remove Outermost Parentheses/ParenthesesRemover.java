public class ParenthesesRemover
{
    public String removeOuterParentheses(String s)
    {
        StringBuilder result = new StringBuilder();
        
//     The StringBuilder class in Java is used to create mutable (modifiable) sequences of characters. 
//Unlike strings in Java, which are immutable (cannot be modified after they're created), StringBuilder allows you to add, remove, 
//or change characters in-place without creating new objects.

// In the context of the removeOuterParentheses method, StringBuilder is used to build the final output string as follows:

// Initialization:



// StringBuilder result = new StringBuilder();
// This line creates a new instance of StringBuilder. Initially, it is empty, meaning it contains no characters.

// Appending Characters:
// Throughout the method, characters are appended to the result StringBuilder as the input string is processed. For instance:



// result.append(c);
// Here, c is a character from the input string. If c meets certain conditions (e.g., it's not an outer parenthesis 
//of a primitive string),
// it's appended to result. This process is efficient because StringBuilder can expand its capacity as 
//needed without creating new string objects each time a character is added.

// Efficiency:
// Using StringBuilder is more efficient than using string concatenation in a loop. 
//In Java, string concatenation (like str += char) inside a loop creates a new string object in each iteration,
// which can be inefficient, especially for long strings or large numbers of concatenations. 
//StringBuilder avoids this by maintaining an internal buffer to hold the characters.

// Converting to String:
// After all the necessary characters have been appended, the StringBuilder object is converted back to a regular String 
//for the final output. This is done using the toString() method:

// java
// Copy code
// return result.toString();
// This line returns a new String object that contains all the characters that were appended to StringBuilder.

// In summary, StringBuilder in this context is a tool for efficiently constructing the final string by allowing modifications 
//and append operations without the overhead of creating multiple string objects.
        int depth = 0;

        for(char c : s.toCharArray())
        {


            if(c == '(')
            {
                //ONly add '(' if we are not at the outermost layer 
            

                if(depth > 0 )
                {
                    result.append(c);
                }
                depth ++;
            
            }
            else if (c == ')'){

                depth--;
           
           
         // Only add ')' if we are not at the outermost layer
        if (depth > 0 )
        {
            result.append(c);
        }    
        
        }
        }
        return result.toString();

    }

    public static void main(String[] args )
    {
        ParenthesesRemover remover = new ParenthesesRemover();
       System.out.println(remover.removeOuterParentheses("(()())(())"));           // Output: "()()()"

       //first step 
       //we find the "("
    // s stays the same and we increment the depth++
       
        System.out.println(remover.removeOuterParentheses("(()())(())(()(()))"));  // Output: "()()()()(())"
        System.out.println(remover.removeOuterParentheses("()()"));               // Output: ""
    
    }
}