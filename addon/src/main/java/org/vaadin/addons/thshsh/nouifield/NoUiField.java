package org.vaadin.addons.thshsh.nouifield;

import com.vaadin.flow.component.customfield.CustomField;

/**
 * Field that renders nothing to the UI and is just used to ensure that binders write certain values in the backend

 * @param <T>
 */
@SuppressWarnings("serial")
public class NoUiField<T> extends CustomField<T> {

	protected T value;
	
	public NoUiField() {}
	
	public NoUiField(T value) {
		super(value);
		
	}
	
	@Override
	protected T generateModelValue() {
		return value;
	}

	@Override
	protected void setPresentationValue(T newPresentationValue) {
		this.value = newPresentationValue;
	}

	

}
