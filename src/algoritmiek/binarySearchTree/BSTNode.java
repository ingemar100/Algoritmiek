package algoritmiek.binarySearchTree;

public class BSTNode {

    private int number;

    private BSTNode left;
    private BSTNode right;

    public BSTNode(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    /**
     * Add a number in the subtree of this node
     */
    public void insert(int number) {
        if (number < this.number) {
            // Smaller value, insert it into the left subtree
            if (this.left == null) {
                this.left = new BSTNode(number);
            } else {
                this.left.insert(number);
            }
        } else {
            // Larger value, insert it in the right subtree
            if (this.right == null) {
                this.right = new BSTNode(number);
            } else {
                this.right.insert(number);
            }
        }
    }

    public void prettyPrint(String firstPrefix, String prefix) {
        System.out.println(firstPrefix + number);

        if (right == null) {
            System.out.println(prefix + "├── .");
        } else {
            right.prettyPrint(prefix + "├── ", prefix + "|   ");
        }

        if (left == null) {
            System.out.println(prefix + "└── .");
        } else {
            left.prettyPrint(prefix + "└── ", prefix + "    ");
        }
    }

    public boolean exists(int number) {
        if (this.number == number) {
            return true;
        } else if (number > this.number) {
            if (right != null) {
                return right.exists(number);
            }
        } else if (number < this.number) {
            if (left != null) {
                return left.exists(number);
            }
        }
        return false;
    }

    public int min() {
        if (left != null) {
            return left.min();
        } else {
            return this.number;
        }
    }

    public int max() {
        if (right != null) {
            return right.max();
        } else {
            return this.number;
        }
    }

    public int depth() {
        int l = 0, r = 0;
        if (left != null) {
            l = left.depth();
        }
        if (right != null) {
            r = right.depth();
        }
        return Math.max(l, r) + 1;
    }

    public int count() {
        int l = 0, r = 0;
        if (left != null) {
            l = left.count();
        }
        if (right != null) {
            r = right.count();
        }

        return l + r + 1;
    }

    public void print() {
        if (left != null) {
            left.print();
        }
        System.out.println(number);
        if (right != null) {
            right.print();
        }
    }

    public void printInRange(int min, int max) {
        if (left != null && number > min) {
            left.printInRange(min, max);
        }
        if (number > min && number < max) {
            System.out.println(number);
        }
        if (right != null && number < max) {
            right.printInRange(min, max);
        }
    }

    public void delete(int number, BSTNode parent) {

        if (parent == null && number == this.number) {
            BSTNode auxRoot = new BSTNode(0);
            auxRoot.insert(number);
            this.delete(number, auxRoot);
        } else {
            if (number < this.number) {
                if (left != null) {
                    left.delete(number, this);
                }
            } else if (number > this.number) {
                if (right != null) {
                    right.delete(number, this);
                }
            } else if (number == this.number) {
                if (left == null && right == null) {
                    if (this == parent.left) {
                        parent.left = null;
                    } else if (parent.right == this) {
                        parent.right = null;
                    }
                } else if (left != null && right == null || left == null && right != null) {
                    if (this == parent.left) {
                        parent.left = (left == null) ? right : left;
                    } else if (parent.right == this) {
                        parent.right = (left == null) ? right : left;;
                    }
                } else {
                    this.number = left.max();
                    left.delete(this.number, this);
                }
            }
        }
    }

    public BSTNode rotateLeft() {
        if (right == null) {
            return this;
        }

        BSTNode temp = right;
        right = temp.left;
        temp.left = this;

        return temp;
    }

    public BSTNode rotateRight() {
        if (left == null) {
            return this;
        }

        BSTNode temp = left;
        left = temp.right;
        temp.right = this;

        return temp;
    }

    public boolean isAVLGebalanceerd() {
        boolean balans = false;
        if ((left == null || left.isAVLGebalanceerd()) && (right == null || right.isAVLGebalanceerd())) {
            int l = (left == null) ? 0 : left.depth();
            int r = (right == null) ? 0 : right.depth();
            int verschil = l - r;
            if (verschil >= -1 && verschil <= 1) {
                balans = true;
            }
        }
        return balans;
    }

    public BSTNode insertAVL(int number) {
        if (number < this.number) {
            // Smaller value, insert it into the left subtree
            if (this.left == null) {
                this.left = new BSTNode(number);
            } else {
                this.left = left.insertAVL(number);
            }
        } else {
            // Larger value, insert it in the right subtree
            if (this.right == null) {
                this.right = new BSTNode(number);
            } else {
                this.right = right.insertAVL(number);
            }
        }

        if (!isAVLGebalanceerd()) {
            int leftLeftDepth = 0, leftRightDepth = 0, rightLeftDepth = 0, rightRightDepth = 0;
            int leftDepth = (left == null) ? 0 : left.depth();
            int rightDepth = (right == null) ? 0 : right.depth();

            if (leftDepth > rightDepth) {
                leftLeftDepth = (left.left == null) ? 0 : left.left.depth();
                leftRightDepth = (left.right == null) ? 0 : left.right.depth();

                if (leftLeftDepth < leftRightDepth) {
                    left = left.rotateLeft();
                }
                return this.rotateRight();
            } else {
                rightLeftDepth = (right.left == null) ? 0 : right.left.depth();
                rightRightDepth = (right.right == null) ? 0 : right.right.depth();

                if (rightRightDepth < rightLeftDepth) {
                    right = right.rotateRight();
                }
                return this.rotateLeft();
            }
        }
        return this;
    }
}
