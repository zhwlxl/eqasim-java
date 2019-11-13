package org.eqasim.los_angeles.mode_choice.utilities.estimators;

import java.util.List;

import org.eqasim.core.simulation.mode_choice.utilities.estimators.PtUtilityEstimator;
import org.eqasim.core.simulation.mode_choice.utilities.predictors.PersonPredictor;
import org.eqasim.core.simulation.mode_choice.utilities.predictors.PtPredictor;
import org.eqasim.core.simulation.mode_choice.utilities.variables.PtVariables;
import org.eqasim.los_angeles.mode_choice.parameters.LosAngelesModeParameters;
import org.eqasim.los_angeles.mode_choice.utilities.predictors.LosAngelesPersonPredictor;
import org.eqasim.los_angeles.mode_choice.utilities.variables.LosAngelesPersonVariables;
import org.matsim.api.core.v01.population.Person;
import org.matsim.api.core.v01.population.PlanElement;

import com.google.inject.Inject;

import ch.ethz.matsim.discrete_mode_choice.model.DiscreteModeChoiceTrip;

public class LosAngelesPTUtilityEstimator extends PtUtilityEstimator {
	private final LosAngelesModeParameters parameters;
	private final LosAngelesPersonPredictor predictor;
	private final PtPredictor ptPredictor;

	@Inject
	public LosAngelesPTUtilityEstimator(LosAngelesModeParameters parameters, PersonPredictor personPredictor,
			PtPredictor ptPredictor, LosAngelesPersonPredictor predictor) {
		super(parameters, ptPredictor);
		this.ptPredictor = ptPredictor;
		this.parameters = parameters;
		this.predictor = predictor;
	}

	protected double estimateRegionalUtility(LosAngelesPersonVariables variables) {
		return (variables.cityTrip) ? parameters.laPT.alpha_pt_city : 0.0;
	}

	@Override
	public double estimateUtility(Person person, DiscreteModeChoiceTrip trip, List<? extends PlanElement> elements) {
		LosAngelesPersonVariables variables = predictor.predictVariables(person, trip, elements);
		PtVariables variables_pt = ptPredictor.predict(person, trip, elements);

		double utility = 0.0;

		utility += estimateConstantUtility();
		utility += estimateAccessEgressTimeUtility(variables_pt);
		utility += estimateInVehicleTimeUtility(variables_pt);
		utility += estimateWaitingTimeUtility(variables_pt);
		utility += estimateLineSwitchUtility(variables_pt);
		utility += estimateRegionalUtility(variables);
		utility += estimateMonetaryCostUtility(variables_pt)
				* (parameters.laAvgHHLIncome.avg_hhl_income / variables.hhlIncome);

		return utility;
	}
}