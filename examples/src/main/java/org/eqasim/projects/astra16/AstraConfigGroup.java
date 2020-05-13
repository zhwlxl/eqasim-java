package org.eqasim.projects.astra16;

import org.matsim.core.config.Config;
import org.matsim.core.config.ReflectiveConfigGroup;

public class AstraConfigGroup extends ReflectiveConfigGroup {
	static public final String GROUP_NAME = "astra";

	static public final String FLEET_SIZE = "fleetSize";
	static public final String OPERATING_AREA_PATH = "operatingAreaPath";
	static public final String OPERATING_AREA_INDEX_ATTRIBUTE = "operatingAreaIndexAttribute";

	static public final String MAXIMUM_PRICE_PER_KM_CHF = "maximumPricePerKm_CHF";
	static public final String MINIMUM_PRICE_PER_KM_CHF = "minimumPricePerKm_CHF";
	static public final String TRIP_FARE_CHF = "tripFare_CHF";

	static public final String PRICE_INTERPOLATION_FACTOR = "priceInterpolationFactor";
	static public final String INITIAL_PRICE_PER_KM_CHF = "initialPricePerKm_CHF";
	static public final String PRICE_INTERPOLATION_START_ITERATION = "priceInterpolationStartIteration";

	static public final String MINIMUM_AV_DISTANCE_KM = "minimumAvDistance_km";

	static public final String INFRASTRCTURE_COST_PER_KM_CHF = "infrastructureCostPerKm_CHF";

	static public final String BIKE_AVAILABILITY = "bikeAvailability";

	private int fleetSize = 0;
	private String operatingAreaPath = null;
	private String operatingAreaIndexAttribute = "wgIndex";

	private double maximumPricePerKm_CHF = Double.POSITIVE_INFINITY;
	private double minimumPricePerKm_CHF = 0.0;
	private double tripFare_CHF = 0.0;

	private double priceInterpolationFactor = 0.1;
	private double initialPricePerKm_CHF = 0.4;
	private int priceInterpolationStartIteration = 10;

	private double minimumAvDistance_km = 0.25;

	private double infrastructureCostPerKm_CHF = 0.0;

	private double bikeAvailability = 1.0;

	public AstraConfigGroup() {
		super(GROUP_NAME);
	}

	@StringGetter(FLEET_SIZE)
	public int getFleetSize() {
		return fleetSize;
	}

	@StringSetter(FLEET_SIZE)
	public void setFleetSize(int fleetSize) {
		this.fleetSize = fleetSize;
	}

	@StringGetter(OPERATING_AREA_PATH)
	public String getOperatingAreaPath() {
		return operatingAreaPath;
	}

	@StringSetter(OPERATING_AREA_PATH)
	public void setOperatingAreaPath(String operatingAreaPath) {
		this.operatingAreaPath = operatingAreaPath;
	}

	@StringGetter(OPERATING_AREA_INDEX_ATTRIBUTE)
	public String getOperatingAreaIndexAttribute() {
		return operatingAreaIndexAttribute;
	}

	@StringSetter(OPERATING_AREA_INDEX_ATTRIBUTE)
	public void setOperatingAreaIndexAttribute(String operatingAreaIndexAttribute) {
		this.operatingAreaIndexAttribute = operatingAreaIndexAttribute;
	}

	@StringGetter(MAXIMUM_PRICE_PER_KM_CHF)
	public double getMaximumPricePerKm_CHF() {
		return maximumPricePerKm_CHF;
	}

	@StringSetter(MAXIMUM_PRICE_PER_KM_CHF)
	public void setMaximumPricePerKm_CHF(double maximumPricePerKm_CHF) {
		this.maximumPricePerKm_CHF = maximumPricePerKm_CHF;
	}

	@StringGetter(MINIMUM_PRICE_PER_KM_CHF)
	public double getMinimumPricePerKm_CHF() {
		return minimumPricePerKm_CHF;
	}

	@StringSetter(MINIMUM_PRICE_PER_KM_CHF)
	public void setMinimumPricePerKm_CHF(double minimumPricePerKm_CHF) {
		this.minimumPricePerKm_CHF = minimumPricePerKm_CHF;
	}

	@StringGetter(TRIP_FARE_CHF)
	public double getTripFare_CHF() {
		return tripFare_CHF;
	}

	@StringSetter(TRIP_FARE_CHF)
	public void setTripFare_CHF(double tripFare_CHF) {
		this.tripFare_CHF = tripFare_CHF;
	}

	@StringGetter(INITIAL_PRICE_PER_KM_CHF)
	public double getInitialPricePerKm_CHF() {
		return initialPricePerKm_CHF;
	}

	@StringSetter(INITIAL_PRICE_PER_KM_CHF)
	public void setInitialPricePerKm_CHF(double initialPricePerKm_CHF) {
		this.initialPricePerKm_CHF = initialPricePerKm_CHF;
	}

	@StringGetter(PRICE_INTERPOLATION_START_ITERATION)
	public int getPriceInterpolationStartIteration() {
		return priceInterpolationStartIteration;
	}

	@StringSetter(PRICE_INTERPOLATION_START_ITERATION)
	public void setPriceInterpolationStartIteration(int priceInterpolationStartIteration) {
		this.priceInterpolationStartIteration = priceInterpolationStartIteration;
	}

	@StringGetter(PRICE_INTERPOLATION_FACTOR)
	public double getPriceInterpolationFactor() {
		return priceInterpolationFactor;
	}

	@StringSetter(PRICE_INTERPOLATION_FACTOR)
	public void setPriceInterpolationFactor(double priceInterpolationFactor) {
		this.priceInterpolationFactor = priceInterpolationFactor;
	}

	@StringGetter(MINIMUM_AV_DISTANCE_KM)
	public double getMinimumAvDistance_km() {
		return minimumAvDistance_km;
	}

	@StringSetter(MINIMUM_AV_DISTANCE_KM)
	public void setMinimumAvDistance_km(double minimumAvDistance_km) {
		this.minimumAvDistance_km = minimumAvDistance_km;
	}

	@StringGetter(INFRASTRCTURE_COST_PER_KM_CHF)
	public double getInfrastructureCostPerKm_CHF() {
		return infrastructureCostPerKm_CHF;
	}

	@StringSetter(INFRASTRCTURE_COST_PER_KM_CHF)
	public void setInfrastructureCostPerKm_CHF(double infrastructureCostPerKm_CHF) {
		this.infrastructureCostPerKm_CHF = infrastructureCostPerKm_CHF;
	}

	@StringGetter(BIKE_AVAILABILITY)
	public double getBikeAvailability() {
		return bikeAvailability;
	}

	@StringSetter(BIKE_AVAILABILITY)
	public void setBikeAvailability(double bikeAvailability) {
		this.bikeAvailability = bikeAvailability;
	}

	static public AstraConfigGroup get(Config config) {
		if (!config.getModules().containsKey(GROUP_NAME)) {
			config.addModule(new AstraConfigGroup());
		}

		return (AstraConfigGroup) config.getModules().get(GROUP_NAME);
	}
}