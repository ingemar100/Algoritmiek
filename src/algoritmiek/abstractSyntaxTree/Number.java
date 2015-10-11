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
public class Number extends Expression {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        return number;
    }

    @Override
    public String print() {
        return number + "";
    }
}
