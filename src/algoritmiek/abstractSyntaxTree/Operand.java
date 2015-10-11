/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek.abstractSyntaxTree;

/**
 *
 * @author Ingemar
 */
public class Operand extends Expression {
    private Expression left;
    private Expression right;
    private char operand;

    public Operand(char operand, Expression left, Expression right) {
        this.left = left;
        this.right = right;
        this.operand = operand;
    }

    @Override
    public int evaluate() {
        switch(operand){
            case '+':
                return left.evaluate() + right.evaluate();
            case '-':
                return left.evaluate() - right.evaluate();
            case '*':
                return left.evaluate() * right.evaluate();
            case '/':
                return left.evaluate() / right.evaluate();
            default:
                return 0;
        }
    }

    @Override
    public String print() {
        return "(" + left.print() + " " + operand + " " + right.print() + ")";
    }
}
