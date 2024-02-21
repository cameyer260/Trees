package trees; 

public class redTeam {
    
    public static void main(String[] arg) {
        Tree myTreeNumbers = new Tree(); 
        Tree myTreeStrings = new Tree(); 
        Tree myTreeBoth    = new Tree(); 


        // first test with number tree
        // add all numbers to tree
        myTreeNumbers.add(5); 
        myTreeNumbers.add(25); 
        myTreeNumbers.add(50); 
        myTreeNumbers.add(3); 
        myTreeNumbers.add(1); 
        myTreeNumbers.add(4); 
        myTreeNumbers.add(24); 

        System.out.println("preOrder numbers:      "+myTreeNumbers.toStringPreOrder()+"\n"+
            "in Order numbers:      "+myTreeNumbers.toStringInOrder()); 
        

        // remove a number node 
        myTreeNumbers.remove("3"); 
        System.out.println("\nremove number: 4       "+myTreeNumbers.toStringInOrder());

        System.out.println("\n");

        // second test the tree with strings 
        myTreeStrings.add("Meinzeit");
        myTreeStrings.add("EHS"); 
        myTreeStrings.add("apcsa"); 
        myTreeStrings.add("java"); 
        myTreeStrings.add("python");
        myTreeStrings.add("rust"); 
        myTreeStrings.add("c"); 
        myTreeStrings.add("html"); 
        myTreeStrings.add("cpp");

        System.out.println("preOrder Strings:      "+myTreeStrings.toStringPreOrder()+"\n"+
            "in Order numbers:      "+myTreeStrings.toStringInOrder()); 
        

        // remove a string 
        myTreeStrings.remove("cpp"); 
        System.out.println("\nremove String: cpp     "+myTreeStrings.toStringInOrder());


        // add to the both this includes a number, string type, 
        // may include doubles, floats, long, Chars, etc... 
        char b = 5; 
        myTreeBoth.add(10); 
        myTreeBoth.add("EHS"); 
        myTreeBoth.add(5); 
        // myTreeBoth.add(b); 
        myTreeBoth.add(60); 
        myTreeBoth.add("hello"); 
        myTreeBoth.add(3.2); 
        myTreeBoth.add(5.3f); 

        System.out.println("\npreOrder both: "+myTreeBoth.toStringInOrder() +
            "\nin Order both: "+myTreeBoth.toStringPreOrder()); 


        // testing --- delete before you test red team 
        // double x = 5.5; 
        // double g = 5; 
        // char c= (char) x; 
        // char y = (char) g; 
        // System.out.println((int) c);
        // System.out.println(c); 
        // System.out.println(y); 

        // System.out.println(myTreeBoth.searchParentNode(5).getValue()); 

    }
}
