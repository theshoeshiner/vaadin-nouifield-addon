package org.vaadin.addons.thshsh.nouifield;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("serial")
public class NoUiCollectionField<T> extends NoUiField<Collection<T>> {
	
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(NoUiCollectionField.class);


	public NoUiCollectionField() {
		super(new ArrayList<>());
	}

	public NoUiCollectionField(Collection<T> value) {
		super(value);
	}

	@Override
	protected boolean valueEquals(Collection<T> value1, Collection<T> value2) {
		return CollectionUtils.isEqualCollection(value1, value2);
	}

	@Override
	public void setValue(Collection<T> value) {
		super.setValue(copy(value));
	}
	
	public void removeValue(T value) {
		Collection<T> coll = getValue();
		coll.remove(value);
		setValue(coll);
	}
	
	public void addValue(T value) {
		Collection<T> coll = getValue();
		coll.add(value);
		setValue(coll);
	}

	@Override
	public Collection<T> getValue() {
		return copy(super.getValue());
	}

	protected Collection<T> copy(Collection<T> collection){
		return new ArrayList<>(collection);
	}
	
}
