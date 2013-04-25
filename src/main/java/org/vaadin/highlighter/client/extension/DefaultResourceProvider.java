package org.vaadin.highlighter.client.extension;

import com.google.gwt.core.client.GWT;

public class DefaultResourceProvider implements ResourceProvider {

	private static final DefaultComponentHighlighterResources	HIGHLIGHTER_RESOURCES	= GWT.create(DefaultComponentHighlighterResources.class);

	public ComponentHighlighterResources getResources() {
		return HIGHLIGHTER_RESOURCES;
	}
}
