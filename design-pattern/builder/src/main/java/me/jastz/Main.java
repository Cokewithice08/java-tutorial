package me.jastz;

import me.jastz.product.ConcreteProductBuilder;
import me.jastz.product.Director;

/**
 * @author zhiwen
 */
public class Main {

    public static void main(String[] args) {
        ConcreteProductBuilder concreteProductBuilder = new ConcreteProductBuilder();
        Director director = new Director(concreteProductBuilder);
        System.out.println(director.construct());
    }
    
}
