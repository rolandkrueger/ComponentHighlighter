package org.vaadin.highlighter.client.extension;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Client Bundle interface for the component highlighter. This interface
 * provides the {@link ComponentHighlighterStyle} {@link CssResource} needed for
 * styling the highlighting label.
 * 
 * @author Roland Krüger
 * 
 */
public interface ComponentHighlighterResources extends ClientBundle {
  ComponentHighlighterStyle style();
}
