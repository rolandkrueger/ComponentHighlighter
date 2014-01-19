package org.vaadin.highlighter.client.extension;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;

/**
 * <p>
 * Default sub-interface of {@link ComponentHighlighterResources} which will be
 * used unless otherwise configured in the widgetset descriptor. This default
 * interface will link the included highlighter.css file with the
 * {@link CssResource} provided by this client bundle.
 * </p>
 * <p>
 * If you want to define your own CSS styles for the component highlighter, you
 * need to write an own sub-interface of {@link ComponentHighlighterResources}
 * that refers to your own css-file in the same way as is done by this
 * interface. This custom interface has then to be provided by your own
 * implementation of {@link ResourceProvider}.
 * </p>
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
