package org.vaadin.highlighter;

import org.vaadin.highlighter.client.state.ComponentHighlighterState;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.server.VaadinService;

public class ComponentHighlighterExtension extends AbstractExtension {

	@Override
	public void extend(AbstractClientConnector target) {
		if (VaadinService.getCurrent().getDeploymentConfiguration().isProductionMode()) {
			return;
		}
		super.extend(target);
		setComponentDebugLabel(target.getClass().getCanonicalName());
	}

	@Override
	protected ComponentHighlighterState getState() {
		return (ComponentHighlighterState) super.getState();
	}

	public void setComponentDebugLabel(String label) {
		getState().debugLabel = label;
	}

}
