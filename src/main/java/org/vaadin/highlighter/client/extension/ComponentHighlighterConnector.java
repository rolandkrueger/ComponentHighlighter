package org.vaadin.highlighter.client.extension;

import org.vaadin.highlighter.ComponentHighlighterExtension;
import org.vaadin.highlighter.client.state.ComponentHighlighterState;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window.Location;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

/**
 * Connector class for the {@link ComponentHighlighterExtension}.
 * 
 * @author Roland Krüger
 * 
 */
@Connect(ComponentHighlighterExtension.class)
public class ComponentHighlighterConnector extends AbstractExtensionConnector {
  /**
   * The extended component's widget.
   */
  private Widget widget;

  /**
   * Span element that will contain the highlighting label's text content.
   */
  private Element span;

  /**
   * Resource provider which will provide for the needed CSS resource bundle.
   */
  private static ResourceProvider resourceProvider;

  static {
    resourceProvider = GWT.create(DefaultResourceProvider.class);
    // inject the extra CSS styles
    resourceProvider.getResources().style().ensureInjected();
  }

  @Override
  protected void extend(ServerConnector target) {
    widget = ((ComponentConnector) target).getWidget();
    refresh();
  }

  private void refresh() {
    String debugParam = Location.getParameter("debug");
    if (debugParam == null) {
      // if the 'debug' URL parameter is currently not in use, don't make the
      // highlighting label visible
      return;
    }

    if (span == null) {
      span = DOM.createSpan();
    }

    // add the hightlighting label as the first child element of the extended
    // component's widget
    DOM.insertChild(widget.getElement(), span, 0);

    span.addClassName(resourceProvider.getResources().style().debugLabel());
    widget.addStyleName(resourceProvider.getResources().style().parentOutline());

    // set the label's text which is set on the server-side
    span.setInnerText(getState().debugLabel);
  }

  @Override
  public void onStateChanged(StateChangeEvent stateChangeEvent) {
    super.onStateChanged(stateChangeEvent);
    refresh();
  }

  @Override
  public ComponentHighlighterState getState() {
    return (ComponentHighlighterState) super.getState();
  }
}
