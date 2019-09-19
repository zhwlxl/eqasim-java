package org.eqasim.projects.dynamic_av.mode_choice.utilities.predictors;

import org.matsim.api.core.v01.population.Person;

import ch.ethz.matsim.discrete_mode_choice.model.DiscreteModeChoiceTrip;

public class DAPredictorUtils {
	static public double getHouseholdIncome(Person person) {
		return (Double) person.getAttributes().getAttribute("householdIncome");
	}

	static public boolean isAgeOver60(Person person) {
		return (int) (Integer) person.getAttributes().getAttribute("age") >= 60;
	}

	static public boolean hasPurposeWork(DiscreteModeChoiceTrip trip) {
		return trip.getDestinationActivity().getType().equals("work");
	}
}
