package com.wemanity.kata.core;

import java.util.ArrayList;
import java.util.List;

public class Historic {

	private List<Operation> operations = new ArrayList<>();

	public void saveOperation(Operation operation) {
		this.operations.add(operation);
	}

	public List<Operation> getOperations() {
		return operations;
	}
}
