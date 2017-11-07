/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobjects;

/**
 *
 * @author Magd
 */
@FunctionalInterface
public interface Delegator {
    public Object execute(Object... args);
}
