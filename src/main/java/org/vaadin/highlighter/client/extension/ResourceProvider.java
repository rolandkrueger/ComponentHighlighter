package org.vaadin.highlighter.client.extension;

import com.google.gwt.resources.client.CssResource;

/**
 * <p>
 * Interface that provides the concrete client bundle interface to be used by
 * the {@link ComponentHighlighterConnector}. If nothing different is configured
 * through the widgetset definition (GWT module descriptor), then GWT will
 * create a {@link DefaultResourceProvider} instance in
 * {@link ComponentHighlighterConnector} as {@link ResourceProvider}. This
 * default resource provider will ensure that the {@link CssResource}s as
 * defined in highlighter.css are used by default.
 * </p>
 * <p>
 * This can be changed through GWT's deferred binding mechanism.
 * </p>
 * 
 * @author Roland Krüger
 */
public interface ResourceProvider {
  public ComponentHighlighterResources getResources();
}
