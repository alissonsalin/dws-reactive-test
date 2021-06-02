package dws.reactive.test.exception.handler;

import dws.reactive.test.filter.BandFilter;

public interface BandCompareFilterFactory {
	public BandFilter getCompareFilter(String bandFilterType);
}
