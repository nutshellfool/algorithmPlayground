package test.me.lirui.algo.tree; 

import me.lirui.algo.tree.BinarySearchTree;
import me.lirui.algo.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* BinarySearchTree Tester. 
* 
* @author <Authors name> 
* @since <pre>三月 21, 2017</pre> 
* @version 1.0 
*/ 
public class BinarySearchTreeTest {
    private BinarySearchTree mTree;

@Before
public void before() throws Exception {
    if (mTree == null){
        mTree = new BinarySearchTree();

        // do some basic construct job
        for (int i = 1; i < 5; i++) {
            mTree.addTreeNode(i);
        }
    }
} 

@After
public void after() throws Exception {
    mTree = null;
} 

/** 
* 
* Method: addTreeNode(int value) 
* 
*/ 
@Test
public void testAddNotExistedTreeNode() throws Exception {
    TreeNode theAddedNode = mTree.addTreeNode(6);
    Assert.assertNotNull(theAddedNode);
}

/**
 *
 * Method: addTreeNode(int value)
 *
 */
@Test
public void testAddExistedTreeNode() throws Exception {
    TreeNode theAddedNode = mTree.addTreeNode(3);
    Assert.assertNotNull(theAddedNode);
}

/**
* 
* Method: searchNode(int value) 
* 
*/ 
@Test
public void testSearchExistedNode() throws Exception {
    mTree.addTreeNode(3);
    TreeNode foundedTreeNode = mTree.searchNode(3);
    Assert.assertNotNull(foundedTreeNode);
}

/**
 *
 * Method: searchNode(int value)
 *
 */
@Test
public void testSearchNotExistedNode() throws Exception {
    TreeNode foundedTreeNode = mTree.searchNode(7);
    Assert.assertNull(foundedTreeNode);
}

/** 
* 
* Method: deleteNode(int value) 
* 
*/ 
@Test
public void testDeleteMinNode() throws Exception {
    TreeNode deletedNode = mTree.deleteNode(1);
    Assert.assertNotNull(deletedNode);
    Assert.assertEquals(deletedNode.getData(), 4);
}

/** 
* 
* Method: findMin(TreeNode node) 
* 
*/ 
@Test
public void testFindMin() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = BinarySearchTree.getClass().getMethod("findMin", TreeNode.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
