package de.fraunhofer.iais.kd.bda.spark;

import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

public class UserSet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Set<String> userSet = new HashSet<String>();

	public UserSet add(String username) {

		userSet.add(username);

		return this;
	}

	public UserSet add(UserSet set) {

		userSet.addAll(set.userSet);

		return this;
	}

	public double distanceTo(UserSet otherUserSet) {

		final Set<String> intersection = new HashSet<>(otherUserSet.userSet);
		intersection.retainAll(this.userSet);

		final Set<String> unionSet = new HashSet<>(otherUserSet.userSet);
		unionSet.addAll(this.userSet);

		return 1 - (double) intersection.size() / unionSet.size();
	}

	@Override
	public String toString() {
		return userSet.toString();
	}

}
