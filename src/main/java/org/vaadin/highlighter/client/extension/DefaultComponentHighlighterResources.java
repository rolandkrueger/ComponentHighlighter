package org.vaadin.highlighter.client.extension;

import com.google.gwt.core.client.GWT;

public interface DefaultComponentHighlighterResources extends ComponentHighlighterResources {

	public static final DefaultComponentHighlighterResources	HIGHLIGHTER_RESOURCE	= GWT.create(DefaultComponentHighlighterResources.class);

	@Source("highlighter.css")
	ComponentHighlighterStyle style();
}
