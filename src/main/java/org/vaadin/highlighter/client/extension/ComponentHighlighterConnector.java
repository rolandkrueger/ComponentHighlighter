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

@Connect(ComponentHighlighterExtension.class)
public class ComponentHighlighterConnector extends AbstractExtensionConnector {
  private Widget widget;
  private Element span;

  private static ResourceProvider resourceProvider;

  static {
    resourceProvider = GWT.create(DefaultResourceProvider.class);
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
      return;
    }

    if (span == null) {
      span = DOM.createSpan();
    }

    DOM.insertChild(widget.getElement(), span, 0);
    span.addClassName(resourceProvider.getResources().style().debugLabel());
    widget.addStyleName(resourceProvider.getResources().style().parentOutline());
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
