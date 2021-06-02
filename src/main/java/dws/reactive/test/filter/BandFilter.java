package dws.reactive.test.filter;

import java.util.Comparator;

import dws.reactive.test.model.Band;

public interface BandFilter {
	public Comparator<Band> getFilter();
}
