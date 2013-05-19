package org.vaadin.highlighter.client.extension;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;

/**
 * Default sub-interface of {@link ComponentHighlighterResources} which will be
 * used unless otherwise configured in the widgetset descriptor. This default
 * interface will link the included highlighter.css file with the
 * {@link CssResource} provided by this client bundle.
 * 
 * @author Roland Krüger
 * @see ResourceProvider for more information on configuratively swapping the
 *      {@link CssResource} used by this extension
 */
public interface DefaultComponentHighlighterResources extends ComponentHighlighterResources {

  public static final DefaultComponentHighlighterResources HIGHLIGHTER_RESOURCE = GWT
      .create(DefaultComponentHighlighterResources.class);

  @Source("highlighter.css")
  ComponentHighlighterStyle style();
}
