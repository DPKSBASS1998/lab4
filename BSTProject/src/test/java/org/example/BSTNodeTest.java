package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {

    @Test
    void testBSTNode() {

        // Тесткейс1
        ArrayList<Integer> keys = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            keys.add(i + 3);
        }
        Collections.shuffle(keys);

        // Тесткейс2
        BSTNode bst = new BSTNode();
        for (int key : keys) {
            bst.insert(key - 3, "Value" + key);
        }
        assertEquals(20, keys.size());

        // Тесткейс3
        assertEquals("Value8", bst.search(5));
        System.out.println("\nkey5: "+bst.search(5));
        assertNull(bst.search(25));
        System.out.println("\nkey25: "+bst.search(25)+"\n");

        // Тесткейс4
        bst.delete(10);
        bst.inorderTraversal();
        assertNull(bst.search(10));
        System.out.println("\nkey10: "+bst.search(10));
        bst.insert(10, "NewValue");
        bst.inorderTraversal();
        assertNotNull(bst.search(10));
        System.out.println("\nkey10: "+bst.search(10));
        bst.insert(5, "UpdatedValue");
        bst.inorderTraversal();
        assertNotNull(bst.search(5));
        System.out.println("\nkey5: "+ bst.search(5));

        //Тесткейс5
        bst.delete(16);
        bst.inorderTraversal();
        assertNull(bst.search(16));
        System.out.println("\n key16: "+bst.search(16));

    }
}