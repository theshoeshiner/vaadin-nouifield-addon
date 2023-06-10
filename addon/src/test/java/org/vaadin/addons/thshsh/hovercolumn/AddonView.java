package org.vaadin.addons.thshsh.hovercolumn;

import java.util.Random;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class AddonView extends Div {
	
	String[] names = {"Rob","Ashley","Victoria","Nate","Rosie","Axl","Caleb","Lucas","Trey","Dana","Beth"};
	Random random = new Random(System.currentTimeMillis());

    public AddonView() {

    }
    
    public static class Person {
    	String name;
    	Integer age;
		public Person(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String firstName) {
			this.name = firstName;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		
    	
		
    }
}
