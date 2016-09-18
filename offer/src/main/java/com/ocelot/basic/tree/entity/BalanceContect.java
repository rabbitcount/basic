package com.ocelot.basic.tree.entity;

public class BalanceContect {

    private int leftHeight = 0;
    private int rightHeight = 0;
    private boolean isBalanced = false;

    public BalanceContect(boolean isBalanced) {
        this.isBalanced = isBalanced;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    public boolean isBalanced() {
        return isBalanced;
    }

    public void setBalanced(boolean balanced) {
        isBalanced = balanced;
    }
}
