package com.fluxtream.connectors.twitter;

import java.util.Date;

import com.fluxtream.OutsideTimeBoundariesException;
import com.fluxtream.TimeInterval;
import com.fluxtream.connectors.vos.AbstractInstantFacetVO;
import com.fluxtream.domain.GuestSettings;

public class TwitterMentionFacetVO extends AbstractInstantFacetVO<TwitterMentionFacet> {

	public String text;
	public String profileImageUrl;
	public String userName;
	
	@Override
	public void fromFacet(TwitterMentionFacet facet, TimeInterval timeInterval, GuestSettings settings) throws OutsideTimeBoundariesException {
		startMinute = toMinuteOfDay(new Date(facet.time), timeInterval.getTimeZone(facet.start));
		text = facet.text;
		description = facet.text;
		this.profileImageUrl = facet.profileImageUrl;
		this.userName = facet.userName;
	}

}
