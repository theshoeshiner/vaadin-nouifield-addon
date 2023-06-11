package org.vaadin.addons.thshsh.hovercolumn;

import java.util.ArrayList;
import java.util.Collection;

import org.vaadin.addons.thshsh.nouifield.NoUiField;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

/**
 * TODO
 *  
 */
@Route("")
public class AddonView extends Div {
	
	String[] names = {"People","Places","Things"};
	

    public AddonView() {

        Collection<Section> sections = new ArrayList<>();
        for(int i=0;i<names.length;i++) {
            sections.add(new Section(names[i],i));
        }
        
        VerticalLayout layout = new VerticalLayout();
        add(layout);
        
        for(Section section : sections) {
            
            HorizontalLayout sectionLayout = new HorizontalLayout();
            layout.add(sectionLayout);
            
            Binder<Section> binder = new Binder<>();
            
            Button up = new Button(VaadinIcon.ARROW_UP.create());
            sectionLayout.add(up);
            
            Button down = new Button(VaadinIcon.ARROW_DOWN.create());
            sectionLayout.add(down);

            TextField nameField = new TextField("Name");
            sectionLayout.add(nameField);            
            binder.bind(nameField, Section::getName, Section::setName);
            
            NoUiField<Integer> orderField = new NoUiField<Integer>();
            binder.forField(orderField).bind(Section::getOrder, Section::setOrder);
            
            up.addClickListener(click -> {
                int index = layout.indexOf(sectionLayout);
                if(index > 0) {
                    Component swap = layout.getComponentAt(index-1);
                    layout.remove(sectionLayout);
                    layout.addComponentAtIndex(index, sectionLayout);
                }
            });
            
            Button save = new Button("Save");
            save.setDisableOnClick(true);
            
            
            
            binder.readBean(section);
        }
        
        
        //TextField nameField = new TextField("Name");
        //add(nameField);
        
        
        
    }
    
    public static class Section {
    	String name;
    	Integer order;
		public Section(String name, Integer order) {
			super();
			this.name = name;
			this.order = order;
		}
		public String getName() {
			return name;
		}
		public void setName(String firstName) {
			this.name = firstName;
		}
        public Integer getOrder() {
            return order;
        }
        public void setOrder(Integer order) {
            this.order = order;
        }
		
		
    	
		
    }
}
