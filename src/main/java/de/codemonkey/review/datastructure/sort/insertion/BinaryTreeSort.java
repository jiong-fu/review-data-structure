package de.codemonkey.review.datastructure.sort.insertion;

import de.codemonkey.review.datastructure.sort.Sort;

import static de.codemonkey.review.datastructure.sort.ArithmeticUtils.isSmallerThan;

public class BinaryTreeSort<N extends Number> implements Sort<N> {

    @Override
    public N[] sort(N[] array) {
        TreeNode root = generateBinaryTree(array);
        return traverseBinaryTree(root);
    }

    /**
     * Generate binary tree by iterating the array
     *
     * @param array the array to be iterated
     * @return the resulting binary tree as root tree node
     */
    private TreeNode generateBinaryTree(N[] array) {
        TreeNode root = null;
        for (int i = 0; i < array.length; i++) {
            root = insertIntoBinaryTree(array[i], root);
        }
        return root;
    }

    /**
     * Insert element into the binary tree
     *
     * @param element the element to be inserted
     * @param root    the current root of the binary tree
     * @return the resulting binary tree as root tree node
     */
    private TreeNode insertIntoBinaryTree(N element, TreeNode root) {
        if (root == null) {
            return new TreeNode(element);
        }

        if (isSmallerThan(element, root.data)) {
            if (root.leftChild == null) {
                root.createLeftChild(element);
            } else {
                insertIntoBinaryTree(element, root.leftChild);
            }
        } else {
            if (root.rightChild == null) {
                root.createRightChild(element);
            } else {
                insertIntoBinaryTree(element, root.rightChild);
            }
        }

        return root;
    }

    /**
     * In-order traverse the binary tree
     *
     * @param root the current root of the binary tree
     * @return the in-order traversed tree nodes as array
     */
    private N[] traverseBinaryTree(TreeNode root) {
        N[] leftChildArray = null, rightChildArray = null;
        int leftChildLength = 0, rightChildLength = 0;
        if (root.leftChild != null) {
            leftChildArray = traverseBinaryTree(root.leftChild);
            leftChildLength = leftChildArray.length;
        }
        if (root.rightChild != null) {
            rightChildArray = traverseBinaryTree(root.rightChild);
            rightChildLength = rightChildArray.length;
        }

        Number[] result = new Number[leftChildLength + 1 + rightChildLength];
        int currentIndex = 0;
        for (int i = 0; i < leftChildLength; i++, currentIndex++) {
            result[currentIndex] = leftChildArray[i];
        }
        result[currentIndex++] = root.data;
        for (int i = 0; i < rightChildLength; i++, currentIndex++) {
            result[currentIndex] = rightChildArray[i];
        }

        return (N[]) result;
    }

    /**
     * Tree node of an unbalanced binary tree
     */
    private class TreeNode {

        private TreeNode leftChild;
        private N data;
        private TreeNode rightChild;

        TreeNode(N data) {
            this.data = data;
        }

        void createLeftChild(N data) {
            this.leftChild = new TreeNode(data);
        }

        void createRightChild(N data) {
            this.rightChild = new TreeNode(data);
        }
    }

}
