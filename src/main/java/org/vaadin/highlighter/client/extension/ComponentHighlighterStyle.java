package org.vaadin.highlighter.client.extension;

import com.google.gwt.resources.client.CssResource;

/**
 * {@link CssResource} interface for the component highlighter. This resource
 * interface provides two style names for the highlighter. The first style
 * {@link #parentOutline()} is set on the extended component's widget itself.
 * This can be used to style the component's widget itself. This style is
 * currently only set on the widget, but its CSS definition is empty. The second
 * style {@link #debugLabel()} will be set on the highlighting label itself. By
 * default, a pink background color is set for this label so that it stands out
 * when rendered in the browser.
 * 
 * @author Roland Krüger
 * 
 */
public interface ComponentHighlighterStyle extends CssResource {
  /**
   * CSS style name set on the extended component's widget.
   */
  String parentOutline();

  /**
   * CSS style name set on the highlighting label span-element.
   */
  String debugLabel();
}
