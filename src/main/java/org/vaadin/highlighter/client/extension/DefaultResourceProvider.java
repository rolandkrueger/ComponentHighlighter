/*
 * Copyright 2014 Roland Krüger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.vaadin.highlighter.client.extension;

import com.google.gwt.core.client.GWT;

/**
 * {@link ResourceProvider} which is used by default in the
 * {@link ComponentHighlighterConnector} when no other subclass of
 * {@link ResourceProvider} is configured in the widgetset descriptor through
 * GWT's deferred binding mechanism.
 * 
 * @author Roland Krüger
 * @see ResourceProvider ResourceProvider for more information on
 *      configuratively swapping the CssResource used by this extension
 */
public class DefaultResourceProvider implements ResourceProvider {

  /**
   * Instance of the sub-interface of {@link ComponentHighlighterResources} to
   * be used by default.
   */
  private static final DefaultComponentHighlighterResources HIGHLIGHTER_RESOURCES = GWT
      .create(DefaultComponentHighlighterResources.class);

  /**
   * Returns the {@link DefaultComponentHighlighterResources} interface instance
   * created by GWT.
   */
  public ComponentHighlighterResources getResources() {
    return HIGHLIGHTER_RESOURCES;
  }
}
